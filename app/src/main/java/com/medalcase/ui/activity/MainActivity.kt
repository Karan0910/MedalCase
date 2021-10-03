package com.medalcase.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.medalcase.R
import com.medalcase.databinding.ActivityMainBinding
import com.medalcase.ui.adapter.RecordsAdapter
import com.medalcase.ui.viewmodel.RecordsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel =
        ViewModelProvider(this, defaultViewModelProviderFactory).get(RecordsViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.recordsViewModel = viewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recordsAdapter = RecordsAdapter()

        binding.recordsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recordsAdapter
        }

    }
}