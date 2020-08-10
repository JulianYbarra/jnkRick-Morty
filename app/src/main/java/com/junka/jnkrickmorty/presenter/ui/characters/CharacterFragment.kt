package com.junka.jnkrickmorty.presenter.ui.characters

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.databinding.FragmentCharacterBinding
import com.junka.jnkrickmorty.presenter.ui.load

class CharacterFragment : Fragment() {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var binding : FragmentCharacterBinding

    private lateinit var character : Character

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
    }

    private fun setUpCharacter() = with(binding){
        characterImage.load(character.image)
        characterName.text = character.name
        characterStatus.text = character.status
        characterSpecies.text = character.species
        characterGender.text = character.gender
        characterLocationName.text = character.location?.name
    }

}