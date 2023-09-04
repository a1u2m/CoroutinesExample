package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowTwentyOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase21)
    }
    private lateinit var binding: FragmentFlowTwentyOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}