package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowFifteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowFifteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase15)
    }
    private lateinit var binding: FragmentFlowFifteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowFifteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}