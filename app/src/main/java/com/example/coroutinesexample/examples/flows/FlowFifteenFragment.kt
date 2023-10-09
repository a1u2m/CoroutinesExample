package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowFifteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowFifteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase15)
    }
    private lateinit var binding: FragmentFlowFifteenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowFifteenBinding.inflate(inflater, container, false)
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
            flow {
                delay(500)
                emit(1)
                delay(500)
                emit(2)
                delay(500)
                emit(3)
                delay(500)
                emit(1 / 0)
                delay(500)
                emit(4)
                delay(500)
                emit(5)
            }.catch { loggerVM.addLog(resources.getString(R.string.flowsCase15Action1, it)) }
                .collect {
                    loggerVM.addLog(resources.getString(R.string.flowsCase15Action2, it))
                }
            loggerVM.addLog(resources.getString(R.string.flowsCase15Action3))
        }
    }
}