package com.dmd.a3cscasejava.viewModel

import com.dmd.a3cscasejava.models.PokemonDetailResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PokemonDetailViewModel: MainViewModel() {
    var details: PokemonDetailResponse? = null

    fun  getDetailData(pokemonNameForDetail: String){
        getDataFromApiForMovies(pokemonNameForDetail)
    }

    private fun getDataFromApiForMovies(pokemonName: String){
        loading.value= true

        disposable.add(
                dataApiService.getPokemonDetail(pokemonName)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<PokemonDetailResponse>(){
                            override fun onSuccess(t: PokemonDetailResponse) {
                                details = t
                                data.value = t.stats // for trigger observable
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