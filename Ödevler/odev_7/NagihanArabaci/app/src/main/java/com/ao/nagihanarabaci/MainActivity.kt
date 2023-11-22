package com.ao.nagihanarabaci

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.ao.nagihanarabaci.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        load()
        binding.root.hideKeyboard()
    }

    private fun recyclerViewOptions() {
        binding.citiesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.citiesRecyclerView.adapter =
            CitiesCardAdapter(binding.root.context, JsoupService.citiesList)
        searchOptions()
    }

    private fun load() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = async {
                JsoupService.getCitiesList()
            }
            result.await()
            recyclerViewOptions()
        }
    }

    private fun searchOptions(){
        binding.searchBar.doOnTextChanged { text, start, before, count ->
            val filteredList = JsoupService.citiesList.filter { value ->
                val il = value.il.lowercase().trim()
                val search = text.toString().lowercase().trim()
                il.contains(search)
            }
            binding.citiesRecyclerView.adapter = CitiesCardAdapter(binding.root.context,filteredList)
        }
    }
}

fun View.hideKeyboard() {
    setOnClickListener {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
        clearFocus()
    }
}