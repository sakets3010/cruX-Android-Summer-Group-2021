package com.example.howsthesky.recentCities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.howsthesky.R
import com.example.howsthesky.databinding.FragmentRecentCitiesBinding
import com.example.howsthesky.helper.WeatherListAdapter

class RecentCitiesFragment : Fragment() {

    private val viewModel : RecentCitiesViewModel by activityViewModels()
    private lateinit var binding: FragmentRecentCitiesBinding
    private val weatherListAdapter = WeatherListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_recent_cities, container, false
        )

        binding.weatherRecycler.adapter = weatherListAdapter

        viewModel.weatherList.observe(viewLifecycleOwner,{ weatherList ->
             weatherListAdapter.data = weatherList
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateToCurrentWeather.setOnClickListener {
            findNavController().navigate(R.id.action_recentCitiesFragment_to_currentWeatherFragment)
        }
    }
}