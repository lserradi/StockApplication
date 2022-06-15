package com.lara.s.lopez.stockapplication.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.domain.usecase.GetStockByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getStockByIdUseCase: GetStockByIdUseCase,
) : BaseViewModel() {

    private val getStock = MutableLiveData<Stock>()
    val stock: LiveData<Stock> get() = getStock

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
                    onError = { Log.e("ERROR", it.message.toString()) },
                    onSuccess = { stock ->
                        getStock.value = stock
                    }
                )
        )
    }

}