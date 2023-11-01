package com.works.turkcellodevler.Odev_4

/*
2. 2 Tane Çok Uzun String Değeriniz Var

String a  = "23456789876543234567890987654567890";
String b =  "99999999999988888888882222222688981";

Bu İki Sayiyi Toplayacak Bir Uygulama Yazın
 */

fun main(args: Array<String>) {

    val strA = "23456789876543234567890987654567890"
    val strB = "99999999999988888888882222222688981"

    val bigA = strA.toBigInteger()
    val bigB = strB.toBigInteger()

    val result = bigA + bigB
    println("İki sayının toplamı = $result")

}