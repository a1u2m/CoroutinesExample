package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentySixBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class FlowTwentySixFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase26)
    }
    private lateinit var binding: FragmentFlowTwentySixBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentySixBinding.inflate(inflater, container, false)
        return binding.root
    }
}