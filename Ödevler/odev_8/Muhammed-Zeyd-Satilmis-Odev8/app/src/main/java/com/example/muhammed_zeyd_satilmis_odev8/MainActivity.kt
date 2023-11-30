package com.example.muhammed_zeyd_satilmis_odev8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.muhammed_zeyd_satilmis_odev8.configs.ApiClient
import com.example.muhammed_zeyd_satilmis_odev8.databinding.ActivityMainBinding
import com.example.muhammed_zeyd_satilmis_odev8.models.UserAuth
import com.example.muhammed_zeyd_satilmis_odev8.services.IDummyService

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}
