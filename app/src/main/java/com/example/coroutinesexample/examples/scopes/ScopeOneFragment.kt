package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase1)
    }
    private lateinit var binding: FragmentScopeOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}