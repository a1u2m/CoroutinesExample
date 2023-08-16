package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class BuilderTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase2)
    }
    lateinit var binding: FragmentBuilderTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}