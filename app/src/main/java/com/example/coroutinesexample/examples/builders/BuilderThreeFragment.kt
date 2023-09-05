package com.example.coroutinesexample.examples.builders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentBuilderThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BuilderThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.buildersCase3)
    }
    private lateinit var binding: FragmentBuilderThreeBinding
    private val scope = CoroutineScope(Job())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuilderThreeBinding.inflate(inflater, container, false)
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
        binding.buttonC.setOnClickListener {
            actionC()
        }
    }

    private fun actionA() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase3Action1))

            val deferredA = async {
                loggerVM.addLog(resources.getString(R.string.buildersCase3Action2))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase3Action3))
                resources.getString(R.string.buildersCase3Action7)
            }

            val deferredB = async {
                loggerVM.addLog(resources.getString(R.string.buildersCase3Action4))
                delay(1000)
                loggerVM.addLog(resources.getString(R.string.buildersCase3Action5))
                resources.getString(R.string.buildersCase3Action8)
            }
            val result = deferredA.await() + deferredB.await()
            loggerVM.addLog(resources.getString(R.string.buildersCase3Action6, result))
        }
    }

    private fun actionB() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase3Action1))

            val a = funA()
            val b = funB()

            val result = "$a, $b"

            loggerVM.addLog(resources.getString(R.string.buildersCase3Action9, result))
            loggerVM.addLog(
                resources.getString(
                    R.string.buildersCase3Action10,
                    Utils.getCurrentTime()
                )
            )
        }
    }

    private fun actionC() {
        scope.launch {
            loggerVM.addLog(resources.getString(R.string.buildersCase3Action1))

            val a = async { funA() }
            val b = async { funB() }

            val result = "${a.await()}, ${b.await()}"

            loggerVM.addLog(resources.getString(R.string.buildersCase3Action9, result))
            loggerVM.addLog(
                resources.getString(
                    R.string.buildersCase3Action10,
                    Utils.getCurrentTime()
                )
            )
        }
    }

    private suspend fun funA(): String {
        loggerVM.addLog(
            resources.getString(
                R.string.buildersCase3Action13,
                Utils.getCurrentTime()
            )
        )
        delay(1000)
        loggerVM.addLog(
            resources.getString(
                R.string.buildersCase3Action14,
                Utils.getCurrentTime()
            )
        )
        return resources.getString(R.string.buildersCase3Action11)
    }

    private suspend fun funB(): String {
        loggerVM.addLog(
            resources.getString(
                R.string.buildersCase3Action15,
                Utils.getCurrentTime()
            )
        )
        delay(2000)
        loggerVM.addLog(
            resources.getString(
                R.string.buildersCase3Action16,
                Utils.getCurrentTime()
            )
        )
        return resources.getString(R.string.buildersCase3Action12)
    }
}