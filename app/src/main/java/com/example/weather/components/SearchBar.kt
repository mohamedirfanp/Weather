package com.example.weather.components


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import com.example.weather.viewmodels.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchItem: String, weatherViewModel: WeatherViewModel, onSearch: (String) -> Unit) {

    Column(Modifier.padding(20.dp)) {

        Row() {
            OutlinedTextField(
                value = searchItem,
                onValueChange = { updatedSearchItem ->
                    onSearch(updatedSearchItem)
                },
                placeholder = { Text("enter a place") },
                modifier = Modifier.padding(end = 5.dp)
            )

            Button(onClick = {
                weatherViewModel.getSearchedPlaceWeather(searchItem)
                Log.d("DATA", weatherViewModel.weatherInfo.toString())
            },
                modifier = Modifier.height(55.dp)) {
                Icon(Icons.Filled.Search, contentDescription = "search")
            }
        }
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {

        Button(onClick = {

        }, modifier = Modifier.height(55.dp)) {
            Icon(Icons.Filled.LocationOn, contentDescription = "location")
        }
        }
    }
}

