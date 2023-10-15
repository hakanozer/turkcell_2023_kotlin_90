package com.works.odevler

import java.io.File

/**
 *#7. 4. Sorudaki dump.txt'de Her Kelimeden Kaç Kez Geçtiğini,
 * En Uzun Kelimenin Hangisi Olduğunu, Kaç Harf Olduğunu
 * En Kısa Kelimenin Hangisi Olduğunu ve Kaç Harf Olduğunu Ekrana Bastırın
 */
fun main(args: Array<String>) {

    val dosyaAdi = File("dump.txt")
    val enUzunKelime = enUzunKelimeyiBul(dosyaAdi.readText())
    val enKisaKelime = enKisaKelimeBul(dosyaAdi.readText())
    val toplamHarfSayisi = kacHarfVar(dosyaAdi.readText())
    val enUzunHarfSayisi = kacHarfVar(enUzunKelime)
    val enKisaHarfSayisi = kacHarfVar(enKisaKelime)

    println("doyadaki en uzun kelime = $enUzunKelime ")
    println("dosyadaki en kısa kelime = $enKisaKelime ")
    println("dosyadaki toplam harf sayısı = $toplamHarfSayisi")
    println("en uzun kelimenin harf sayısı = $enUzunHarfSayisi")
    println("en kısa kelimenin harf sayısı = $enKisaHarfSayisi")

}

fun enUzunKelimeyiBul(metin:String):String {

    val kelimeler = metin.split(" ")
    var enUzunKelime = ""
    for (kelime in kelimeler){

        if (kelime.length > enUzunKelime.length){
            enUzunKelime = kelime
        }
    }

return enUzunKelime
}

fun enKisaKelimeBul(metin: String):String{
    val kelimeler = metin.split(" ")
    var enKisaKelime = kelimeler[0]

    for (kelime in kelimeler){
        if (kelime.length < enKisaKelime.length ){
            enKisaKelime = kelime
        }

    }
    return enKisaKelime
}

fun kacHarfVar(metin: String):Int{
    var harfToplam = 0

    for (harf in metin){
        if (harf.isLetter() ){
            harfToplam++
        }
    }
    return harfToplam
}