package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlowTwentyFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase25)
    }
    private lateinit var binding: FragmentFlowTwentyFiveBinding
    private val sharedFlowFive = MutableSharedFlow<Int>(
        replay = 5,
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    private val sharedFlowTen = MutableSharedFlow<Int>(
        replay = 10,
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    private val sharedFlowTwenty = MutableSharedFlow<Int>(
        replay = 20,
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    private var counterFive = 1
    private var counterTen = 1
    private var counterTwenty = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyFiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFive.setOnClickListener {
            actionFive()
        }
        binding.buttonTen.setOnClickListener {
            actionTen()
        }
        binding.buttonTwenty.setOnClickListener {
            actionTwenty()
        }
    }

    private fun actionFive() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowFive, COUNTER_FIVE, counterFive)
        }
        lifecycleScope.launch {
            sharedFlowFive.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowFive.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowFive.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action3, it)
                )
            }
        }
    }

    private fun actionTen() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowTen, COUNTER_TEN, counterTen)
        }
        lifecycleScope.launch {
            sharedFlowTen.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowTen.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowTen.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action3, it)
                )
            }
        }
    }

    private fun actionTwenty() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowTwenty, COUNTER_TWENTY, counterTwenty)
        }
        lifecycleScope.launch {
            sharedFlowTwenty.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowTwenty.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowTwenty.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase24Action3, it)
                )
            }
        }
    }

    private suspend fun increaseCounter(
        flow: MutableSharedFlow<Int>,
        counterName: String,
        counter: Int
    ) {
        repeat(25) {
            delay(500)
            flow.emit(
                when (counterName) {
                    COUNTER_FIVE -> counterFive
                    COUNTER_TEN -> counterTen
                    COUNTER_TWENTY -> counterTwenty
                    else -> {
                        counter
                    }
                }
            )
            when (counterName) {
                COUNTER_FIVE -> counterFive++
                COUNTER_TEN -> counterTen++
                COUNTER_TWENTY -> counterTwenty++
            }
        }
    }

    companion object {
        private const val COUNTER_FIVE = "counterFive"
        private const val COUNTER_TEN = "counterTen"
        private const val COUNTER_TWENTY = "counterTwenty"
    }
}