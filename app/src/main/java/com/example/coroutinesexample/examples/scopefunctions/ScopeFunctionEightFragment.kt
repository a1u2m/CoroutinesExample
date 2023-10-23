package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionEightBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionEightFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase2)
    }
    private lateinit var binding: FragmentScopefunctionEightBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionEightBinding.inflate(inflater, container, false)
        return binding.root
    }
}