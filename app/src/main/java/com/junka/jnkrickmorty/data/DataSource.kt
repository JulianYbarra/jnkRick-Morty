package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.Location
import com.junka.jnkrickmorty.data.model.Origin
import com.junka.jnkrickmorty.vo.Resource

class DataSource {

    val charactersList = Resource.Success(listOf(
        Character(
            0,
            "Rick Sanchez",
            "Alive",
            "Human",
            "",
            "Male",
            Origin("Earth", "https://rickandmortyapi.com/api/location/1"),
            Location(
                "Earth",
                "https://rickandmortyapi.com/api/location/20"
            ),
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            listOf<String>(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2"
            ),
            "https://rickandmortyapi.com/api/character/1",
            "2017-11-04T18:48:46.250Z"
        ),
        Character(
            1,
            "Morty Smith",
            "Alive",
            "Human",
            "",
            "Male",
            Origin("Earth", "https://rickandmortyapi.com/api/location/1"),
            Location(
                "Earth",
                "https://rickandmortyapi.com/api/location/20"
            ),
            "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            listOf<String>(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2"
            ),
            "https://rickandmortyapi.com/api/character/1",
            "2017-11-04T18:48:46.250Z"
        ),
        Character(
            2,
            "Summer Smith",
            "Alive",
            "Human",
            "",
            "Female",
            Origin("Earth", "https://rickandmortyapi.com/api/location/1"),
            Location(
                "Earth",
                "https://rickandmortyapi.com/api/location/20"
            ),
            "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            listOf<String>(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2"
            ),
            "https://rickandmortyapi.com/api/character/1",
            "2017-11-04T18:48:46.250Z"
        )
    ))
}