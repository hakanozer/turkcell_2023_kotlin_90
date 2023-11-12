package com.ao.nagihanarabacidays4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.ao.nagihanarabacidays4.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val services = EczaneServices()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )
        loadData()
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        binding.appListView.visibility = View.GONE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
        binding.appListView.visibility = View.VISIBLE
    }

    private fun updateList(data: List<EczaneModel>) {
        binding.appListView.adapter = EczaneAdapter(this, data)
        binding.appListView.divider = null
    }

    private fun loadData() {
        showProgressBar()
        CoroutineScope(Dispatchers.Main).launch {
            val data = getData()
            hideProgressBar()
            updateList(data)
        }
    }

    private suspend fun getData(): List<EczaneModel> {
        return withContext(Dispatchers.IO) {
            val data = services.getData()
            data
        }
    }

}

