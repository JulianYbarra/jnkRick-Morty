package com.junka.jnkrickmorty.main.communication

interface CommunicationCallback {
    fun onFragmentEvent(action: MainAction)
}