package com.example.weather.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.weather.components.SearchBar
import com.example.weather.components.WeatherTile
import com.example.weather.viewmodels.WeatherViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(weatherViewModel: WeatherViewModel) {
    var searchPlace by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Weather App", fontSize = 30.sp)
        SearchBar(
            searchItem = searchPlace,
            weatherViewModel
        ) { query ->
            searchPlace = query
        }
        Divider()
        if(weatherViewModel.weatherInfo != null)
            WeatherTile(weatherInfo =  weatherViewModel.weatherInfo)

    }
}