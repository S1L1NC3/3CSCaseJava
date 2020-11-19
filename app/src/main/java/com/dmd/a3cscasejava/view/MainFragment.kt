package com.dmd.a3cscasejava.view

import Pokemon
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dmd.a3cscasejava.R
import com.dmd.a3cscasejava.adapters.PokemonsAdapter
import com.dmd.a3cscasejava.databinding.MainFragmentBinding
import com.dmd.a3cscasejava.viewModel.PokemonViewModel

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var fragmentBinding: MainFragmentBinding? = null
    private val binding get() = fragmentBinding!!

    private lateinit var pokemonsViewModel: PokemonViewModel
    private val pokemonsAdapter = PokemonsAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        fragmentBinding = MainFragmentBinding.inflate(inflater, container,false) //Added for binding configuration
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        pokemonsViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(PokemonViewModel::class.java)
        pokemonsViewModel.refreshData()

        binding.recyclerViewPokemons.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        binding.recyclerViewPokemons.adapter = pokemonsAdapter

        observeLiveDataForPokemons()

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

    /* observingLiveDataForPikaPikas*/
    private fun observeLiveDataForPokemons(){
        pokemonsViewModel.data.observe(this, Observer { data ->
            data?.let {
                Glide.with(this).load(R.drawable.sadpikapika).fitCenter().into(binding.imgGifForFun)
                binding.imgGifForFun.visibility = View.GONE
                binding.txtForFun.visibility = View.GONE
                binding.recyclerViewPokemons.visibility = View.VISIBLE
                binding.swipeRefreshLayout.isRefreshing = false
                pokemonsAdapter.updateList(data as ArrayList<Pokemon>)
            }
        })
        pokemonsViewModel.error.observe(this, Observer { error ->
            error?.let {
                if (error){
                    binding.imgGifForFun.visibility = View.VISIBLE
                    binding.txtForFun.visibility = View.VISIBLE
                    binding.recyclerViewPokemons.visibility = View.GONE
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