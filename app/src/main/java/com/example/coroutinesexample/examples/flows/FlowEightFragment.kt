package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowEightBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowEightFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase8)
    }
    lateinit var binding: FragmentFlowEightBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowEightBinding.inflate(inflater, container, false)
        return binding.root
    }
}