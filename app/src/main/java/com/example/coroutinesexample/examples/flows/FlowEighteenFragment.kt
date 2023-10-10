package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowEighteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FlowEighteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase18)
    }
    private lateinit var binding: FragmentFlowEighteenBinding
    val flow = flowOf(1, 2, 3, 4, 5)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowEighteenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonWTryCatch.setOnClickListener {
            tryCatchExample()
        }
        binding.buttonWOTryCatch.setOnClickListener {
            justExample()
        }
    }

    private fun tryCatchExample() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase18Action2))
            try {
                flow.collect {
                    delay(500)
                    loggerVM.addLog(resources.getString(R.string.flowsCase18Action1, it))
                    if (it == 3) cancel()
                }
            } catch (e: Exception) {
                loggerVM.addLog(resources.getString(R.string.flowsCase18Action3, e))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase18Action4))
        }
    }

    private fun justExample() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase18Action2))
            flow.collect {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase18Action1, it))
                if (it == 3) cancel()
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase18Action4))
        }
    }
}