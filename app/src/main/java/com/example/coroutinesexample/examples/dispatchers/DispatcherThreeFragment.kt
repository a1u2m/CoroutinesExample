package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.databinding.FragmentDispatcherThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment

class DispatcherThreeFragment : BaseExampleFragment() {

    override val description = "Третий пример с диспетчером"
    lateinit var binding: FragmentDispatcherThreeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}