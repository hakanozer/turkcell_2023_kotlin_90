package com.example.odev3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class ReadFile {


    companion object{
        fun get(path: File): List<Any> {
            val list = mutableListOf<Any>()
            var data : String? = null
            try {
                // Dosyayı okuma işlemi yapmak için BufferedReader
                val bufferedReader = BufferedReader(FileReader(path))

                var satir: String?
                var count = 0

                // Dosyayı satır satır okur ve ekrana yazdırır
                while (bufferedReader.readLine().also { satir = it } != null) {
                    //println(satir)
                    list.add(satir!!)

                }
                bufferedReader.close() // Dosya okuma işlemi bittikten sonra BufferedReader'ı kapatılır.

            } catch (e: IOException) {
                e.printStackTrace()
            }
            return list
        }

        fun getData():String{
            print("Klasör yolunu girin: ")
            val filePath = readLine()!!
            return filePath
        }
    }

}