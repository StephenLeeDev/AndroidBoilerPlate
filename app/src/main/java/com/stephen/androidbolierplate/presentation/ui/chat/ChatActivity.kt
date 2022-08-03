package com.stephen.androidbolierplate.presentation.ui.chat

import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.model.chat.ChatMessageModel
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.databinding.ActivityChatBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.dto.LifecycleEvent

class ChatActivity : BaseActivity() {

    private val binding by lazy { ActivityChatBinding.inflate(layoutInflater) }
    private val adapter = ChatMessageAdapter()
    private val stompClient = Stomp.over(Stomp.ConnectionProvider.OKHTTP, BuildConfig.WS_URL)

    private val chatRoomModel by lazy {
        Gson().fromJson(intent.getStringExtra(ChatRoomModel::class.java.name), ChatRoomModel::class.java)
    }
    private val userId by lazy {
        intent.getStringExtra("userId")
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.model = chatRoomModel
        initViews()
        connectSocket()
    }

    private fun initViews() {
        binding.apply {
            buttonClose.setOnClickListener { finish() }

            recyclerView.adapter = adapter

            buttonSend.setOnClickListener {
                val message = editMessage.text.toString()
                if (message.isEmpty()) return@setOnClickListener
                stompClient.send("/pub/chat/room/${chatRoomModel.roomId}",
                    Gson().toJson(
                        ChatMessageModel(
                            message = message,
                            messageId = "", // 서버 측에서 메시지 생성 후에 지정할 값이므로 앱에서 보내줄 필요없음
                            createdDate = "", // 서버 측에서 메시지 생성 후에 지정할 값이므로 앱에서 보내줄 필요없음
                            senderId = userId ?: return@setOnClickListener
                        )
                    )).subscribe()
                editMessage.setText("")
            }
        }
    }

    private fun connectSocket() {

        stompClient.connect()

        stompClient.lifecycle().subscribe { lifecycleEvent ->
            when (lifecycleEvent.type) {
                LifecycleEvent.Type.OPENED -> {
                    if (BuildConfig.DEBUG) Log.d("chatRooms", "OPEND")
                }
                LifecycleEvent.Type.CLOSED -> {
                    if (BuildConfig.DEBUG) Log.d("chatRooms", "CLOSED")
                }
                LifecycleEvent.Type.ERROR -> {
                    if (BuildConfig.DEBUG) Log.d("chatRooms", "ERROR")
                    if (BuildConfig.DEBUG) Log.d("CONNECT ERROR", lifecycleEvent.exception.toString())
                }
                else ->{
                    if (BuildConfig.DEBUG) Log.d("chatRooms", "ELSE")
                    if (BuildConfig.DEBUG) Log.d("chatRooms", lifecycleEvent.message)
                }
            }
        }

        compositeDisposable.add(
            stompClient.topic("/sub/chat/room/${chatRoomModel.roomId}")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ message ->
                    val message = Gson().fromJson(message.payload, ChatMessageModel::class.java)
                    message.setViewType(userId = userId ?: return@subscribe)
                    var messages: List<ChatMessageModel> = adapter.currentList
                    messages = messages + message
                    adapter.submitList(messages)

                    if (BuildConfig.DEBUG) Log.d("chatRooms", message.toString())
                }, {})
        )

        setDummyMessages()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (stompClient.isConnected) stompClient.disconnect()
        compositeDisposable.dispose()
    }

    /**
     * 채팅을 주고받는 UI를 확인할 목적으로 추가한 더미 데이터 입니다
     */
    private fun setDummyMessages() {
        val messages = listOf(
            ChatMessageModel(
                messageId = "1",
                createdDate = "2022-08-03T17:58:18.073",
                message = "안녕하세요. 홍로켓님 잘지내셨나요? 일전에 UX세미나에서 반가웠습니다. 다름이 아니라 부탁드릴 것이 있어서 이렇게 연락드립니다.",
                senderId = "79",
                unreadCount = 0
            ).apply { setViewType("2357") },
            ChatMessageModel(
                messageId = "2",
                createdDate = "2022-08-03T17:58:18.073",
                message = "아 죄송해요. 이제야 메세지를 봤습니다. 저도 반가웠습니다!어떤 부탁인가요?",
                senderId = "2357",
                unreadCount = 0
            ).apply { setViewType("2357") },
            ChatMessageModel(
                messageId = "3",
                createdDate = "2022-08-03T17:58:18.073",
                message = "안녕하세요.",
                senderId = "79",
                unreadCount = 0
            ).apply { setViewType("2357") }
        )
        adapter.submitList(messages)
    }

}