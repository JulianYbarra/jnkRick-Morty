package com.junka.jnkrickmorty.presenter.ui.characters

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding : FragmentCharacterBinding

    private lateinit var character : Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            character = it.getParcelable("character")!!
            Log.d("Detalles", character.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCharacterBinding.inflate(inflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

}