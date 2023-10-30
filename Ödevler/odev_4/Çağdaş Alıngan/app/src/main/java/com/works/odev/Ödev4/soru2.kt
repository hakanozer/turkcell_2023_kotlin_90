package com.works.odev.Ödev4

import java.math.BigInteger

/**
 * 2. 2 Tane Çok Uzun String Değeriniz Var
 *
 * String a  = "23456789876543234567890987654567890";
 * String b =  "99999999999988888888882222222688981";
 *
 * Bu İki Sayiyi Toplayacak Bir Uygulama Yazın
 */
fun main(args: Array<String>) {

        val a = "23456789876543234567890987654567890"
        val b = "99999999999988888888882222222688981"


        val n1 = BigInteger(a)
        val n2 = BigInteger(b)


        val sum = n1.add(n2)

        println("Toplam: $sum")


}