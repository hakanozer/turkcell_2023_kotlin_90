package com.works.odevler

/**
 * #1.
 * Notepad++ İle Bir Dosya Oluşturun
 * İçine 15 Tane Sayı Yazın (Arada Pozitif, Negatif Sayılarda Olsun)
 *
 * Uygulamanıza Bu Dosyanın Yolunu Vereceksiniz.Uygulamanız Ekrana
 * Dosyada Kaç Tane :
 * - Pozitif
 * - Negatif
 * - Tek
 * - Çift Sayı Olduğunu Bastıracak.
 */

import java.io.File
import java.util.Scanner


fun main(args: Array<String>) {

    val dosyaAdi = "sayılar.txt"
    val dosya = File(dosyaAdi)
    val scanner = Scanner(dosya)


    var tek = 0
    var cift = 0
    var pozitif = 0
    var negatif = 0

    while (scanner.hasNext()){
        val sayi = scanner.nextInt()

        if (sayi < 0){
            negatif++
        }else if (sayi > 0){
            pozitif++
        }
        if (sayi%2 == 0){
            cift++
        }else{
            tek++
        }
    }
    println("tek sayıların adeti: $tek,\nçift sayıların adeti: $cift," +
            "\npozitif sayıların adeti:$pozitif,\nnegatif sayıların adeti: $negatif")




}