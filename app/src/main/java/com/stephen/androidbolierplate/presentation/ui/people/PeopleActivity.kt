package com.stephen.androidbolierplate.presentation.ui.people

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.databinding.ActivityPeopleBinding
import com.stephen.androidbolierplate.interfaces.ClickListener
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import com.stephen.androidbolierplate.presentation.ui.chat.ChatActivity
import com.stephen.androidbolierplate.presentation.ui.main.people.PeopleAdapter
import com.stephen.androidbolierplate.presentation.ui.main.people.PeopleViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PeopleActivity : BaseActivity() {

    private val binding by lazy { ActivityPeopleBinding.inflate(layoutInflater) }
    private val peopleViewModel: PeopleViewModel by viewModels()

    private val userId by lazy {
        intent.getStringExtra("userId")
    }

    private val friendsAdapter = PeopleAdapter(object : ClickListener<UserModel> {
        override fun onClick(t: UserModel) {
            startActivity(
                Intent(this@PeopleActivity, ChatActivity::class.java).apply {
                    putExtra(ChatRoomModel::class.java.name, Gson().toJson(t))
                    putExtra("userId", userId)
                }
            )
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        getFriends()
    }

    private fun initViews() {
        binding.apply {
            buttonClose.setOnClickListener { finish() }
            recyclerViewFriends.adapter = friendsAdapter
        }
    }

    private fun getFriends() {
        lifecycleScope.launch {
            peopleViewModel.getFriends()
                .catch { }
                .collectLatest {
                    friendsAdapter.submitData(it)
                }
        }
    }
}