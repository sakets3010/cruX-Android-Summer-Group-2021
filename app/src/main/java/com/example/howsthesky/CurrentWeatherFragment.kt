package com.example.howsthesky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.howsthesky.databinding.FragmentCurrentWeatherBinding


class CurrentWeatherFragment : Fragment() {
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