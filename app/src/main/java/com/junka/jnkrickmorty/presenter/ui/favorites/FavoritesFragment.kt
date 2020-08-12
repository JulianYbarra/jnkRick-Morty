package com.junka.jnkrickmorty.presenter.ui.favorites

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.junka.jnkrickmorty.AppDatabase
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.databinding.FragmentFavoritesBinding
import com.junka.jnkrickmorty.domain.RepoImpl
import com.junka.jnkrickmorty.presenter.ui.mainfragment.VMFactory
import com.junka.jnkrickmorty.presenter.ui.observer
import com.junka.jnkrickmorty.vo.Resource

class FavoritesFragment : Fragment() {

    private val viewModel by viewModels<FavoritesViewModel> {
        VMFactory(
            RepoImpl(
                DataSource(
                    AppDatabase.getDatabase(requireActivity().applicationContext)
                )
            )
        )
    }

    private lateinit var binding : FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoritesBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel){
            observer(favoritesCharacters){
                when(it){
                    is Resource.Loading ->{

                    }
                    is Resource.Success ->{
                        Log.d("tag", "favorites: ${it.data}")
                    }
                    is Resource.Failure ->{
                        Toast.makeText(requireContext(), "Error al obtener los favoritos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }




}