package com.works.turkcell.hw2

fun main(args: Array<String>) {
   val palsayi = palindrome(123321)
    println("$palsayi")
}

fun palindrome (sayi:Int):Boolean{
    var sonuc = false
    val girilenSayi = sayi.toString()
    val terstenOkunanSayi = sayi.toString().reversed()
    if (girilenSayi == terstenOkunanSayi){
        sonuc = true
    }
    return sonuc
}