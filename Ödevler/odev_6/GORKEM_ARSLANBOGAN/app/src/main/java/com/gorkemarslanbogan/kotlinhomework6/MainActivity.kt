package com.gorkemarslanbogan.kotlinhomework6

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gorkemarslanbogan.kotlinhomework6.adapter.EczaneAdapter
import com.gorkemarslanbogan.kotlinhomework6.model.NobetciEczane
import com.gorkemarslanbogan.kotlinhomework6.service.NetworkManager

class MainActivity : AppCompatActivity() {
    private lateinit var service : NetworkManager
    private lateinit var llIlceler: ListView
    private lateinit var text_tarih: TextView
    private lateinit var eczanelerList: List<NobetciEczane>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUiComponents()
        getData()
    }
    fun getData(){
        service = NetworkManager()
        val run = Runnable {
            eczanelerList = service.getNobetciEczaneler()
            runOnUiThread {
                val adapter = EczaneAdapter(this, eczanelerList)
                llIlceler.adapter = adapter

                if(NetworkManager.tarih != null){
                    text_tarih.text = NetworkManager.tarih
                }

            }
        }
        Thread(run).start()
    }

    fun setUiComponents(){
        llIlceler = findViewById(R.id.ll_ilceler)
        text_tarih = findViewById(R.id.text_tarih)
    }
}