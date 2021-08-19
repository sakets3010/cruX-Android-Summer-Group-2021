package com.example.howsthesky.currentWeather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.howsthesky.helper.Weather
import com.example.howsthesky.helper.WeatherDatabase
import com.example.howsthesky.helper.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository =
        WeatherRepository(WeatherDatabase.getInstance(application).weatherDao)

    fun insert(weather: Weather) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertWeather(weather)
        }
    }

}