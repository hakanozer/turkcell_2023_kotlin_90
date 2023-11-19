package com.example.sefasatilogluodev7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sefasatilogluodev7.databinding.ActivityMainBinding
import com.example.sefasatilogluodev7.databinding.CardMetrolojiTasarimBinding
import com.example.sefasatilogluodev7.models.Metroloji
import com.example.sefasatilogluodev7.xml.XmlMetroloji
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sehirlerListesi:ArrayList<Metroloji>
    private lateinit var adapter:MetrolojiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView Görüntülenmesi
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = LinearLayoutManager(this)

        //XML'den verileri çekiyoruz
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val xmlResult = XmlMetroloji()

        //Sehir Listesini olusturup ve adaptörü ayarlama
        sehirlerListesi = xmlResult.verileriAl() as ArrayList<Metroloji>
        adapter = MetrolojiAdapter(this,sehirlerListesi)
        binding.rv.adapter = adapter
        adapter.notifyDataSetChanged()


        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                // Ara butonuna basıldığında yapılacak işlemler
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                // Arama sorgusu değiştikçe yapılacak işlemler
                adapter.filterCity(p0.orEmpty())
                return true
            }
        })





    }
}