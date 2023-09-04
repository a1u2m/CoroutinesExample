package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentChannelThirteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelThirteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase13)
    }
    private lateinit var binding: FragmentChannelThirteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelThirteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}