package com.example.coroutinesexample.examples.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentFlowEightBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch

class FlowEightFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.flowCase8)
    }
    private lateinit var binding: FragmentFlowEightBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFlowEightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCollect.setOnClickListener {
            actionCollect()
        }
        binding.buttonSingle.setOnClickListener {
            actionSingle()
        }
        binding.buttonReduce.setOnClickListener {
            actionReduce()
        }
        binding.buttonCount.setOnClickListener {
            actionCount()
        }
        binding.buttonFirst.setOnClickListener {
            actionFirst()
        }
        binding.buttonToList.setOnClickListener {
            actionToList()
        }
        binding.buttonToSet.setOnClickListener {
            actionToSet()
        }
        binding.buttonFold.setOnClickListener {
            actionFold()
        }
    }

    private fun actionCollect() {
        lifecycleScope.launch {
            flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect {
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action1, it))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action2))
        }
    }

    private fun actionSingle() {
        lifecycleScope.launch {
            val value = flowOf(1).single()
            delay(1000)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action3, value))
        }
    }

    private fun actionReduce() {
        lifecycleScope.launch {
            val numbersFlow = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val product = numbersFlow.reduce { accumulator, value -> accumulator * value }
            delay(1000)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action4, product))
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action5))
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action6))
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action7))
        }
    }

    private fun actionCount() {
        lifecycleScope.launch {
            val words = arrayOf(
                "Number",
                "Word",
                "Desk",
                "Table",
                "Hotdog",
                "Kitchen",
                "Dog",
                "Nintendo",
                "Switch",
                "Game"
            )
            val wordsFlow = words.asFlow()
            for (i in words) {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action8, i))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action9))
            val count = wordsFlow.count { it.length > 4 }
            delay(1000)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action10, count))
        }
    }

    private fun actionFirst() {
        lifecycleScope.launch {
            val value = flowOf(1, 2, 3, 4, 5)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action11))
            val first = value.first()
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action12, first))
        }
    }

    private fun actionToList() {
        lifecycleScope.launch {
            val words = arrayOf(
                "a",
                "b",
                "c",
                "d",
                "a",
                "b",
                "c",
            )
            for (i in words) {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action13, i))
            }
            val wordsFlow = words.asFlow()
            val toList = wordsFlow.toList()
            delay(500)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action14))
            for (i in toList) {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action15, i))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action16))
        }
    }

    private fun actionToSet() {
        lifecycleScope.launch {
            val words = arrayOf(
                "a",
                "b",
                "c",
                "d",
                "a",
                "b",
                "c",
            )
            for (i in words) {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action17, i))
            }
            val wordsFlow = words.asFlow()
            val toSet = wordsFlow.toSet()
            delay(500)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action18))
            for (i in toSet) {
                delay(500)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action19, i))
            }
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action20))
        }
    }

    private fun actionFold() {
        lifecycleScope.launch {
            val numbersFlow = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            val product = numbersFlow.fold(1) { accumulator, value ->
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.flowsCase8Action21, accumulator))
                accumulator * value
            }
            delay(1000)
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action22, product))
            loggerVM.addLog(resources.getString(R.string.flowsCase8Action23))
        }
    }
}
