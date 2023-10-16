package com.example.alimertkireccidev3.Sorular


import java.io.File

fun main(args: Array<String>) {
    val Dosya="C:\\Users\\Barbaros\\Documents\\NotePad++\\yeni_1.txt"
    var pozitif=0
    var negatif=0
    var tek=0
    var cift=0
    File(Dosya).forEachLine {it.toInt()
        val sayi=it.toInt()
        if (pozitif>0){
            pozitif++
        }
        if (sayi<0){
            negatif++
        }
        if (sayi%2==0){
            cift++
        }
        if (sayi%2==1){
            tek++
        }
    }
    println( "Pozitif Tam Sayılar== $pozitif"  )
    println("Negatif Tam Sayılar==$negatif")
    println("Tek tam sayılar ==$tek")
    println("Çift Tam Sayilar ==$cift")
}
