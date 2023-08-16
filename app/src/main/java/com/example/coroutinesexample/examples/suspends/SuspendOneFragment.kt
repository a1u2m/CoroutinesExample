package com.example.coroutinesexample.examples.suspends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.examples.BaseExampleFragment

class SuspendOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.suspendCase1)
    }
    lateinit var binding: FragmentSuspendOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuspendOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}