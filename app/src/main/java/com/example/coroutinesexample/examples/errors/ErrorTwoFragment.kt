package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentErrorTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase2)
    }
    private lateinit var binding: FragmentErrorTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}