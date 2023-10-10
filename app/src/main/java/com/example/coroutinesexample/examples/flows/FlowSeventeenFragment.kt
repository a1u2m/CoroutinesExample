package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSeventeenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch

class FlowSeventeenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase17)
    }
    private lateinit var binding: FragmentFlowSeventeenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSeventeenBinding.inflate(inflater, container, false)
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
            loggerVM.addLog(resources.getString(R.string.flowsCase17Action1))
            flow {
                delay(500)
                emit(100 / 5)
                delay(500)
                emit(100 / 4)
                delay(500)
                emit(100 / 3)
                delay(500)
                emit(100 / 2)
                delay(500)
                emit(100 / 1)
                delay(500)
                emit(100 / 0)
            }.retryWhen { cause, attempt ->
                loggerVM.addLog(resources.getString(R.string.flowsCase17Action4, cause, attempt))
                cause is ArithmeticException && attempt < 2
            }.catch {
                loggerVM.addLog(resources.getString(R.string.flowsCase17Action2, it))
            }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase17Action3, it))
            }
        }
    }
}