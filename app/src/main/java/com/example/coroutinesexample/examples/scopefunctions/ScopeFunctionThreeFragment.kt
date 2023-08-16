package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFunctionThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase3)
    }
    lateinit var binding: FragmentScopefunctionThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}