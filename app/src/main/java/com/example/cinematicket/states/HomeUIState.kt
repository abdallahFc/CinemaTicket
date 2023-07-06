package com.example.cinematicket.states

data class HomeUIState(
    val movies: List<MovieUIState> = listOf(
        MovieUIState(0,"https://www.chicklit.nl/ckfinder/userfiles/images/Chicklit/artikelen/Films/Fantastic%20Beasts-%20The%20Secrets%20of%20Dumbledore%20-%20Dumbledore.jpeg","Fantastic Beasts: The Secrets of Dumbledore","2h 15m"),
        MovieUIState(1,"https://www.themoviedb.org/t/p/original/gSZyYEK5AfZuOFFjnVPUCLvdOD6.jpg","Spider-Man (2002)","2h 15m"),
        MovieUIState(2,"https://www.themoviedb.org/t/p/w220_and_h330_face/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg","John Wick: Chapter 4","2h 15m"),
        MovieUIState(3,"https://www.themoviedb.org/t/p/w220_and_h330_face/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg","Avatar: The Way of Water","2h 15m"),
    )
)

data class MovieUIState(val id: Int, val imageUrl: String, val title: String, val duration: String)

