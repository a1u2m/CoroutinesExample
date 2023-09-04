package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSeventeenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowSeventeenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase17)
    }
    private lateinit var binding: FragmentFlowSeventeenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSeventeenBinding.inflate(inflater, container, false)
        return binding.root
    }
}