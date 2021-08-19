package com.example.howsthesky.helper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.howsthesky.databinding.WeatherListItemBinding

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder>() {

    var data = listOf<Weather>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherListViewHolder {
        return WeatherListViewHolder(
            WeatherListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: WeatherListAdapter.WeatherListViewHolder, position: Int) {
        val weather = data[position]

        with(holder.binding) {
            cityName.text = weather.cityName
            description.text = weather.weatherDescription
            temperature.text = weather.temperature.toString()
        }


    }

    inner class WeatherListViewHolder(val binding: WeatherListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}