package com.example.sefasatilogluodev4

import java.util.Scanner

data class Kisi(var ad: String = "", var soyad:String="", var telNo:String="") {

    fun kayitlariGoster(array: ArrayList<Kisi>) {
        if (array.isEmpty()) {
            println("Kayıtlı kişi bulunmuyor.")
        } else {
            println("Kayıtlı Kişiler:")
            for ((index, kisi) in array.withIndex()) {
                println("""
                    
                    ${index+1}.Kisi
                    Ad:${kisi.ad}
                    Soyad:${kisi.soyad}
                    Tel No: ${kisi.telNo}
                    *********************
                """.trimIndent())
            }
        }

    }
    fun temizleListeyi(array: ArrayList<Kisi>) {
        array.clear()
    }




}