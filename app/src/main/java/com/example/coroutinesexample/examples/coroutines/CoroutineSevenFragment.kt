package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineSevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase7)
    }
    private lateinit var binding: FragmentCoroutineSevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineSevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}