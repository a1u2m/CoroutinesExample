package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase2)
    }
    lateinit var binding: FragmentChannelTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}