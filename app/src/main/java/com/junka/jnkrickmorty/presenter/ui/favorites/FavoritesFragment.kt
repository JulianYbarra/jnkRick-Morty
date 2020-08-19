package com.junka.jnkrickmorty.presenter.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.databinding.FragmentFavoritesBinding
import com.junka.jnkrickmorty.presenter.ui.adapter.CharactersAdapter
import com.junka.jnkrickmorty.presenter.ui.hide
import com.junka.jnkrickmorty.presenter.ui.observer
import com.junka.jnkrickmorty.presenter.ui.show
import com.junka.jnkrickmorty.vo.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private val viewModel by viewModels<FavoritesViewModel>()

    private val characterAdapter by lazy { CharactersAdapter(onClickListener = viewModel::onCharacterItemClick) }

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

        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers()  =  with(viewModel){
        observer(favoritesCharacters){result ->
            when (result) {
                is Resource.Loading -> {
                    binding.loading.show()
                }
                is Resource.Success -> {
                    binding.loading.hide()
                    characterAdapter.characters = result.data.map { Character(it.id,it.name,it.status,it.species,it.type,it.gender,null,null,it.image,null,it.url,it.created) }
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio un error " + result.exception.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setUpRecyclerView()= with(binding){
        listCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(requireContext(),
                    DividerItemDecoration.VERTICAL)
            )
            adapter = characterAdapter
        }
    }


}