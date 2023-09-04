package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class FlowFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase4)
    }
    private lateinit var binding: FragmentFlowFourBinding
    private lateinit var flow: Flow<Int>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreate.setOnClickListener {
            createFlow()
        }
        binding.buttonFirstSub.setOnClickListener {
            lifecycleScope.launch {
                subscribeFirstSub()
            }
        }
    }

    @OptIn(FlowPreview::class)
    private fun createFlow() {
        flow = ::generateNumber.asFlow()
    }

    private fun generateNumber(): Int {
        return Random.nextInt()
    }

    private suspend fun subscribeFirstSub() {
        flow.collect { i ->
            doWork(i)
        }
    }

    private fun doWork(i: Int) {
        loggerVM.addLog("$i")
    }
}