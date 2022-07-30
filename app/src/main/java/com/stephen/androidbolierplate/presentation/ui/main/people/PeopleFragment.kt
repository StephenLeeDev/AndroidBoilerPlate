package com.stephen.androidbolierplate.presentation.ui.main.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stephen.androidbolierplate.R
import com.stephen.androidbolierplate.databinding.FragmentPeopleBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment

class PeopleFragment : BaseFragment() {

    private val binding by lazy { FragmentPeopleBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }
}