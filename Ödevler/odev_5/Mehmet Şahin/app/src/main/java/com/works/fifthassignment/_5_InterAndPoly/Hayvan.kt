package com.works.fifthassignment._5_InterAndPoly

open class Hayvan(val sesCikarma: String, val ayakSayisi: Int, val ad: String) {
    open fun familya() {}
    open fun ozelliklerim() {}
}

class Kedi(
    val yetenek: String,
    sesCikarma: String,
    ayakSayisi: Int,
    ad: String
) : Hayvan(sesCikarma, ayakSayisi, ad) {

    override fun familya() {
        println("kedigiller")
    }

    override fun ozelliklerim() {
        println(
            """
            Yeteneğim: $yetenek
            Ses Çıkarma: $sesCikarma
            Ayak Sayisi: $ayakSayisi
        """.trimIndent()
        )
    }
}

class Guvercin(
    val yetenek: String,
    sesCikarma: String,
    ayakSayisi: Int,
    ad: String
) : Hayvan(sesCikarma, ayakSayisi, ad) {

    override fun familya() {
        println("güvercingiller")
    }

    override fun ozelliklerim() {
        println(
            """
            Yeteneğim: $yetenek
            Ses Cikarma: $sesCikarma
            Ayak Sayisi: $ayakSayisi
        """.trimIndent()
        )
    }
}