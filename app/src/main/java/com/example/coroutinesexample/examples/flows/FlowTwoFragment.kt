package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase2)
    }
    lateinit var binding: FragmentFlowTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}