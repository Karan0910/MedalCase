package com.medalcase.ui.activity

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.medalcase.R
import com.medalcase.databinding.ActivityMainBinding
import com.medalcase.ui.adapter.RecordsAdapter
import com.medalcase.ui.viewmodel.RecordsViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: RecordsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        setRecyclerView()
    }

    private fun initView() {
        viewModel = ViewModelProvider(
            this,
            defaultViewModelProviderFactory
        ).get(RecordsViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.recordsViewModel = viewModel

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        binding.toolbarTitle.text = getString(R.string.toolbar_title)


        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

    }

    private fun setRecyclerView() {
        val recordsAdapter = RecordsAdapter()
        val manager = GridLayoutManager(baseContext, 2)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int) =
                when (recordsAdapter.getItemViewType(position)) {
                    0 -> 2
                    else -> 1
                }
        }

        binding.recordsRecyclerView.apply {
            adapter = recordsAdapter
            layoutManager = manager
        }
        recordsAdapter.submitList(viewModel.recordsLiveData.value)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

}