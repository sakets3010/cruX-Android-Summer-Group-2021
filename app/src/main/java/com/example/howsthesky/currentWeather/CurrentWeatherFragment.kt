package com.example.howsthesky.currentWeather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.howsthesky.R
import com.example.howsthesky.databinding.FragmentCurrentWeatherBinding
import com.example.howsthesky.helper.Weather
import com.google.android.material.snackbar.Snackbar


class CurrentWeatherFragment : Fragment() {

    private val viewModel: CurrentWeatherViewModel by activityViewModels()
    private lateinit var binding: FragmentCurrentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_current_weather, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextFields()

        binding.checkWeatherButton.setOnClickListener {
            val cityName = binding.cityNameEdit.text.toString()
            if (cityName.isNotEmpty()) {
                viewModel.insert(Weather(cityName = cityName))
                binding.cityNameEdit.text?.clear()
            } else {
                Snackbar.make(requireView(), "city name not entered", Snackbar.LENGTH_LONG).show()
            }

        }

        binding.navigateToCities.setOnClickListener {
            findNavController().navigate(R.id.action_currentWeatherFragment_to_recentCitiesFragment)
        }

    }

    private fun setTextFields() {
        with(binding) {
            temperature.text = getString(R.string.temperature)
            weatherDetails.text = getString(R.string.weatherDetail)
            city.text = getString(R.string.city)
        }
    }


}