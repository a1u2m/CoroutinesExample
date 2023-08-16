package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.databinding.FragmentErrorSixBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorSixFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase6)
    }
    lateinit var binding: FragmentErrorSixBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorSixBinding.inflate(inflater, container, false)
        return binding.root
    }
}