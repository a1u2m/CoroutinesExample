package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeTwoBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScopeTwoFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase2)
    }
    private lateinit var binding: FragmentScopeTwoBinding
    private lateinit var jobOne: Job
    private lateinit var jobTwo: Job
    private lateinit var jobThree: Job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOne.setOnClickListener {
            actionOne()
        }
        binding.buttonTwo.setOnClickListener {
            actionTwo()
        }
        binding.buttonThree.setOnClickListener {
            actionThree()
        }
    }

    private fun actionOne() {
        jobOne = lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action1))
            delay(1000)
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopesCase2Action2))
                delay(1000)
                jobThree = launch {
                    loggerVM.addLog(resources.getString(R.string.scopesCase2Action3))
                    delay(2000)
                    loggerVM.addLog(resources.getString(R.string.scopesCase2Action4))
                    cancel()
                }
                delay(4000)
            }
            delay(4000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action7,
                    jobOne.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action8,
                    jobTwo.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action9,
                    jobThree.isActive.toString()
                )
            )
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action10))
        }
    }

    private fun actionTwo() {
        jobOne = lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action1))
            delay(1000)
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopesCase2Action2))
                delay(1000)
                jobThree = launch {
                    loggerVM.addLog(resources.getString(R.string.scopesCase2Action3))
                    delay(4000)
                }
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.scopesCase2Action5))
                cancel()
            }
            delay(4000)
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action7,
                    jobOne.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action8,
                    jobTwo.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action9,
                    jobThree.isActive.toString()
                )
            )
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action11))
        }
    }

    private fun actionThree() {
        jobOne = lifecycleScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action1))
            delay(1000)
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopesCase2Action2))
                delay(1000)
                jobThree = launch {
                    loggerVM.addLog(resources.getString(R.string.scopesCase2Action3))
                    delay(4000)
                }
                delay(4000)
            }
            delay(3000)
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action6))
            cancel()
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action7,
                    jobOne.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action8,
                    jobTwo.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase2Action9,
                    jobThree.isActive.toString()
                )
            )
            loggerVM.addLog(resources.getString(R.string.scopesCase2Action12))
        }
    }
}