package com.works.odevv5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*a. Yazılım geliştirmede "inheritance" (miras) nedir ve ne amaçla kullanılır? Bir örnek vererek açıklayınız?

Cevap:  kalıtım anne babadan cocuga geçen özellikler gibidir diyebiliriz. bir sınıfın başka bir sınıftan özellikler almasını sağlar

böylece kod tekrarını azaltır .


Abstraction:  soyutlamadır. Mesela siz arabayı çalıştırdıgınızda  arabanın nasıl çalıştıgına daie genel bir fikriniz olur ama

 tam ayrıntısını bilmezsiniz.   pistonlardan  nereye güç aktarıldıgını vs  bilmezsiniz.   Bu  bilgilere hakim olmadan da  gayet iyi

 arabayı kullanabilirsiniz.    yazılım kütüphanesinde de  fonksiyon kullanırken  fonksiyonun  içerisinde ne gibi işlemler döndügünü

 bilmenize gerek yok  sadece hangi tür parametreleri ve ne tür   degerler dönderdigini bilmeniz yeterli olur.   kodun daha yönetilebilir

 olmasını saglar .


 Polimorfizm:  kelime anlamı çok bicimliliktir. bir nesnenin birden fazla tipte olmasını saglar .  özetlemek gerekir ise

 farklı durumlar için tek bir arayüz saglayarak  karmaşıklıgı yönetmeye ve daha anlaşılır  kodlar yazmayı saglıyor .



 Interface:  örnekleyelim.   elektrik prizine  benzetebiliriz.     evdeki farklı elektronik aletlerin hepsi tarafında kullanılır

 elektrik prizi.  bu cihazların iç mekanizmasına da asla karışmaz .  sadece benim seni sarj etmemi istiyosan  uygun bir uç a sahip

 olmalı   ve bunu fiş e takman lazım der.     Yani kod dünyasında da  bir tür  sözleşme yada kural setidir  gibi diyebiliriz.


 şu metodları ımplemente etmen lazım  veya su işlevleri yerine getirmen lazım der .






 */


open class Hayvan(val isim: String, val yas: Int) {
    open fun sesCikar() {
        println("$isim ses çıkarıyor.")
    }

    fun yemekYe() {
        println("$isim yemek yiyor.")
    }
}


class Kedi(isim: String, yas: Int, val cins: String) : Hayvan(isim, yas) {
    override fun sesCikar() {
        println("$isim miyavlıyor.")
    }

    fun tirmala() {
        println("$isim tırmalıyor.")
    }
}

interface GeometrikSekil {
    fun alanHesapla(): Double
    fun cevreHesapla(): Double
}


class Daire(private val yaricap: Double) : GeometrikSekil {

    override fun alanHesapla(): Double {
        return Math.PI * yaricap * yaricap
    }

    override fun cevreHesapla(): Double {
        return 2 * Math.PI * yaricap
    }
}


class Kare(private val kenar: Double) : GeometrikSekil {

    override fun alanHesapla(): Double {
        return kenar * kenar
    }

    override fun cevreHesapla(): Double {
        return 4 * kenar
    }
}


fun yazdirSekilBilgileri(sekil: GeometrikSekil) {
    println("Alan: ${sekil.alanHesapla()}")
    println("Çevre: ${sekil.cevreHesapla()}")
}


abstract class Canli {
    abstract fun yemekYe()

    fun solunumYap() {
        println("Oksijen alınıp, karbondioksit veriliyor.")
    }
}


interface SesCikarabilen {
    fun sesCikar()
}


class Insan : Canli(), SesCikarabilen {
    override fun yemekYe() {
        println("İnsan yemek yiyor.")
    }

    override fun sesCikar() {
        println("İnsan konuşuyor.")
    }
}





fun main() {
    val kedi = Kedi("Felix", 3, "Van Kedisi")

    kedi.sesCikar()
    kedi.yemekYe()
    kedi.tirmala()

    println("Kedi adı: ${kedi.isim}")
    println("Kedi yaşı: ${kedi.yas}")
    println("Kedi cinsi: ${kedi.cins}")



    val daire = Daire(3.0)
    val kare = Kare(4.0)

    yazdirSekilBilgileri(daire)
    yazdirSekilBilgileri(kare)


    val insan = Insan()
    insan.yemekYe()
    insan.solunumYap()
    insan.sesCikar()



}

