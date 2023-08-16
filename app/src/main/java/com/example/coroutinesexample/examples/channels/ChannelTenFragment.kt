package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelTenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase10)
    }
    lateinit var binding: FragmentChannelTenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelTenBinding.inflate(inflater, container, false)
        return binding.root
    }
}