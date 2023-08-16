package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase4)
    }
    lateinit var binding: FragmentScopeFourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeFourBinding.inflate(inflater, container, false)
        return binding.root
    }
}