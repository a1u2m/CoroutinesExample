package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeFourBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScopeFourFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase4)
    }
    private lateinit var binding: FragmentScopeFourBinding
    private lateinit var jobOne: Job
    private lateinit var jobTwo: Job
    private lateinit var jobThree: Job
    private val customScope = CoroutineScope(Job() + Dispatchers.Main)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        jobOne = customScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase4Action1))
            loggerVM.addLog(resources.getString(R.string.scopesCase4Action2, coroutineContext))
            delay(1000)
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopesCase4Action3))
                loggerVM.addLog(resources.getString(R.string.scopesCase4Action4, coroutineContext))
                delay(1000)
                jobThree = launch(Dispatchers.IO) {
                    loggerVM.addLog(resources.getString(R.string.scopesCase4Action5))
                    loggerVM.addLog(
                        resources.getString(
                            R.string.scopesCase4Action6,
                            coroutineContext
                        )
                    )
                    loggerVM.addLog(resources.getString(R.string.scopesCase4Action7))
                }
            }
        }
    }
}