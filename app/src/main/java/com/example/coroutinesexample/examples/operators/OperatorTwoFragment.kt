package com.example.coroutinesexample.examples.operators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentOperatorTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class OperatorTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.operatorsCase2)
    }
    lateinit var binding: FragmentOperatorTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperatorTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}