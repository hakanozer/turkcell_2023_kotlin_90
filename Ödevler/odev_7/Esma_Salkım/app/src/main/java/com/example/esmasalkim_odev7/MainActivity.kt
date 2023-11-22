package com.example.esmasalkim_odev7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.esmasalkim_odev7.adapter.CustomAdapter
import com.example.esmasalkim_odev7.models.sehirler
import com.example.esmasalkim_odev7.service.XmlResult
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    private lateinit var searchView: SearchView
    lateinit var listView: ListView
    private lateinit var dataList: List<sehirler>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.listView)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        //verilen link ile bütün xml veriyi alıp listeliyorumç.
        val xmlResult = XmlResult()
        val arrResult = xmlResult.xml()
        val adapter = CustomAdapter(this, arrResult)
        listView.adapter = adapter
        dataList = xmlResult.xml();
        searchData() // Her işlemde data araması için bu fonksiyonun içerisinde çekilen verilerin gezimnmesini sağlıyorumn.
    }
    //Şehir arama
    fun searchData() {
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                Thread.sleep(1000) // Girilen kelimeyi beklemek için ekledim.
                return true;

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    listFiltre(newText) // Girilen metni çekilen data içerisinde arıyorumm
                }
                else{

                    val xmlResult = XmlResult()
                    val arrResult = xmlResult.xml()

                    //Arama yaptıktan sonra eğer kelime silindiyse  bütün şehirleri getiriyorumm

                    val adapter = CustomAdapter(this@MainActivity, arrResult)
                    listView.adapter = adapter
                }
                return true
            }
        })

    }

    //Şehir filtreleme

    fun listFiltre(text: String) {

        val listFiltre = mutableListOf<sehirler>()

        for (data in dataList) {
            val city = data.il.lowercase()  // Büyük küçük harf duyarsızlığı için yaptım ancak klavye türkçe karakter olması lazım.
            //Eğer türkçe karakter ile başlayan büyük bir harf girersek ve klavye türkçe değilse istenilen aramayı yapamayabiliriz.
            if (city.contains(text.lowercase())) {
                (listFiltre).add(data)
            }
        }

        if (listFiltre.isNotEmpty()) {
            //Eğer metin girildiyse ve boş değilse o zaman filtrelenmiş halini listview a ekliyorumm.
            val adapter = CustomAdapter(this, listFiltre)
            listView.adapter = adapter
        }else{
            listView.adapter = null // Eğer girilen metin ile bir il bulunmuyorsa/eşleşmiyorsa o durumda listview i null yapıyorum.
            // Ta ki arama kelimesi silinene kadar ve eşleşene kadar
            Toast.makeText(this, "Lütfen il adını doğru giriniz!", Toast.LENGTH_SHORT).show()
        }
    }
}





