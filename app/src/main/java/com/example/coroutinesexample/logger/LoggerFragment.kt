package com.example.coroutinesexample.logger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinesexample.databinding.FragmentLoggerBinding

class LoggerFragment : Fragment() {

    lateinit var binding: FragmentLoggerBinding
    private var adapter = LogsAdapter()
    private val vm: LoggerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoggerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.logs.observe(viewLifecycleOwner) { items ->
            adapter.items = items
            adapter.notifyItemInserted(adapter.itemCount - 1)
        }

        binding.clearButton.setOnClickListener {
            vm.clearLogs()
        }

        binding.logRecycler.adapter = adapter
        binding.logRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}