package com.example.howsthesky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.howsthesky.databinding.FragmentRecentCitiesBinding

class RecentCitiesFragment : Fragment() {
    private lateinit var binding: FragmentRecentCitiesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_recent_cities, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateToCurrentWeather.setOnClickListener {
            findNavController().navigate(R.id.action_recentCitiesFragment_to_currentWeatherFragment)
        }
    }
}