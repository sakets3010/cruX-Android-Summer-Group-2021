package com.example.howsthesky.helper

class WeatherRepository(private val weatherDao: WeatherDao) {

    fun getWeather() = weatherDao.getAllCitiesWeather()

    fun insertWeather(weather: Weather) = weatherDao.insertCityWeather(weather)

}