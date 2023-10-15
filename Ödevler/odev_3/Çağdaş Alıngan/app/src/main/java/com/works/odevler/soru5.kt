package com.works.odevler

import java.io.File

/**
 * #5. 4. Sorudaki dump.txt yi, dump_rev_1.txt Dosyasına Tersten Yazdırın
 */
fun main(args: Array<String>) {

    val dosyaAdi =File("dump.txt")

    val tersCevirilenDosya = File("dump_rev_1.txt")


    val satir = dosyaAdi.readLines()
    val ters = satir.reversed()

    tersCevirilenDosya.printWriter().use {yaz ->
        ters.forEach {satirr ->
            yaz.println(satirr.reversed())

        }
    }

    println("Metin belgesi ters çevrildi")



}