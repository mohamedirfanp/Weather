package com.example.weather.network
import android.util.Log
import com.example.weather.constants.BASE_URL
import com.example.weather.models.SearchResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {

    @GET("weather")
    suspend fun searchPlace (
        @Query("q") searchPlace : String,
        @Query("appid") appid : String,
        @Query("units") units : String
    ) : SearchResponse

    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}