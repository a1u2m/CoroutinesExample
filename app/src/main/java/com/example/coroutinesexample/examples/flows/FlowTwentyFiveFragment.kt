package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowTwentyFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase25)
    }
    private lateinit var binding: FragmentFlowTwentyFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}