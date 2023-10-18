package com.example.coroutinesexample.examples.scopes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexample.R
import com.example.coroutinesexample.databinding.FragmentScopeOneBinding
import com.example.coroutinesexample.examples.BaseExampleFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class ScopeOneFragment : BaseExampleFragment() {

    override val description: String by lazy {
        resources.getString(R.string.scopeCase1)
    }
    private lateinit var binding: FragmentScopeOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScopeOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        val scope = CoroutineScope(Dispatchers.IO)
        val jobOne = scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase1Action1))
            delay(5000)
        }
        val jobTwo = scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase1Action2))
            delay(5000)
        }
        val jobThree = scope.launch {
            loggerVM.addLog(resources.getString(R.string.scopesCase1Action3))
            delay(5000)
        }
        lifecycleScope.launch {
            jobOne.start()
            jobTwo.start()
            jobThree.start()
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action5,
                    scope.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action6,
                    jobOne.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action7,
                    jobTwo.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action8,
                    jobThree.isActive.toString()
                )
            )
            delay(3000)
            loggerVM.addLog(resources.getString(R.string.scopesCase1Action4))
            scope.cancel()
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action5,
                    scope.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action6,
                    jobOne.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action7,
                    jobTwo.isActive.toString()
                )
            )
            loggerVM.addLog(
                resources.getString(
                    R.string.scopesCase1Action8,
                    jobThree.isActive.toString()
                )
            )
        }
    }
}