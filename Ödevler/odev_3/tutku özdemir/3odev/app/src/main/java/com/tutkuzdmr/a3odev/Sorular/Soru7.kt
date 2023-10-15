package com.tutkuzdmr.a3odev.Sorular

import java.io.File

fun main(args: Array<String>) {
    print("Klasör yolunu girin: ")
    val klasorYolu = readLine()

    if (klasorYolu != null) {
        val klasor = File(klasorYolu)
        if (klasor.exists() && klasor.isDirectory) {
            val toplamBoyut = hesaplaKlasorBoyutu(klasor)
            val formatliBoyut = formatlayarakBoyutuGoster(toplamBoyut)
            println("Klasör ve altındaki tüm dosyaların toplam boyutu: $formatliBoyut")
        } else {
            println("Belirtilen klasör bulunamadı veya geçersiz.")
        }
    } else {
        println("Klasör yolu girilmedi.")
    }
}

fun hesaplaKlasorBoyutu(klasor: File): Long {
    var toplamBoyut = 0L

    if (klasor.isDirectory) {
        val dosyalar = klasor.listFiles()
        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isFile) {
                    toplamBoyut += dosya.length()
                } else if (dosya.isDirectory) {
                    toplamBoyut += hesaplaKlasorBoyutu(dosya)
                }
            }
        }
    }
    return toplamBoyut
}

fun formatlayarakBoyutuGoster(byte: Long): String {
    val kilobyte = 1024
    val megabyte = kilobyte * 1024
    val gigabyte = megabyte * 1024
    val terabyte = gigabyte * 1024

    return when {
        byte < kilobyte -> "$byte B"
        byte < megabyte -> "%.2f KB".format(byte.toDouble() / kilobyte)
        byte < gigabyte -> "%.2f MB".format(byte.toDouble() / megabyte)
        byte < terabyte -> "%.2f GB".format(byte.toDouble() / gigabyte)
        else -> "%.2f TB".format(byte.toDouble() / terabyte)
    }
}