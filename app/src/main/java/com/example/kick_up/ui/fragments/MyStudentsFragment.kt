package com.example.kick_up.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kick_up.databinding.FragmentMyStudentsBinding
import com.example.kick_up.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MyStudentsFragment : BaseFragment<FragmentMyStudentsBinding>() {
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMyStudentsBinding {
        return FragmentMyStudentsBinding.inflate(inflater,container,false)
    }

    override fun setupViews() {

    }

    override fun setupObservers() {

    }

}