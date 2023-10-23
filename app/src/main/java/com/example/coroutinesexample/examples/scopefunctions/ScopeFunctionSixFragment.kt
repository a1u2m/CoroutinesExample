package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionSixBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionSixFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase7)
    }
    private lateinit var binding: FragmentScopefunctionSixBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionSixBinding.inflate(inflater, container, false)
        return binding.root
    }
}