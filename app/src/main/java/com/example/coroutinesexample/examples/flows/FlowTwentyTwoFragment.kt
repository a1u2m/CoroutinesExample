package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowTwentyTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase12)
    }
    lateinit var binding: FragmentFlowTwentyTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}