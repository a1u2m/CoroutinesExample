package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentChannelFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase5)
    }
    lateinit var binding: FragmentChannelFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}