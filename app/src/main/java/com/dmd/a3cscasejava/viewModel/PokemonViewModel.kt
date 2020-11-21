package com.dmd.a3cscasejava.viewModel

import Pokemon
import PokemonsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

open class PokemonViewModel() : MainViewModel(){

    override fun refreshData(){
        getDataFromApiForMovies()
    }

    fun assignDataManually(valueForManual : ArrayList<Pokemon>) {
        data.value = valueForManual
    }

    private fun getDataFromApiForMovies(){
        loading.value= true

        disposable.add(
            dataApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonsResponse>(){
                    override fun onSuccess(t: PokemonsResponse) {
                        data.value = t.results
                        error.value=false
                        loading.value=false

                    }

                    override fun onError(e: Throwable) {
                        loading.value=false
                        error.value=true
                        e.printStackTrace()

                    }

                })
        )
    }
}