package com.example.weather.models

data class SearchResponse(
    val coord: Coord,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
) {
    
}