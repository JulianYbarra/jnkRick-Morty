package com.junka.jnkrickmorty.main.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.junka.jnkrickmorty.main.MainActivity
import com.junka.jnkrickmorty.main.communication.CommunicationCallback

abstract class BaseFragment : Fragment() {

    lateinit var communication: CommunicationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communication = (requireActivity() as MainActivity)
    }

}