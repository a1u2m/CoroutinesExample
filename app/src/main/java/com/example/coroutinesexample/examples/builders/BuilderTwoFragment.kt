package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BuilderTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase2)
    }
    lateinit var binding: FragmentBuilderTwoBinding
    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonA.setOnClickListener {
            actionA()
        }
        binding.buttonB.setOnClickListener {
            actionB()
        }
    }

    private fun actionA() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase2Action1))

            launch {
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action2))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action3))
            }

            launch {
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action4))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action5))
            }
            loggerVM.addLog(resources.getString(R.string.buildersCase2Action6))
        }
    }

    private fun actionB() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase2Action1))

            val jobA = launch {
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action2))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action3))
            }

            val jobB = launch {
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action4))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase2Action5))
            }

            loggerVM.addLog(resources.getString(R.string.buildersCase2Action7))
            jobA.join()
            jobB.join()
            loggerVM.addLog(resources.getString(R.string.buildersCase2Action6))
        }
    }
}