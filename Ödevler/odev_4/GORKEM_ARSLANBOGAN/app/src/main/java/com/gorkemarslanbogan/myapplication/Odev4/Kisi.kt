package com.gorkemarslanbogan.myapplication.Odev4

import java.util.*
import kotlin.collections.ArrayList


data class Kisi(var ad: String, var soyad: String, var tel: String) {
    override fun toString(): String {
        return " Kişi Adı: $ad \n  Kişi Soyadı: $soyad \n  Kişi Telefon: $tel"
    }
}

interface IKisi {
    fun TumKayitlariGoster()
    fun KisiMenu()
    fun YeniKayitEkle()
    fun KayitSil()
    fun KayitGuncelle()
    fun IsimSoyisimIleArama()
    fun TelefonNoIleArama()
    fun TumunuTemizle()
}

class KisilerYonetimi : UserProcessAbstractClass(), IKisi {
    private val kisiler = ArrayList<Kisi>()

    init { KisiMenu() }

    override fun TumKayitlariGoster() {
        if(kisiler.isNotEmpty()){
            kisiler.forEach {
                EkranaYazdir(it.toString())
            }
        }else {
            EkranaYazdir("Kayıt bulunamadı..")
        }
    }

    override fun KisiMenu() {
            while (true) {
                EkranaYazdir("\nMenü:")
                EkranaYazdir("1 - Tüm Kayıtları Göster")
                EkranaYazdir("2 - Yeni Kayıt Ekle")
                EkranaYazdir("3 - Kayıt Sil")
                EkranaYazdir("4 - Kayıt Güncelle")
                EkranaYazdir("5 - Tümünü Temizle")
                EkranaYazdir("6 - Kayıt Ara (Ad veya Soyada Göre)")
                EkranaYazdir("7 - Kayıt Ara (Telefon Numarasına Göre)")
                EkranaYazdir("8 - Çıkış")
                when (getUserInput("Seçiminizi giriniz:", "int")) {
                    1 -> TumKayitlariGoster()
                    2 -> YeniKayitEkle()
                    3 -> KayitSil()
                    4 -> KayitGuncelle()
                    5 -> TumunuTemizle()
                    6 -> IsimSoyisimIleArama()
                    7 -> TelefonNoIleArama()
                    8 -> {
                        EkranaYazdir("Çıkış yapılıyor.")
                        return
                    }
                    else -> EkranaYazdir("Hatalı seçim. Lütfen 1-8 arasında bir seçenek girin.")
                }
            }
    }

    override fun YeniKayitEkle() {
            val name = getUserInput("İsim:", "") as String
            val surname = getUserInput("Soyisim:", "") as String
            val phone = getUserInput("Telefon numarası:", "") as String
            kisiler.add(Kisi(name, surname, phone))
            EkranaYazdir("Kayıt başarıyla eklendi..")
    }

    override fun KayitSil() {
        if(kisiler.isNotEmpty()) {
            val phone = getUserInput("Telefon numarası:", "") as String
            kisiler.removeIf { kisiler.isNotEmpty() &&  it.tel == phone }
            EkranaYazdir("Kayıt başarıyla silindi..")
        }
    }

    override fun KayitGuncelle() {
        if (kisiler.isEmpty()) {
            EkranaYazdir("Güncellenecek kayıt bulunmuyor.")
        } else {
            val guncellenecekKisi = getUserInput("Güncellenecek kaydın telefon numarasını girin:", "")
            if (kisiler.isNotEmpty()) {
                for (item in kisiler){
                    if(item.tel == guncellenecekKisi) {
                        item.ad = getUserInput("Yeni Ad:", "") as String
                        item.soyad = getUserInput("Yeni Soyad:", "") as String
                        item.tel = getUserInput("Yeni telefon numarası:", "") as String
                        EkranaYazdir("Kayıt güncellendi.")
                        break
                    }else {
                        EkranaYazdir("Kayıt bulunamadı!")
                    }
                }

            } else {
                EkranaYazdir("Geçersiz bir numara girdiniz.")
            }
        }
    }

    override fun IsimSoyisimIleArama() {
        if(kisiler.isNotEmpty()) {
            val name = getUserInput("İsim:", "") as String
            val surname = getUserInput("Soyisim:", "") as String
            val kisi = kisiler.filter { it.ad.toLowerCase(Locale.ROOT) == name.toLowerCase()
                    && it.soyad.toLowerCase(Locale.ROOT) == surname.toLowerCase() }
                if(kisi.isNotEmpty())
                EkranaYazdir("Kayıt bulundu..")
                EkranaYazdir(kisi.toString().substring(1, kisi.toString().length-1))
        }else {
            EkranaYazdir("Kayıt bulunamadı!")
        }
    }

    override fun TelefonNoIleArama() {
        if(kisiler.isNotEmpty()) {
            val phone = getUserInput("Telefon numarası:", "") as String
            val kisi = kisiler.filter {it.tel == phone }
                if(kisi.isNotEmpty())
                EkranaYazdir("Kayıt bulundu..")
                EkranaYazdir(kisi.toString().substring(1, kisi.toString().length-1))
        }else {
            EkranaYazdir("Kayıt bulunamadı!")
        }
    }

    override fun TumunuTemizle() {
        if(kisiler.isNotEmpty()){
            kisiler.clear()
            EkranaYazdir("Kayıtlar başarıyla silindi..")
        }else {
            EkranaYazdir("Silinecek kayıt bulunamadı!")
        }
    }
}