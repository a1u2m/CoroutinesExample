package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class BuilderThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase3)
    }
    lateinit var binding: FragmentBuilderThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}