package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSixteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowSixteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase16)
    }
    private lateinit var binding: FragmentFlowSixteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSixteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}