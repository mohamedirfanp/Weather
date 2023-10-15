package com.example.weather.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.constants.API_KEY
import com.example.weather.models.SearchResponse
import com.example.weather.network.ApiService
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    var weatherInfo by mutableStateOf<SearchResponse?>(null)

    var errorMessage: String by mutableStateOf("")


    fun getSearchedPlaceWeather(searchPlace : String)
    {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                if(searchPlace != "")
                    weatherInfo = apiService.searchPlace(searchPlace, API_KEY, "metric")

            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    
}