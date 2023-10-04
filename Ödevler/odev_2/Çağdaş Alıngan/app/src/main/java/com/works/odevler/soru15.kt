package com.works.odevler

import android.annotation.SuppressLint
import java.lang.Exception
import java.util.InputMismatchException
import java.util.Scanner

/**
 * 15- Kullanıcıdan iki değer alan ve bu değerlerin ortalamasını hesaplayıp
 * ekrana bastıran bir metod yazın.Eğer girilen inputlardan birisi integer
 * değilse "Lütfen integer değerler giriniz." diye uyarı ekrana bastırsın ve method
 * input almaya baştan başlasın. (Çağatay Çınar Lökçe)
 */
@SuppressLint("SuspiciousIndentation")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

        println("Değer giriniz")
        val a = scanner.nextInt()
        println("Değer giriniz")
        val b = scanner.nextInt()
    try {
        val sonuc = ort(a,b)
        println(sonuc)
    }catch (ex: Exception){
        println(ex.message)
    }
}

fun ort(a:Int,b:Int): Int{

    val hesapla =  (a+b)/2
    if (a != b){
        throw  InputMismatchException("hata")
    }
    return hesapla
}