package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineElevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineElevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase11)
    }
    private lateinit var binding: FragmentCoroutineElevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineElevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}