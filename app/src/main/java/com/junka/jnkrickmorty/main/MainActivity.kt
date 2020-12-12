package com.junka.jnkrickmorty.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.junka.jnkrickmorty.R
import com.junka.jnkrickmorty.core.CHARACTER_PARAM
import com.junka.jnkrickmorty.main.communication.CommunicationCallback
import com.junka.jnkrickmorty.main.communication.MainAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CommunicationCallback {

    private lateinit var navController: NavController

    val currentNavigationFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onFragmentEvent(action: MainAction) {
        when(action){
            is MainAction.OnNavigateCharacterDetail -> {
                val bundle = Bundle().apply { putParcelable(CHARACTER_PARAM,action.character) }
                navController.navigate(R.id.action_navigation_main_fragment_to_navigation_character_fragment,bundle)
            }
        }
    }
}