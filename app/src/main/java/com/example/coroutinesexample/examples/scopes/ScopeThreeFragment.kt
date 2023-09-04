package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ScopeThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase3)
    }
    private lateinit var binding: FragmentScopeThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}