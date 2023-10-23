package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScopeFunctionOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase1)
    }
    private lateinit var binding: FragmentScopefunctionOneBinding
    private lateinit var mainJob: Job
    private lateinit var jobOne: Job
    private lateinit var jobTwo: Job
    private lateinit var jobThree: Job
    private lateinit var jobFour: Job
    private val customScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        mainJob = lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action1))
            delay(1000)
            jobOne = launch {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action2))
                delay(10000)
            }
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action3))
                delay(10000)
            }
            jobThree = customScope.launch {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action4))
                delay(10000)
            }
            jobFour = customScope.launch {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action5))
                delay(10000)
            }
            delay(5000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase1Action6,
                    mainJob.isActive.toString(),
                    jobOne.isActive.toString(),
                    jobTwo.isActive.toString(),
                    jobThree.isActive.toString(),
                    jobFour.isActive.toString()
                )
            )
            delay(1000)
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase1Action7))
            customScope.cancel()
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase1Action6,
                    mainJob.isActive.toString(),
                    jobOne.isActive.toString(),
                    jobTwo.isActive.toString(),
                    jobThree.isActive.toString(),
                    jobFour.isActive.toString()
                )
            )
        }
    }
}