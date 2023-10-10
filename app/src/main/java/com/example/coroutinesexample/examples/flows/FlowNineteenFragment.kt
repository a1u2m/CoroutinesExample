package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowNineteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FlowNineteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase19)
    }
    private lateinit var binding: FragmentFlowNineteenBinding
    val stateFlow = flow {
        delay(500)
        emit(1)
        delay(500)
        emit(2)
        delay(500)
        emit(3)
        delay(500)
        emit(4)
        delay(500)
        emit(5)
        delay(500)
        emit(6)
        delay(500)
        emit(7)
        delay(500)
        emit(8)
        delay(500)
        emit(9)
        delay(500)
        emit(10)
    }.stateIn(scope = lifecycleScope, started = SharingStarted.WhileSubscribed(), initialValue = 0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowNineteenBinding.inflate(inflater, container, false)
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
            stateFlow.collect {
                loggerVM.addLog("Получен элемент $it, тред - ${Thread.currentThread().name}")
            }
        }
    }
}