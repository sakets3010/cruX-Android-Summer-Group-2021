package com.example.howsthesky.ui.currentWeather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.howsthesky.helper.Weather
import com.example.howsthesky.helper.WeatherDatabase
import com.example.howsthesky.helper.WeatherRepository
import com.example.howsthesky.network.CurrentWeather
import com.example.weather.network.CurrentWeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentWeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WeatherRepository =
        WeatherRepository(WeatherDatabase.getInstance(application).weatherDao)

    private val _currentWeather: MutableLiveData<CurrentWeather> = MutableLiveData<CurrentWeather>()
    val currentWeather: LiveData<CurrentWeather>
        get() = _currentWeather

   private fun insert(weather: Weather) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertWeather(weather)
        }
    }

    fun getWeather(cityName : String){
        val getCurrentWeatherDeferred = CurrentWeatherApi.retrofitService.getCurrentWeatherAsync(cityName)
        CoroutineScope(Dispatchers.Main).launch {
            try{
                val weather = getCurrentWeatherDeferred.await()
                _currentWeather.value = weather
                insert(Weather(
                    cityName = weather.cityName,
                    temperature = weather.main.temp,
                    weatherDescription = weather.weather[0].description
                ))
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun formatTemperature(temp: Double) = "%.2f°C".format(temp)

}