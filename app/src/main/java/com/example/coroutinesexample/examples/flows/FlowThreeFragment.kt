package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase3)
    }
    lateinit var binding: FragmentFlowThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}