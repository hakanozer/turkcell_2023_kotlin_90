package com.example.esmasalkim_odev6

import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var listvw: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listvw = findViewById(R.id.listview)


        val fetchDataTask = FetchDataTask()
        fetchDataTask.execute()
    }

    // veriyi listView'e çekme
    inner class FetchDataTask : AsyncTask<Void, Void, LinkedHashMap<String, MutableSet<String>>>() {

        override fun doInBackground(vararg params: Void?): LinkedHashMap<String, MutableSet<String>> {
            return gaziAntep()
        }

        override fun onPostExecute(result: LinkedHashMap<String, MutableSet<String>>?) {
            super.onPostExecute(result)

            result?.let { arr ->
                val arrayList = mutableListOf<String>()
                for ((anahtar, degerKumesi) in arr) {
                    arrayList.add(anahtar)
                    arrayList.addAll(degerKumesi)
                }

                val adapter = CustomArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, arrayList)
                listvw.adapter = adapter
            }
        }
    }

// İlçe başlık arka plan rengini değiştirme
    class CustomArrayAdapter(context: Context, resource: Int, objects: List<String>) :
        ArrayAdapter<String>(context, resource, objects) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val itemView = super.getView(position, convertView, parent) as TextView
            val item = getItem(position)

            if (item != null && item.contains("NÖBETÇİ ECZANELER")) {
                itemView.setBackgroundColor(Color.RED)
            } else {
                itemView.setBackgroundColor(Color.WHITE)
            }

            return itemView
        }
    }
// veriyi siteden çekme
    fun gaziAntep(): LinkedHashMap<String, MutableSet<String>> {
        val arr = LinkedHashMap<String, MutableSet<String>>()
        var set = mutableSetOf<String>()

        try {
            val url = "https://gaziantepeczaciodasi.com.gaziantepeo.org.tr/nobetci-eczaneler"
            val doc: Document = Jsoup.connect(url).timeout(15000).get()

            val tbody = doc.getElementsByTag("tbody")
            val elements: Elements = tbody[0].getElementsByTag("tr")
            for (item in elements) {
                var ilce = item.getElementsByClass("ilce-baslik").text()


                if (ilce != "") {
                    set = mutableSetOf<String>()
                    ilce = ilce.replace("YAZDIR", "")
                    ilce = ilce.trim()
                    arr.put(ilce, set)
                } else {
                    val title = item.getElementsByTag("td").text()
                    set.add(title)

                }
            }

            arr.forEach { key, value ->
                Log.d("Key", key)
                value.forEach {
                    Log.d("Eczane", it)
                }
            }

        } catch (ex: Exception) {
            Log.e("URL", ex.toString())
        }
        return arr
    }
    }
