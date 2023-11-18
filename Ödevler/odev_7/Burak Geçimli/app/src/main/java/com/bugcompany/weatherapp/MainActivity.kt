package com.bugcompany.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugcompany.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WeatherAdapter
    private lateinit var weatherList: List<Weather>
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<Weather>()
            weatherList.forEach { weatherData ->
                //Şehir ismine göre yapar.
                val cityLowerCase = weatherData.city.lowercase(Locale.ROOT)
                val queryLowerCase = query.lowercase(Locale.ROOT)

                if (cityLowerCase.contains(queryLowerCase)) {
                    filteredList.add(weatherData)
                }
            }
            if (filteredList.isEmpty()) {
                return
            } else {
                adapter.setFilteredList(filteredList)
            }
        } else {
            //Kullanıcı seçimini temizleyince tüm liste gönderilir.
            adapter.setFilteredList(weatherList)
        }
    }

    private fun loadData() {
        /*  İnternetten veri çekme işlemleri için IO(input-output) threadine geçildi.Çünkün Main thread de ki bu işlemler kullanıcı arayüzünü bloklayarak
        ANR(Application Not Responding )(Uygulama Cevap Vermiyor),donma vs gibi hatalara sebep olur.
         */

        //Oluşturulan job nesnesine Dispatchers.IO ile arka planda çalışan(İlgili Xml dosyasını parse etme) bir iş atadık.
        job = CoroutineScope(Dispatchers.IO).launch {
            val dataResult = WeatherResult()
            weatherList = dataResult.getData()

            //withcontext(Dispatchers.Main) ile Main threadine geçilerek kullanıcı arayüzündeki gerekli işlemler yapıldı.
            withContext(Dispatchers.Main) {
                adapter = WeatherAdapter(weatherList)

                binding.apply {
                    rv.adapter = adapter
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                    rv.setHasFixedSize(true)
                }

                binding.searchView.setOnQueryTextListener(
                    object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return true
                        }

                        //Kullanıcının arama kısmına girmiş olduğu her karakter için tetiklenen fonksiyon.
                        override fun onQueryTextChange(newText: String?): Boolean {
                            filterList(newText)
                            return true
                        }
                    })
            }
        }

    }


}