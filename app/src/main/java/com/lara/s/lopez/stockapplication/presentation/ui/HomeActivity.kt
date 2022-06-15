package com.lara.s.lopez.stockapplication.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lara.s.lopez.stock.util.OnItemClickListener
import com.lara.s.lopez.stockapplication.adapter.StocksAdapter
import com.lara.s.lopez.stockapplication.databinding.ActivityMainBinding
import com.lara.s.lopez.stockapplication.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()

    companion object {
        const val ID_STOCK = "ID_STOCK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.setHasFixedSize(true)
        val recycler: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = recycler

        setUpObservers()

        viewModel.stocks.observe(this, { listStock ->
            if (listStock.isNotEmpty()) {
                val adapter = StocksAdapter(listStock)
                binding.recyclerView.adapter = adapter
                adapter.setOnItemClickListener(object : OnItemClickListener {
                    override fun onItemClick(position: Int) {

                    }
                })
            }
        })

        viewModel.progressBar.observe(this) { boolean ->
            binding.progressBar.isVisible = boolean
        }

    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    private fun setUpObservers() {
        viewModel.initializeViewModel()
    }
}