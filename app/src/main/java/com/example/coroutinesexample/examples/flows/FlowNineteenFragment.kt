package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowNineteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowNineteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase7)
    }
    lateinit var binding: FragmentFlowNineteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowNineteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}