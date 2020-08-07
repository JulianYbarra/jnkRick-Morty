package com.junka.jnkrickmorty.presenter.ui.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainFragmentViewModel

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater)

        viewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            goNextFragment.setOnClickListener {
                findNavController().navigate(R.id.navigation_character_fragment)
            }
        }
    }
}