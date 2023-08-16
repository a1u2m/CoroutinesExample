package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase4)
    }
    lateinit var binding: FragmentFlowFourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowFourBinding.inflate(inflater, container, false)
        return binding.root
    }
}