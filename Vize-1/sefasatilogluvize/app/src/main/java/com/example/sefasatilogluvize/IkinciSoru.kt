package com.example.sefasatilogluvize

class IkinciSoru(var sayi:Int,var array:ArrayList<Int>) {

    fun terstenYazdirma() {

        for (i in sayi.toString()) {
            array.add(i.toString().toInt())
        }
        println("Sayilarin Tersi: ${array.reversed()}")

    }

}