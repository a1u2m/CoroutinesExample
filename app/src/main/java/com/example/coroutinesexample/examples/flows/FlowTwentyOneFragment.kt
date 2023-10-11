package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowTwentyOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch

class FlowTwentyOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase21)
    }
    private lateinit var binding: FragmentFlowTwentyOneBinding
    private val standardFlow = flow {
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
    }
    private lateinit var sharedFlowE: SharedFlow<Int>
    private lateinit var sharedFlowL: SharedFlow<Int>
    private lateinit var sharedFlowW: SharedFlow<Int>
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowTwentyOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStartedE.setOnClickListener {
            actionE()
        }
        binding.buttonStartedL.setOnClickListener {
            actionL()
        }
        binding.buttonStartedW.setOnClickListener {
            actionW()
        }
    }

    private fun actionE() {
        reset()
        loggerVM.addLog(resources.getString(R.string.flowsCase21Action1))
        sharedFlowE = standardFlow.shareIn(
            replay = 0,
            started = SharingStarted.Eagerly,
            scope = lifecycleScope
        )
        lifecycleScope.launch {
            delay(3000)
            sharedFlowE.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action2, it))
            }
        }
    }


    private fun actionL() {
        reset()
        val scope = CoroutineScope(Dispatchers.Main)
        loggerVM.addLog(resources.getString(R.string.flowsCase21Action3))
        sharedFlowL = standardFlow.shareIn(
            replay = 0,
            started = SharingStarted.Lazily,
            scope = scope
        )
        lifecycleScope.launch {
            delay(1000)
            sharedFlowL.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action4, it))
                if (it == 8) scope.cancel()
            }
        }
        lifecycleScope.launch {
            delay(2000)
            sharedFlowL.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action5, it))
            }
        }
        lifecycleScope.launch {
            delay(3000)
            sharedFlowL.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action6, it))
            }
        }
    }

    private fun actionW() {
        reset()
        val scope = CoroutineScope(Dispatchers.Main)
        loggerVM.addLog(resources.getString(R.string.flowsCase21Action8))
        sharedFlowW = standardFlow.shareIn(
            replay = 0,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 2000),
            scope = scope
        )
        lifecycleScope.launch {
            delay(1000)
            sharedFlowW.takeWhile { it != 5 }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action4, it))
            }
        }
        lifecycleScope.launch {
            delay(2000)
            sharedFlowW.takeWhile { it != 5 }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action5, it))
            }
        }
        lifecycleScope.launch {
            delay(3000)
            sharedFlowW.takeWhile { it != 5 }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action6, it))
            }
        }
        lifecycleScope.launch {
            delay(5000)
            sharedFlowW.takeWhile { it != 9 }.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase21Action7, it))
            }
        }
    }

    private fun reset() {
        counter = 0
    }
}