package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class BuilderOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase1)
    }
    lateinit var binding: FragmentBuilderOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}