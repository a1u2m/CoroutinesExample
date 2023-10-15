package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlowTwentyThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase23)
    }
    private lateinit var binding: FragmentFlowTwentyThreeBinding
    private val sharedFlowSus = MutableSharedFlow<Int>(
        extraBufferCapacity = 10,
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    private val sharedFlowOld = MutableSharedFlow<Int>(
        extraBufferCapacity = 10,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    private val sharedFlowLat = MutableSharedFlow<Int>(
        extraBufferCapacity = 10,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    private var counterSus = 1
    private var counterOld = 1
    private var counterLat = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSus.setOnClickListener {
            actionSus()
        }
        binding.buttonOld.setOnClickListener {
            actionOld()
        }
        binding.buttonLat.setOnClickListener {
            actionLat()
        }
    }

    private fun actionSus() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowSus, COUNTER_SUS, counterSus)
        }
        lifecycleScope.launch {
            sharedFlowSus.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowSus.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowSus.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action3, it)
                )
            }
        }
    }

    private fun actionOld() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowOld, COUNTER_OLD, counterOld)
        }
        lifecycleScope.launch {
            sharedFlowOld.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowOld.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowOld.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action3, it)
                )
            }
        }
    }

    private fun actionLat() {
        lifecycleScope.launch(Dispatchers.IO) {
            increaseCounter(sharedFlowLat, COUNTER_LAT, counterLat)
        }
        lifecycleScope.launch {
            sharedFlowLat.onEach { delay(500) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action1, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowLat.onEach { delay(1000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action2, it)
                )
            }
        }

        lifecycleScope.launch {
            sharedFlowLat.onEach { delay(2000) }.collect {
                loggerVM.addLog(
                    resources.getString(R.string.flowsCase23Action3, it)
                )
            }
        }
    }

    private suspend fun increaseCounter(
        flow: MutableSharedFlow<Int>,
        counterName: String,
        counter: Int
    ) {
        repeat(50) {
            delay(500)
            flow.emit(
                when (counterName) {
                    COUNTER_SUS -> counterSus
                    COUNTER_OLD -> counterOld
                    COUNTER_LAT -> counterLat
                    else -> {
                        counter
                    }
                }
            )
            when (counterName) {
                COUNTER_SUS -> counterSus++
                COUNTER_OLD -> counterOld++
                COUNTER_LAT -> counterLat++
            }
        }
    }

    companion object {
        private const val COUNTER_SUS = "counterSus"
        private const val COUNTER_OLD = "counterOld"
        private const val COUNTER_LAT = "counterLat"
    }
}