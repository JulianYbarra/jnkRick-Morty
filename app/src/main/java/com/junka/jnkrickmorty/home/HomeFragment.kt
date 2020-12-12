package com.junka.jnkrickmorty.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.character.action.CharacterAction
import com.junka.jnkrickmorty.character.adapter.CharactersAdapter
import com.junka.jnkrickmorty.common.lastVisibleEvents
import com.junka.jnkrickmorty.common.showOrHide
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.core.collectFlow
import com.junka.jnkrickmorty.core.observer
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.EpisodeRemote
import com.junka.jnkrickmorty.databinding.FragmentHomeBinding
import com.junka.jnkrickmorty.episodes.adapter.EpisodeAdapter
import com.junka.jnkrickmorty.home.action.HomeAction
import com.junka.jnkrickmorty.main.base.BaseFragment
import com.junka.jnkrickmorty.main.communication.MainAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel by viewModels<HomeFragmentViewModel>()

    private val homeAdapter by lazy { ConcatAdapter(episodeAdapter, characterAdapter) }

    private val characterAdapter by lazy { CharactersAdapter(onClickListener = ::navigateToDetail) }
    private val episodeAdapter by lazy { EpisodeAdapter(onClickListener ={}) }

    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setConcatAdapter()
        setUpSearchView()

        setUpCommunication()

    }

    private fun setConcatAdapter() = with(binding.homeRecyclerView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = homeAdapter
    }

    private fun setUpSearchView() = with(binding) {
        inputSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })
    }

    private fun setUpCommunication() {
        observer(viewModel.result) { action ->
            when (action) {
                is Resource.Success -> onSuccess(action.data)
                is Resource.Failure -> onFailure(action.exception)
                is Resource.Loading -> onLoading(action.loading)
            }
        }
    }

    private fun onFailure(exception: Exception) {
        Toast.makeText(requireContext(), exception.message, Toast.LENGTH_SHORT).show()
    }

    private fun onLoading(loading: Boolean) {
        binding.loading.showOrHide(loading)
    }

    private fun onSuccess(action: HomeAction) {
        when (action) {
            is HomeAction.OnCharactersFound -> characterFound(action.characterList)
            is HomeAction.OnEpisodesFound -> episodesFound(action.episodesList)
        }
    }

    private fun episodesFound(episodes: List<EpisodeRemote>) {
        if (episodes.isNotEmpty()){
            episodeAdapter.episodes = episodes
        }
    }

    private fun characterFound(characters: List<CharacterRemote>) {
        onLoading(false)
        if (characters.isNotEmpty()) {
            characterAdapter.characters = characters
        }
    }

    private fun navigateToDetail(character : CharacterRemote){
        communication.onFragmentEvent(MainAction.OnNavigateCharacterDetail(character))
    }

}