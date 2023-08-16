package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentChannelNineBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelNineFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase9)
    }
    lateinit var binding: FragmentChannelNineBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelNineBinding.inflate(inflater, container, false)
        return binding.root
    }
}