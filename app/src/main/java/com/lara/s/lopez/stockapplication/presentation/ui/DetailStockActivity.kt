package com.lara.s.lopez.stockapplication.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lara.s.lopez.stockapplication.databinding.ActivityDetailStockBinding
import com.lara.s.lopez.stockapplication.presentation.viewModel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailStockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStockBinding
    private val viewModel: DetailViewModel by viewModels()
    private var stockId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        stockId = intent.getStringExtra(HomeActivity.ID_STOCK).toString()

        setUpObservers()

        viewModel.stock.observe(this, {
            binding.nameStock.text = binding.nameStock.text.toString().plus(it.name)
            binding.hotStock.text =
                binding.hotStock.text.toString().plus(it.hot.toString())
            binding.ricCode.text = binding.ricCode.text.toString().plus(it.ricCode.toString())
        })
        viewModel.category.observe(this, {
            binding.category.text = binding.category.text.toString().plus(it)
        })
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    private fun setUpObservers() {
        viewModel.initializeViewModel(stockId)
    }
}