package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineTwelveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineTwelveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase12)
    }
    private lateinit var binding: FragmentCoroutineTwelveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineTwelveBinding.inflate(inflater, container, false)
        return binding.root
    }
}