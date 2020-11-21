package com.dmd.a3cscasejava.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.a3cscasejava.api.Service
import io.reactivex.disposables.CompositeDisposable

open class MainViewModel : ViewModel() {

    protected val dataApiService = Service()
    protected val disposable = CompositeDisposable()

    var data = MutableLiveData<List<Any>>() //Generic type list List<T>
    var error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    open fun refreshData(){}
}