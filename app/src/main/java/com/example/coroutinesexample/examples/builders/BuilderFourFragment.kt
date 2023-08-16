package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class BuilderFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase4)
    }
    lateinit var binding: FragmentBuilderFourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderFourBinding.inflate(inflater, container, false)
        return binding.root
    }
}