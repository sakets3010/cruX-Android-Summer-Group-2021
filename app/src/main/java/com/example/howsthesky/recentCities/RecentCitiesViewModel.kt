package com.example.howsthesky.recentCities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.howsthesky.helper.WeatherDatabase
import com.example.howsthesky.helper.WeatherRepository

class RecentCitiesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository = WeatherRepository(WeatherDatabase.getInstance(application).weatherDao)

    val weatherList = repository.getWeather()

}