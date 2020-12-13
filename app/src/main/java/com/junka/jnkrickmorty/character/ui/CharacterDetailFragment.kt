package com.junka.jnkrickmorty.character.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.junka.jnkrickmorty.common.downloadImage
import com.junka.jnkrickmorty.core.CHARACTER_PARAM
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private val viewModel by viewModels<CharacterDetailViewModel>()

    private val binding: FragmentCharacterDetailBinding by lazy { FragmentCharacterDetailBinding.inflate(layoutInflater) }

    private val characterData: CharacterRemote? by lazy { requireArguments().getParcelable(CHARACTER_PARAM)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpCharacter()
        setUpOnClickFavorite()
    }

    private fun setUpOnClickFavorite() = with(binding) {
        characterAddToFavorite.setOnClickListener {
            characterData?.let {
                Toast.makeText(requireContext(), "${it.name} save", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setUpCharacter() = with(binding) {
        characterData?.let {
            characterImage.downloadImage(it.image)
            characterName.text = it.name
            characterStatus.text = it.status
            characterSpecies.text = it.species
            characterGender.text = it.gender
            characterLocationName.text = it.location?.name
        }
    }
}