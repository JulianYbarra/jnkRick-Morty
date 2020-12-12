package com.junka.jnkrickmorty.main.communication

import com.junka.jnkrickmorty.data.model.CharacterRemote

sealed class MainAction {
    class OnNavigateCharacterDetail(val character: CharacterRemote) : MainAction()
}