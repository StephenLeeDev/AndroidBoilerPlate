package com.stephen.androidbolierplate.presentation.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stephen.androidbolierplate.R
import com.stephen.androidbolierplate.databinding.FragmentMyPageBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment

class MyPageFragment : BaseFragment() {

    private val binding by lazy { FragmentMyPageBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }
}