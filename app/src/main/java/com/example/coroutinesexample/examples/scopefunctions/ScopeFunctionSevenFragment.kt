package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionSevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase7)
    }
    private lateinit var binding: FragmentScopefunctionSevenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionSevenBinding.inflate(inflater, container, false)
        return binding.root
    }
}