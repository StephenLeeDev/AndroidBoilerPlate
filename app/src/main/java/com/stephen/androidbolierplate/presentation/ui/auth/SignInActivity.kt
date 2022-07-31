package com.stephen.androidbolierplate.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.databinding.ActivityLoginBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import com.stephen.androidbolierplate.presentation.ui.main.MainActivity
import com.stephen.androidbolierplate.presentation.util.AppUtil

class SignInActivity : BaseActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val authViewModel: AuthViewModel by viewModels()

    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initGoogleSignIn()
        initLauncher()
        initViews()
        initObservers()
    }

    private fun initGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

    }

    private fun initLauncher() {
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleGoogleSignInResult(task)
            }
    }

    private fun initViews() {
        binding.apply {
            buttonGoogleSignIn.setOnClickListener {
                val signInIntent: Intent = googleSignInClient.signInIntent
                launcher.launch(signInIntent)
            }
        }
    }

    private fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)
            authViewModel.googleSocialSignIn(email = account?.email.toString() ?: "")
        } catch (e: ApiException) {
            AppUtil.showToast(
                context = this@SignInActivity,
                message = e.message.toString()
            )
            if (BuildConfig.DEBUG) {
                Log.e("handleGoogleSignInResult", e.message.toString())
            }
        }
    }

    private fun initObservers() {
        authViewModel.goToMain.observe(this@SignInActivity) { isAuthValid ->
            if (isAuthValid) {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }
        }
    }

}