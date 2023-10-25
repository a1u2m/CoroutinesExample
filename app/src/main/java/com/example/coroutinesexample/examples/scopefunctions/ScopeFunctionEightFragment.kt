package com.example.coroutinesexample.examples.scopefunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopefunctionEightBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlin.random.Random

class ScopeFunctionEightFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeFunctionsCase2)
    }
    private lateinit var binding: FragmentScopefunctionEightBinding
    private val scope = CoroutineScope(Job())
    private lateinit var job1: Job
    private lateinit var job11: Job
    private lateinit var job111: Job
    private lateinit var job112: Job
    private val handler =
        CoroutineExceptionHandler { _, _ ->
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action1))
            loggerVM.addLog(
                resources.getString(
                    R.string.scopeFunctionsCase8Action2,
                    job1.isActive.toString(),
                    job111.isActive.toString(),
                    job112.isActive.toString()
                )
            )
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action3))
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopefunctionEightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coroutineButton.setOnClickListener {
            coroutineAction()
        }
        binding.supervisorButton.setOnClickListener {
            supervisorAction()
        }
        binding.defaultButton.setOnClickListener {
            defaultAction()
        }
    }

    private fun defaultAction() {
        job1 = scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action4))
            delay(1000)
            job11 = launch {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action5))
                delay(1000)
                job111 = launch {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action6))
                    delay(2000)
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action7))
                }
                job112 = launch {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action8))
                    delay(1000)
                    try {
                        throw Exception()
                    } catch (e: Exception) {
                        loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action9))
                        loggerVM.addLog(
                            resources.getString(
                                R.string.scopeFunctionsCase8Action10,
                                job1.isActive.toString(),
                                job11.isActive.toString(),
                                job111.isActive.toString(),
                                job112.isActive.toString()
                            )
                        )
                    }
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action11))
                }
                delay(2000)
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action12))
            }
            delay(3000)
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action13))
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action14))
        }
    }

    private fun coroutineAction() {
        job1 = scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action4))
            delay(1000)
            try {
                coroutineScope {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action15))
                    delay(1000)
                    job111 = launch {
                        loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action16))
                        delay(2000)
                    }
                    job112 = launch {
                        loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action17))
                        delay(1000)
                        throw Exception()
                    }
                    delay(3000)
                }
            } catch (e: Exception) {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action18))
                loggerVM.addLog(
                    resources.getString(
                        R.string.scopeFunctionsCase8Action2,
                        job1.isActive.toString(),
                        job111.isActive.toString(),
                        job112.isActive.toString()
                    )
                )
            }
            delay(4000)
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action19))
        }
    }

    private fun supervisorAction() {
        job1 = scope.launch(handler) {
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action4))
            delay(1000)
            supervisorScope {
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action20))
                delay(1000)
                job111 = launch {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action21))
                    delay(2000)
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action26))
                }
                job112 = launch {
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action22))
                    delay(1000)
                    repeat(10) {
                        if (Random.nextBoolean()) {
                            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action23))
                            throw Exception()
                        } else {
                            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action24))
                        }
                    }
                    loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action25))
                }
                delay(3000)
                loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action12))
            }
            delay(4000)
            loggerVM.addLog(resources.getString(R.string.scopeFunctionsCase8Action13))
        }
    }

    override fun onPause() {
        scope.cancel()
        super.onPause()
    }
}