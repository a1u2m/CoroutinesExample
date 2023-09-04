package com.example.coroutinesexample.examples.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentCoroutineFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class CoroutineFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.coroutinesCase5)
    }
    private lateinit var binding: FragmentCoroutineFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoroutineFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}