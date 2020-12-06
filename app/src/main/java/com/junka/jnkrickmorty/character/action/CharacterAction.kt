package com.junka.jnkrickmorty.character.action

import com.junka.jnkrickmorty.data.model.CharacterRemote

sealed class CharacterAction{
    class onCharacterFound(val characters : List<CharacterRemote>) : CharacterAction()
}
