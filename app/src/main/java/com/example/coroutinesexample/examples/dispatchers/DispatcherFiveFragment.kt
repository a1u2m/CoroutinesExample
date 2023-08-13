package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.databinding.FragmentDispatcherFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class DispatcherFiveFragment : BaseExampleFragment() {

    override val description = "Пятый пример с диспетчером"
    lateinit var binding: FragmentDispatcherFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}