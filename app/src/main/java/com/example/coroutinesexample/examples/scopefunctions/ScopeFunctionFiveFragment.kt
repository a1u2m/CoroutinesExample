package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScopeFunctionFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase6)
    }
    private lateinit var binding: FragmentScopefunctionFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionFiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase5Action1))
            for (i in 0..Long.MAX_VALUE) {
                loggerVM.addLog(i.toString())
                delay(1000)
            }
        }
    }
}