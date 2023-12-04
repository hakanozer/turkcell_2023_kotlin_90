package com.appsroved.muhammed_zeyd_satilmis_vize2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.appsroved.muhammed_zeyd_satilmis_vize2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val navHostFragment1 =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment1) as NavHostFragment
//
//        NavigationUI.setupWithNavController(binding.bottomNav, navHostFragment1.navController)
    }
}
