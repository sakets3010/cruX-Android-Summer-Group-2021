package com.example.weather.network

import com.example.howsthesky.network.CurrentWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val CURRENT_BASE_URL = "https://openweathermap.org/data/2.5/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(CURRENT_BASE_URL)
    .build()

interface ApiService {
    @GET("weather")
    fun getCurrentWeatherAsync(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String = "insert_your_api_key_here"
    ): Deferred<CurrentWeather>

}

object CurrentWeatherApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}