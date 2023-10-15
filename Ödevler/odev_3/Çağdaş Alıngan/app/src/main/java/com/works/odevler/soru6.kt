package com.works.odevler

/**
 * #6. 4. Sorudaki dump.txt yi, dump_rev_2.txt Dosyasına, Kelime Sırasını Bozmadan Tersten Yazdırın
 *
 * Örnek : ali topu at 		-->  ila upot ta
 */

import java.io.File

fun main(args: Array<String>) {

    val dosyaAdi = File("dump.txt")

    val tersCevirilenDosya = File("dump_rev_2.txt")


    val kelimeler = dosyaAdi.readText().split(" ")
    val tersKelime = kelimeler.map { it.reversed() }

    tersCevirilenDosya.printWriter().use {yaz ->
        tersKelime.joinToString(" ").forEach {kelime ->
            yaz.print("$kelime")
        }
    }

    println("Metin belgesi kelime kelime çevrildi")
}