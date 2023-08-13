package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coroutinesexample.databinding.FragmentDispatcherFourBinding

class DispatcherFourFragment : Fragment() {

    lateinit var binding: FragmentDispatcherFourBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherFourBinding.inflate(inflater, container, false)
        return binding.root
    }
}