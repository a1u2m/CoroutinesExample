package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentErrorOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase1)
    }
    private lateinit var binding: FragmentErrorOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}