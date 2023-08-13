package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.databinding.FragmentDispatcherOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class DispatcherOneFragment : BaseExampleFragment() {

    override val description = "Первый пример с диспетчером"
    lateinit var binding: FragmentDispatcherOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}