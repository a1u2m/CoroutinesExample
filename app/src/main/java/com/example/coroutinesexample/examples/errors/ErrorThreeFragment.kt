package com.example.coroutinesexample.examples.errors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.databinding.FragmentErrorThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class ErrorThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.errorsCase3)
    }
    lateinit var binding: FragmentErrorThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}