package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentChannelThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase3)
    }
    lateinit var binding: FragmentChannelThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}