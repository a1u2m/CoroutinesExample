package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowSixteenBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.produceIn
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import java.lang.ArithmeticException

class FlowSixteenFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase16)
    }
    private lateinit var binding: FragmentFlowSixteenBinding
    private var counter = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowSixteenBinding.inflate(inflater, container, false)
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
            loggerVM.addLog(resources.getString(R.string.flowsCase16Action2))
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
            }.retry(2) {
                loggerVM.addLog(resources.getString(R.string.flowsCase16Action3, it))
                loggerVM.addLog(resources.getString(R.string.flowsCase16Action4, counter))
                counter++
                it is ArithmeticException
            }.catch {
                loggerVM.addLog(resources.getString(R.string.flowsCase16Action5, it))
            }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase16Action1, it))
            }
        }
    }
}