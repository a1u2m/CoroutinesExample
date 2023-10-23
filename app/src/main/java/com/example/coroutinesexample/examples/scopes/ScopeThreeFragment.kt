package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeThreeBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class ScopeThreeFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase3)
    }
    private lateinit var newCoroutineContextElementString: String
    private lateinit var binding: FragmentScopeThreeBinding
    private lateinit var jobOne: Job
    private lateinit var jobTwo: Job
    private lateinit var jobThree: Job
    private lateinit var coroutineContextNewElement: NewCoroutineContextElement
    private lateinit var customScope: CoroutineScope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newCoroutineContextElementString = resources.getString(R.string.scopesCase3Action1)
        coroutineContextNewElement =
            NewCoroutineContextElement(1, newCoroutineContextElementString)
        customScope =
            CoroutineScope(Job() + Dispatchers.Main + coroutineContextNewElement)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        jobOne = customScope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase3Action2))
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase3Action5,
                    coroutineContext[NewCoroutineContextElement]
                )
            )
            loggerVM.addLog(resources.getString(R.string.scopesCase3Action8, coroutineContext))
            delay(1000)
            jobTwo = launch {
                loggerVM.addLog(resources.getString(R.string.scopesCase3Action3))
                loggerVM.addLog(
                    resources.getString(
                        R.string.scopesCase3Action6,
                        coroutineContext[NewCoroutineContextElement]
                    )
                )
                loggerVM.addLog(resources.getString(R.string.scopesCase3Action9, coroutineContext))
                delay(1000)
                jobThree = launch {
                    loggerVM.addLog(resources.getString(R.string.scopesCase3Action4))
                    loggerVM.addLog(
                        resources.getString(
                            R.string.scopesCase3Action7,
                            coroutineContext[NewCoroutineContextElement]
                        )
                    )
                    loggerVM.addLog(
                        resources.getString(
                            R.string.scopesCase3Action10,
                            coroutineContext
                        )
                    )
                    loggerVM.addLog(resources.getString(R.string.scopesCase3Action11))
                }
            }
        }
    }

    data class NewCoroutineContextElement(
        val id: Long,
        val name: String
    ) : AbstractCoroutineContextElement(NewCoroutineContextElement) {
        companion object Key : CoroutineContext.Key<NewCoroutineContextElement>
    }
}