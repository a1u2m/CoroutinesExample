package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowEighteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowEighteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase18)
    }
    lateinit var binding: FragmentFlowEighteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowEighteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}