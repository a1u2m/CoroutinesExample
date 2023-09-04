package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentErrorFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase4)
    }
    private lateinit var binding: FragmentErrorFourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorFourBinding.inflate(inflater, container, false)
        return binding.root
    }
}