package com.example.howsthesky.helper

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_data")
data class Weather(
    @PrimaryKey val cityName: String,
    val temperature: Double = 25.0,
    val weatherDescription: String = "Thunderstorm"
)