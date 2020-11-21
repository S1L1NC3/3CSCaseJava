package com.dmd.a3cscasejava.view

import Pokemon
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dmd.a3cscasejava.R
import com.dmd.a3cscasejava.activities.DetailActivity
import com.dmd.a3cscasejava.adapters.PokemonsAdapter
import com.dmd.a3cscasejava.databinding.MainFragmentBinding
import com.dmd.a3cscasejava.viewModel.PokemonDetailViewModel
import com.dmd.a3cscasejava.viewModel.PokemonViewModel

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var fragmentBinding: MainFragmentBinding? = null
    private val binding get() = fragmentBinding!!

    private lateinit var pokemonsViewModel: PokemonViewModel
    private lateinit var pokemonDetailViewModel: PokemonDetailViewModel
    private var pokemons = arrayListOf<Pokemon>()
    private val pokemonsAdapter = PokemonsAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        fragmentBinding = MainFragmentBinding.inflate(inflater, container,false) //Added for binding configuration
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        pokemonsViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(PokemonViewModel::class.java)
        pokemonDetailViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(PokemonDetailViewModel::class.java)
        pokemonsViewModel.refreshData()

        binding.recyclerViewPokemons.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        binding.recyclerViewPokemons.adapter = pokemonsAdapter

        observeLiveDataForPokemons()
        observeLiveDataForPokemonDetail()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(queryText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(queryText: String?): Boolean {
                binding.searchView.clearFocus()
                binding.searchView.setQuery("",false)

                if (queryText != null) {
                    pokemonsViewModel.assignDataManually(
                            pokemons.filter {
                                it.name.startsWith(queryText) || it.name.contains(queryText, ignoreCase = true)
                            } as ArrayList<Pokemon>
                    )
                }

                if (pokemonsViewModel.data.value?.size == 0) {
                    errorFunction()
                }

                return true
            }
        })

        pokemonsAdapter.setOnPokemonItemClickListener(object: PokemonsAdapter.OnPokemonItemClickListener {
            override fun itemPokemonItemClick(pokemon: Pokemon) {
                pokemonDetailViewModel.getDetailData(pokemon.name)
            }

        })

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.recyclerViewPokemons.visibility=View.VISIBLE
            binding.imgGifForFun.visibility = View.GONE
            binding.txtForFun.visibility = View.GONE
            pokemonsViewModel.refreshData()
        }
    }

    private fun errorFunction(){
        binding.imgGifForFun.visibility = View.VISIBLE
        binding.txtForFun.visibility = View.VISIBLE
        binding.recyclerViewPokemons.visibility = View.GONE
    }

    /* observingLiveDataForPikaPikaDetail*/
    private fun observeLiveDataForPokemonDetail(){
        pokemonDetailViewModel.data.observe(this, Observer { data ->
            data?.let {
                val detailsIntent = Intent(context, DetailActivity::class.java)
                detailsIntent.putExtra(R.string.detailsExtrasKey.toString(), pokemonDetailViewModel.details)
                startActivity(detailsIntent)
            }
        })
        pokemonDetailViewModel.error.observe(this, Observer { error ->
            error?.let {
                if (error){
                    errorFunction()
                }

            }
        })

        pokemonDetailViewModel.loading.observe(this, Observer { loading ->
            loading?.let {
                Log.d(javaClass.name,"loading")
            }
        })

    }

    /* observingLiveDataForPikaPikas*/
    private fun observeLiveDataForPokemons(){
        pokemonsViewModel.data.observe(this, Observer { data ->
            data?.let {
                Glide.with(this).load(R.drawable.sadpikapika).fitCenter().into(binding.imgGifForFun)
                binding.imgGifForFun.visibility = View.GONE
                binding.txtForFun.visibility = View.GONE
                binding.recyclerViewPokemons.visibility = View.VISIBLE
                binding.swipeRefreshLayout.isRefreshing = false
                pokemons = data as ArrayList<Pokemon>
                pokemonsAdapter.updateList(data)
            }
        })
        pokemonsViewModel.error.observe(this, Observer { error ->
            error?.let {
                if (error){
                    errorFunction()
                    binding.swipeRefreshLayout.isRefreshing = false
                }

            }
        })

        pokemonsViewModel.loading.observe(this, Observer { loading ->
            loading?.let {

            }
        })

    }
}