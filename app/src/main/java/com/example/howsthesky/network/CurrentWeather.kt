package com.example.howsthesky.network

import com.squareup.moshi.Json

data class CurrentWeather(
    @Json(name = "weather") val weather: List<WeatherDescription>,
    @Json(name = "main") val main: Main,
    @Json(name = "name") val cityName: String
)

data class WeatherDescription(@Json(name = "description") val description: String)

data class Main(@Json(name = "temp") val temp: Double)

