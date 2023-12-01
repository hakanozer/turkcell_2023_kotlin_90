package com.example.odev8alimertkirecci

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Hocam Cenazeden Dolayı Fazla Detaylı Yapamadım.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
      //veri hazırlığı
        var arabaisimleri =ArrayList<String>()
        arabaisimleri.add("Bebek yüz,Bmw3 serisi")
        arabaisimleri.add("Bmw 1 Serisi ")
        arabaisimleri.add("Elektrikli Bmw 7.40")
        arabaisimleri.add("Bmw F-10")
        arabaisimleri.add("BMW jip")
        arabaisimleri.add("3Serisi M-Sport")
        arabaisimleri.add("Porshe")
        arabaisimleri.add("87 Model 3 Serisi")
        arabaisimleri.add("Benzinli BMW 7.40")
        arabaisimleri.add("Elektrikli Tek Kapı Bmw")
        //

//verimsiz Şekilde Getimek
     /*  val Bebek3Bitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.bebekkasabmw)
        val Birserisi=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.bmwbir)
        val Eyedikirk=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.electric)
        val fon=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.fon)
        val jip=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.jeep)
        val Msport=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.msportuc)
        val porshe=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.porshe)
        val yirmiucserisi=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.yirmiucyenibmw)
        val tekkapielektrik=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.yariselektrikli)
        val yedikirkbenzin=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.yedikirkbenzinli)

        var arabagorselleri=ArrayList<Bitmap>()
        arabagorselleri.add(Bebek3Bitmap)
        arabagorselleri.add(Birserisi)
        arabagorselleri.add(Eyedikirk)
        arabagorselleri.add(fon)
        arabagorselleri.add(jip)
        arabagorselleri.add(Msport)
        arabagorselleri.add(porshe)
        arabagorselleri.add(yirmiucserisi)
        arabagorselleri.add(tekkapielektrik)
        arabagorselleri.add(yedikirkbenzin)
*/
        //verimli şekilde getirmek
        val  bebekkasabmwId=R.drawable.bebekkasabmw
        val  bmwbirId=R.drawable.bmwbir
        val  elektrikId=R.drawable.electric
        val  fonId=R.drawable.fon
        val  jeepId=R.drawable.jeep
        val  msportId=R.drawable.msportuc
        val  porsheId=R.drawable.porshe
        val  yirmiucId=R.drawable.yirmiucyenibmw
        val  YariselektirkId=R.drawable.yariselektrikli
        val  yedikirkbenzinId=R.drawable.yedikirkbenzinli

        var  arabadrawableListesi=ArrayList<Int>()
        arabadrawableListesi.add(bebekkasabmwId)
        arabadrawableListesi.add(bmwbirId)
        arabadrawableListesi.add(elektrikId)
        arabadrawableListesi.add(fonId)
        arabadrawableListesi.add(jeepId)
        arabadrawableListesi.add(msportId)
        arabadrawableListesi.add(porsheId)
        arabadrawableListesi.add(yirmiucId)
        arabadrawableListesi.add(YariselektirkId)
        arabadrawableListesi.add(yedikirkbenzinId)






        val layoutManager=LinearLayoutManager(this)
recyclerView.layoutManager=layoutManager


val adapter=RecyclerAdapter(arabaisimleri,arabadrawableListesi)
recyclerView.adapter=adapter

    }

}