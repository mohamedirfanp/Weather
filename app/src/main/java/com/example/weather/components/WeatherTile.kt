package com.example.weather.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weather.models.SearchResponse

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherTile(weatherInfo : SearchResponse?)
{
    val current = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val formatted = current.format(formatter)
    Card(modifier = Modifier
        .padding(10.dp, 10.dp)
        .fillMaxSize()
        .clickable { }
        .height(100.dp), shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp)
    )
    {
        Column(Modifier.padding(20.dp)) {
            
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${weatherInfo?.name}, ${weatherInfo?.sys?.country}", fontSize = 24.sp)
                Text(text = "${formatted}", fontSize = 24.sp)
            }

            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = rememberAsyncImagePainter("https://api.openweathermap.org/img/w/${weatherInfo?.weather?.get(0)?.icon}.png"), contentDescription = "Weather",
                modifier = Modifier.size(150.dp)
            )
                Text(text = "${weatherInfo?.weather?.get(0)?.main}", fontSize = 30.sp)
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {

                Text(text = "Pressure : ${weatherInfo?.main?.pressure}",
                    fontSize = 20.sp
                    )
                Text(text = "Temp : ${weatherInfo?.main?.temp} C", fontSize = 20.sp)
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Humidity : ${weatherInfo?.main?.humidity}", fontSize = 20.sp)
                Text(text = "Wind : ${weatherInfo?.wind?.speed}", fontSize = 20.sp)
            }

        }
    }
}