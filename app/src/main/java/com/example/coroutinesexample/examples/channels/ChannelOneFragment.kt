package com.example.coroutinesexample.examples.channels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class ChannelOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.channelsCase1)
    }
    lateinit var binding: FragmentChannelOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChannelOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}