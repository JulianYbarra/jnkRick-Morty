package com.junka.jnkrickmorty.presenter.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.databinding.FragmentCharacterBinding
import com.junka.jnkrickmorty.core.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private val viewModel by viewModels<CharacterViewModel>()

    private lateinit var binding: FragmentCharacterBinding

    private lateinit var character: CharacterRemote

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            character = it.getParcelable("character")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCharacterBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpCharacter()
        setUpOnClickFavorite()
    }

    private fun setUpOnClickFavorite() = with(binding) {
        characterAddToFavorite.setOnClickListener {

            Toast.makeText(requireContext(), "${character.name} save", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpCharacter() = with(binding) {
        characterImage.load(character.image)
        characterName.text = character.name
        characterStatus.text = character.status
        characterSpecies.text = character.species
        characterGender.text = character.gender
        characterLocationName.text = character.location?.name
    }

}