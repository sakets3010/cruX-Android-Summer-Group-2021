package com.example.howsthesky.helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_data ORDER BY cityName ASC")
    fun getAllCitiesWeather(): LiveData<List<Weather>>

    @Insert
    fun insertCityWeather(weather: Weather)

}