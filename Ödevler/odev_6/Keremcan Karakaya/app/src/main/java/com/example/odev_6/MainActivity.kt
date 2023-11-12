package com.example.odev_6

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var eczaneAdapter: EczaneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        val thread = Thread {
            try {
                val eczaneData = EczaneResult().gaziAntep()
                runOnUiThread {
                    eczaneAdapter = EczaneAdapter(eczaneData)
                    listView.adapter = eczaneAdapter
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        thread.start()
    }
}