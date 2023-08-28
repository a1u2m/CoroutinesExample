package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSevenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowSevenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase7)
    }
    lateinit var binding: FragmentFlowSevenBinding
    private val lettersFlow = flow {
        emit("a")
        delay(1000)
        emit("b")
        delay(1000)
        emit("c")
        delay(1000)
        emit("d")
        delay(1000)
        emit("e")
        delay(1000)
        emit("f")
        delay(1000)
        emit("g")
        delay(1000)
        emit("h")
        delay(1000)
        emit("i")
        delay(1000)
        emit("j")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSevenBinding.inflate(inflater, container, false)
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
        flow {
            delay(1000)
            emit(1)
            delay(1000)
            emitAll(lettersFlow)
            delay(1000)
            emit(2)
        }.collect {
            doWork(it)
        }
    }

    private fun doWork(i: Comparable<*>) {
        loggerVM.addLog(i.toString())
    }
}