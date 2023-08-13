package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coroutinesexample.databinding.FragmentDispatcherFiveBinding

class DispatcherFiveFragment : Fragment() {

    lateinit var binding: FragmentDispatcherFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherFiveBinding.inflate(inflater, container, false)
        return binding.root
    }
}