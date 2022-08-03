package com.stephen.androidbolierplate.presentation.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.stephen.androidbolierplate.databinding.FragmentMyPageBinding
import com.stephen.androidbolierplate.presentation.ui.auth.SignInActivity
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment
import com.stephen.androidbolierplate.presentation.ui.main.UserViewModel

class MyPageFragment : BaseFragment() {

    private val binding by lazy { FragmentMyPageBinding.inflate(layoutInflater) }
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViews()
        initGoogleSignIn()
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            model = userViewModel.userInfo.value

            buttonLogout.setOnClickListener {
                googleSignInClient.signOut().addOnCompleteListener {
                    userViewModel.signOut()
                    startActivity(Intent(requireActivity(), SignInActivity::class.java))
                    requireActivity().finishAffinity()
                }
            }
        }
    }

    private fun initGoogleSignIn() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }

}