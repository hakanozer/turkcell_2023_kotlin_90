package com.works.odevv6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView =findViewById<ListView>(R.id.listView)

        val names = arrayOf("gönül eczanesi ---  koyunoglu mah "," neşat eczanesi --haydarlı sokak ","selimiye eczanesi ---  sanat sokak","haydar eczanesi--  nigar sokak"

        ,  "alperen eczanesi --- dilek sokak "," idil eczanesi -- kumru sokak ", "aylanur eczanesi -- leventli sokak ","ismail eczanesi --  vardar sokak"

        , "nergizşah eczanesi -- kıymet sokak ","mengi eczanesi ---  kınalı sokak ", "neşve eczanesi --- atakum sokak ")

        val arrayAdapter:ArrayAdapter<String> =ArrayAdapter(this,android.R.layout.simple_list_item_1,names)

        listView.adapter=arrayAdapter

        listView.setOnItemClickListener{adapterView,view,i, l ->

            Toast.makeText(this,"SEÇİLDİ:"+names[i],Toast.LENGTH_LONG)

                .show()
            // Hocam tıklama özelligi de ekledim hangisini seçtigimizi gösteriyor //

        }



    }
}