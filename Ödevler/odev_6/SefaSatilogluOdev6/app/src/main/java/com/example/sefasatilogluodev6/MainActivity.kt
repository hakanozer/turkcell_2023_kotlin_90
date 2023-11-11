package com.example.sefasatilogluodev6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

        val eczaneResult = EczaneResult()

        lifecycleScope.launch {
            try {
                val data = withContext(Dispatchers.IO) {
                    eczaneResult.gaziAntep()
                }
                val adapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_list_item_1)

                data.forEach { ilce, eczaneAdresi ->

                    adapter.add(ilce)

                    eczaneAdresi.forEach { eczane ->
                        adapter.add(" $eczane")
                    }
                }
                listView.adapter = adapter
            }catch (e:Exception) {
                e.printStackTrace()
            }

        }


    }
}