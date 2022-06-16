package com.lara.s.lopez.stockapplication.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lara.s.lopez.core.logger.CoordinatorLogger
import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.domain.usecase.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stocksUseCase: GetStocksUseCase,
    private val logger: CoordinatorLogger,
) : BaseViewModel() {

    private val _progressBar = MutableLiveData<Boolean>()
    private val getStocks = MutableLiveData<List<Stock>>()
    val stocks: LiveData<List<Stock>> get() = getStocks
    val progressBar: LiveData<Boolean> get() = _progressBar

    fun onDestroy() {
        clearDisposable()
    }

    fun initializeViewModel() {
        getDataListStock()
    }

    private fun getDataListStock() {
        addDisposable(
            stocksUseCase.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onError = {
                        logger.error(javaClass.name, "Error to get stocks")
                        throw RuntimeException(it.message)
                    },
                    onSuccess = { stocks ->
                        logger.debug(javaClass.name, "Success get stocks")
                        _progressBar.value = true
                        getStocks.value = stocks
                        _progressBar.value = false
                    }
                )
        )
    }
}
