package com.junka.jnkrickmorty.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.databinding.FragmentMainBinding
import com.junka.jnkrickmorty.domain.RepoImpl
import com.junka.jnkrickmorty.presenter.ui.adapter.CharactersAdapter
import com.junka.jnkrickmorty.presenter.ui.hide
import com.junka.jnkrickmorty.presenter.ui.observer
import com.junka.jnkrickmorty.presenter.ui.show
import com.junka.jnkrickmorty.vo.Resource

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainFragmentViewModel> { VMFactory(RepoImpl(DataSource())) }

    private val characterAdapter by lazy { CharactersAdapter(onClickListener = viewModel::onCharacterItemClick) }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        with(viewModel) {
            observer(allCharacters) { result ->
                when (result) {
                    is Resource.Loading -> {
                        binding.loading.show()
                    }
                    is Resource.Success -> {
                        binding.loading.hide()
                        characterAdapter.characters = result.data
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
            observer(onNavigationToCharacterDetail) { event ->
                event.getContentIfNotHandled()?.let { character ->
                    val bundle = Bundle().apply {
                        putParcelable("character", character)
                    }
                    findNavController().navigate(R.id.navigation_character_fragment, bundle)
                }
            }
        }
    }

    private fun setUpRecyclerView()= with(binding){
        listCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
            adapter = characterAdapter
        }

    }
}