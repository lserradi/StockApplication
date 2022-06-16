package com.lara.s.lopez.stockapplication.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {

    private val disposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }

    fun clearDisposable() {
        disposable.dispose()
    }
}