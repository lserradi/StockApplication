package com.lara.s.lopez.stock.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lara.s.lopez.stock.databinding.ActivityDetailStockBinding
import com.lara.s.lopez.stock.presentation.viewModel.DetailViewModel
import com.lara.s.lopez.stock.util.FormatNameViewUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailStockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStockBinding
    private val viewModel: DetailViewModel by viewModels()
    private var stockId: String = ""
    private val formatNameUtil = FormatNameViewUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        stockId = intent.getStringExtra(HomeActivity.ID_STOCK).toString()

        setUpObservers()

        viewModel.stock.observe(this, { stock ->
            if (stock != null) {
                binding.nameStock.text =
                    formatNameUtil.formatNameStock(stock.name, binding.nameStock.text.toString())
                binding.hotStock.text = formatNameUtil.formatHotStock(stock.hot.toString(),
                    binding.hotStock.text.toString())
                binding.ricCode.text = formatNameUtil.formatRicCodeStock(stock.ricCode.toString(),
                    binding.ricCode.text.toString())
                binding.category.text = formatNameUtil.formatCategoryStock(stock.category,
                    binding.category.text.toString())
            }
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