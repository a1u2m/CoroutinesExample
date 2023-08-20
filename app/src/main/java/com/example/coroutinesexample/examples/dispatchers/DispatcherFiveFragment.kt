package com.example.coroutinesexample.examples.dispatchers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentDispatcherFiveBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import com.example.coroutinesexample.utis.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class DispatcherFiveFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.dispatchersCase5)
    }
    lateinit var binding: FragmentDispatcherFiveBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDispatcherFiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonUnconfined.setOnClickListener {
            unconfinedAction()
        }
        binding.buttonMain.setOnClickListener {
            mainAction()
        }
    }

    private fun unconfinedAction() {
        CoroutineScope(Dispatchers.Unconfined).launch {
            loggerVM.addLog(
                resources.getString(
                    R.string.dispatchersCase5Action1,
                    Thread.currentThread().name,
                    Utils.getCurrentTime()
                )
            )
            actionBody()
            loggerVM.addLog(
                resources.getString(
                    R.string.dispatchersCase5Action9
                )
            )
        }
    }

    private fun mainAction() {
        CoroutineScope(Dispatchers.Main).launch {
            loggerVM.addLog(
                resources.getString(
                    R.string.dispatchersCase5Action11,
                    Thread.currentThread().name,
                    Utils.getCurrentTime()
                )
            )
            actionBody()
            loggerVM.addLog(
                resources.getString(
                    R.string.dispatchersCase5Action10
                )
            )
        }
    }

    private suspend fun actionBody() {
        TimeUnit.MILLISECONDS.sleep(1000)
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action2,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
        unconfinedSuspendTest()
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action8,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
        TimeUnit.MILLISECONDS.sleep(1000)
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action3,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
    }

    private suspend fun unconfinedSuspendTest() {
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action4,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
        delay(1000)
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action5,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
        delay(1000)
        withContext(Dispatchers.IO) {
            loggerVM.addLog(
                resources.getString(
                    R.string.dispatchersCase5Action6,
                    Thread.currentThread().name,
                    Utils.getCurrentTime()
                )
            )
        }
        delay(1000)
        loggerVM.addLog(
            resources.getString(
                R.string.dispatchersCase5Action7,
                Thread.currentThread().name,
                Utils.getCurrentTime()
            )
        )
    }
}