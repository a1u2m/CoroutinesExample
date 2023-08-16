package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentChannelSixBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelSixFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase6)
    }
    lateinit var binding: FragmentChannelSixBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelSixBinding.inflate(inflater, container, false)
        return binding.root
    }
}