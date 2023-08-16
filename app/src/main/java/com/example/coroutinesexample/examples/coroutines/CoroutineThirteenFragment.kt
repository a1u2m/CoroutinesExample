package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineThirteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineThirteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase13)
    }
    lateinit var binding: FragmentCoroutineThirteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineThirteenBinding.inflate(inflater, container, false)
        return binding.root
    }
}