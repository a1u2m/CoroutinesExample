package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase1)
    }
    private lateinit var binding: FragmentScopefunctionOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}