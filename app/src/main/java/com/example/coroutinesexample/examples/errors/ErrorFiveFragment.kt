package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase5)
    }
    lateinit var binding: FragmentErrorFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}