package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ScopeFunctionThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase4)
    }
    private lateinit var binding: FragmentScopefunctionThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        runBlocking {
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action1,
                    Thread.currentThread().name
                )
            )
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action2,
                    Thread.currentThread().name
                )
            )
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action3,
                    Thread.currentThread().name
                )
            )
            delay(1000)
        }
        loggerVM.addLog(
            resources.getString(
                R.string.scopeFunctionsCase3Action4,
                Thread.currentThread().name
            )
        )
        lifecycleScope.launch {
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action5,
                    Thread.currentThread().name
                )
            )
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action6,
                    Thread.currentThread().name
                )
            )
        }
        lifecycleScope.launch {
            delay(1000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase3Action7,
                    Thread.currentThread().name
                )
            )
        }
    }
}