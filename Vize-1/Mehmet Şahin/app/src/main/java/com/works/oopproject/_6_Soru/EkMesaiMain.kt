package com.works.oopproject._6_Soru

fun main(args: Array<String>) {
    val memur = Memur()
    val mudur = Mudur()
    val genelmudur = GenelMudur()

    println("""
        Memur maaşi: ${memur.maasHesaplama()}
        Mudur maaşi: ${mudur.maasHesaplama()}
        GenelMudur maaşi: ${genelmudur.maasHesaplama()}
        
    """.trimIndent())
}