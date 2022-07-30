package com.stephen.androidbolierplate.presentation.ui.main.employment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stephen.androidbolierplate.R
import com.stephen.androidbolierplate.databinding.FragmentEmploymentBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment

class EmploymentFragment : BaseFragment() {

    private val binding by lazy { FragmentEmploymentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employment, container, false)
    }
}