package com.works.odevler

import android.annotation.SuppressLint


/**
3 - Parametre olarak 2 int sayi alan (a,b),
ilk sayi tek ise a/b'yi,
ilk sayi çift ise a%b'yi double olarak
döndüren bir method yazın
 */
fun main(args: Array<String>) {
    func(15,35)
}



@SuppressLint("SuspiciousIndentation")
fun func(a: Int, b: Int) {

        if (a % 2 == 1) {
          val x = a / b.toDouble()
            println(x)

        } else if (a % 2 == 0) {
            val y = a%b.toDouble()
            println(y)
        }

}