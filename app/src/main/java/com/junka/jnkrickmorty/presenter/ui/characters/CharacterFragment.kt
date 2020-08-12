package com.junka.jnkrickmorty.presenter.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.junka.jnkrickmorty.AppDatabase
import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.databinding.FragmentCharacterBinding
import com.junka.jnkrickmorty.domain.RepoImpl
import com.junka.jnkrickmorty.presenter.ui.load
import com.junka.jnkrickmorty.presenter.ui.mainfragment.VMFactory

class CharacterFragment : Fragment() {

    private val viewModel by viewModels<CharacterViewModel> {
        VMFactory(
            RepoImpl(
                DataSource(
                    AppDatabase.getDatabase(requireActivity().applicationContext)
                )
            )
        )
    }

    private lateinit var binding: FragmentCharacterBinding

    private lateinit var character: Character

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

            val entity = CharacterEntity(
                character.id,
                character.name,
                character.status,
                character.species,
                character.type,
                character.gender,
                character.image,
                character.url,
                character.created
            )
            viewModel.addToFavorite(entity)
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