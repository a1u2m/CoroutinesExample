package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase1)
    }
    lateinit var binding: FragmentFlowOneBinding
    private lateinit var flow: Flow<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreate.setOnClickListener {
            createFlow()
        }
        binding.buttonFirstSub.setOnClickListener {
            lifecycleScope.launch {
                subscribeFirstSub(1)
            }
        }
        binding.buttonSecondSub.setOnClickListener {
            lifecycleScope.launch {
                subscribeSecondSub(2)
            }
        }
        binding.buttonThirdSub.setOnClickListener {
            lifecycleScope.launch {
                subscribeThirdSub(3)
            }
        }
    }

    private fun createFlow() {
        flow = flow {
            for (i in 1..10) {
                delay(1000)
                emit(i)
            }
        }
    }

    private suspend fun subscribeFirstSub(number: Int) {
        flow.collect { i ->
            doWork(number, i)
        }
    }

    private suspend fun subscribeSecondSub(number: Int) {
        flow.collect { i ->
            doWork(number, i)
        }
    }

    private suspend fun subscribeThirdSub(number: Int) {
        flow.collect { i ->
            doWork(number, i)
        }
    }

    private fun doWork(number: Int, i: Int) {
        loggerVM.addLog(resources.getString(R.string.flowsCase1Action1, number, i))
    }
}