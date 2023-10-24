package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionSevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScopeFunctionSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase8)
    }
    private lateinit var binding: FragmentScopefunctionSevenBinding
    private val scope = CoroutineScope(Job())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionSevenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            actionStart()
        }

        binding.cancelButton.setOnClickListener {
            actionCancel()
        }
    }

    private fun actionStart() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase7Action1))
            for (i in 0..Long.MAX_VALUE) {
                delay(1000)
                loggerVM.addLog(i.toString())
            }
        }
    }

    private fun actionCancel() {
        scope.cancel()
    }
}