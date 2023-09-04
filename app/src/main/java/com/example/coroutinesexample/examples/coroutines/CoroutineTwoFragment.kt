package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase2)
    }
    private lateinit var binding: FragmentCoroutineTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}