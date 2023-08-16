package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase7)
    }
    lateinit var binding: FragmentFlowSevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}