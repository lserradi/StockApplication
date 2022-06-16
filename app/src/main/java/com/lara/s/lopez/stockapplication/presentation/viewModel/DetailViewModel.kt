package com.lara.s.lopez.stockapplication.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lara.s.lopez.core.logger.CoordinatorLogger
import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.domain.usecase.GetStockByIdUseCase
import com.lara.s.lopez.stockapplication.util.FormatNameViewUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getStockByIdUseCase: GetStockByIdUseCase,
    private val logger: CoordinatorLogger,
    private val formatNameUtil: FormatNameViewUtil,
) : BaseViewModel() {

    private val getStock = MutableLiveData<Stock>()
    val stock: LiveData<Stock> get() = getStock
    private val stockCategory = MutableLiveData<String>()
    val category: LiveData<String> get() = stockCategory

    fun onDestroy() {
        clearDisposable()
    }

    fun initializeViewModel(position: String) {
        getDataStock(position)
    }

    private fun getDataStock(position: String) {
        addDisposable(
            getStockByIdUseCase.execute(position)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onError = {
                        logger.error(javaClass.name, "Error to get stock")
                        throw RuntimeException(it.message + "Error to get stock")
                    },
                    onSuccess = { stock ->
                        logger.debug(javaClass.name, "Success get stock")
                        getStock.value = stock
                        stockCategory.value = formatNameUtil.formatCategoryStock(stock.category)
                    }
                )
        )
    }
}