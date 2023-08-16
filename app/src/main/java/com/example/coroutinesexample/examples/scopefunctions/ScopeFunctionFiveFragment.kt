package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase5)
    }
    lateinit var binding: FragmentScopefunctionFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}