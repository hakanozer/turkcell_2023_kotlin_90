package com.gorkemarslanbogan.oopodev


//Kalıtm inhertiance bir nesnenin üst sınıftan miras almasıdır nesne bir üst sınıfa benzer ve onun
//davranışlarını alır : ile nesneler arasında kalıtım ilişkisi kurulur
//bir nesne sadece bir üst sınıftan miras alabilir
//ata sınıftan alınan metodları ilgili sınıfa özel hale getirebiliriz buna ezme override denir.
//nesnelerin ortak özellikler ata sınıfta toplanır ve alt sınıflara aktarılabilir
//bu özellikler miras alınan sınıfta davranış değiştirebilir veya özelleştirilebilir.

open class Calisan(val name: String, val surname: String){
    private val asgariUcret = 11450
    override fun toString(): String {
        return "Ad: $name, Soyad: $surname"
    }
    open fun CalismayaBasla(){
        println("Çalışmıyor.")
    }
    open fun MaasHesapla(): Int {
       return asgariUcret
    }
}


class Kaynakci(name: String, surname: String) : Calisan(name, surname) {
    override fun CalismayaBasla() {
        println("Kaynakçi kaynak yapmaya başladı.")
    }

    override fun MaasHesapla(): Int {
        return super.MaasHesapla() + 200
    }
}


class Montajci(name: String, surname: String) : Calisan(name, surname) {
    override fun CalismayaBasla() {
        println("Montajci montaj yapmaya başladı.")
    }

    override fun MaasHesapla(): Int {
        return super.MaasHesapla()
    }
}

class Nakliyeci(name: String, surname: String) : Calisan(name, surname) {
    override fun CalismayaBasla() {
        println("Nakliyeci ürünleri getiriyor.")
    }

    override fun MaasHesapla(): Int {
        return super.MaasHesapla() + 1000
    }
}

fun main(args: Array<String>) {
    val kaynakci: Calisan = Kaynakci("Ahmet", "Dursun")
    val montajci: Calisan = Montajci("Sezai", "Kor")
    val nakliyeci: Calisan = Nakliyeci("Sezai", "Kor")
    montajci.CalismayaBasla()
    kaynakci.CalismayaBasla()
    nakliyeci.CalismayaBasla()

     fun calistir(calisan: Calisan) {
         calisan.CalismayaBasla()
     }
}