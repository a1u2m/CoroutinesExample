package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase7)
    }
    lateinit var binding: FragmentErrorSevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorSevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}