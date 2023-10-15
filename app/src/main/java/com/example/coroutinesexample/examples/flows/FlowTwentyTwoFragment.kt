package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FlowTwentyTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase22)
    }
    private lateinit var binding: FragmentFlowTwentyTwoBinding
    private val sharedFlow = MutableSharedFlow<Int>()
    private var counter = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            lifecycleScope.launch {
                action()
            }
        }
    }

    private suspend fun action() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter()
        }
        lifecycleScope.launch {
            loggerVM.addLog(
                resources.getString(R.string.flowsCase22Action1, sharedFlow.subscriptionCount.value)
            )
            sharedFlow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase22Action2, it))
            }
        }
        delay(1000)
        lifecycleScope.launch {
            loggerVM.addLog(
                resources.getString(R.string.flowsCase22Action1, sharedFlow.subscriptionCount.value)
            )
            sharedFlow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase22Action3, it))
            }
        }
        delay(1000)
        lifecycleScope.launch {
            loggerVM.addLog(
                resources.getString(R.string.flowsCase22Action1, sharedFlow.subscriptionCount.value)
            )
            sharedFlow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase22Action4, it))
            }
        }
    }

    private suspend fun increaseCounter() {
        repeat(10) {
            delay(500)
            sharedFlow.emit(counter)
            counter++
        }
    }
}