package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.withIndex
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class FlowFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase5)
    }
    lateinit var binding: FragmentFlowFiveBinding
    private val numbersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val doubleNumbersList =
        listOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10)
    private val lettersList = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowFiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonMap.setOnClickListener {
            actionMap()
        }
        binding.buttonFilter.setOnClickListener {
            actionFilter()
        }
        binding.buttonTake.setOnClickListener {
            actionTake()
        }
        binding.buttonZip.setOnClickListener {
            actionZip()
        }
        binding.buttonCombine.setOnClickListener {
            actionCombine()
        }
        binding.buttonWithIndex.setOnClickListener {
            actionWithIndex()
        }
        binding.buttonScan.setOnClickListener {
            actionScan()
        }
        binding.buttonDebounce.setOnClickListener {
            actionDebounce()
        }
        binding.buttonDistinctUntilChanged.setOnClickListener {
            actionDistinctUntilChanged()
        }
        binding.buttonDrop.setOnClickListener {
            actionDrop()
        }
        binding.buttonSample.setOnClickListener {
            actionSample()
        }
    }

    private fun actionMap() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action2))
            val flow = numbersList.asFlow().map { it * 10 }
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action3, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionFilter() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action4))
            val flow = numbersList.asFlow().filter { it % 2 == 0 }
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action5, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionTake() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action6))
            val flow = numbersList.asFlow().take(5)
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action7, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionZip() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action8))
            val flow = lettersList.asFlow().zip(numbersList.asFlow()) { a, b -> "$b$a" }
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action9, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionCombine() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action10))
            val flow = lettersList.asFlow().combine(numbersList.asFlow()) { a, b -> "$b$a" }
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action11, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionWithIndex() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action12))
            val flow = lettersList.asFlow().withIndex()
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action13, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionScan() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action14))
            val flow = numbersList.asFlow().scan(0) { acc, s -> acc + s }
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action15, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    @OptIn(FlowPreview::class)
    private fun actionDebounce() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action16))
            val flow = flow {
                var i = 0
                while (i < 10) {
                    emit(i++)
                    delay(1000)
                    emit(i++)
                    delay(4000)
                }
            }.debounce(3000)
            flow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action17, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionDistinctUntilChanged() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action18))
            val flow = doubleNumbersList.asFlow().distinctUntilChanged()
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action19, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    private fun actionDrop() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action20))
            val flow = numbersList.asFlow().drop(5)
            flow.collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action21, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }

    @OptIn(FlowPreview::class)
    private fun actionSample() {
        lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action22))
            val flow = flow {
                var i = 0
                while (i < 10) {
                    emit(i++)
                    delay(1000)
                }
            }.sample(3000)
            flow.collect {
                loggerVM.addLog(resources.getString(R.string.flowsCase5Action23, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase5Action1))
        }
    }
}