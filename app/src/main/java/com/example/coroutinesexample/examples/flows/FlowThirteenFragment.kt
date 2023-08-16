package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowThirteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase13)
    }
    lateinit var binding: FragmentFlowThirteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowThirteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}