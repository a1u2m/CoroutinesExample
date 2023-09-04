package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowElevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowElevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase11)
    }
    private lateinit var binding: FragmentFlowElevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowElevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}