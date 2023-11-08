package com.works.fifthassignment._4_interface

interface ITaslak1 {
    fun urunStokSayisi(stok: Int)
    fun urunOzellikleri(urunAdi: String, kategorisi: String)
}

interface ITaslak2 {
    fun urunTedarikSuresi(tedarik: Int)
}

class BilgiVer: ITaslak1, ITaslak2 {
    override fun urunStokSayisi(stok: Int) {
        println("Stok sayisi: $stok")
    }

    override fun urunOzellikleri(urunAdi: String, kategorisi: String) {
        println("""
            Ürün Adi: $urunAdi
            Kategorisi: $kategorisi
        """.trimIndent())
    }

    override fun urunTedarikSuresi(tedarik: Int) {
        println("Ürün tedarik süresi: $tedarik")
    }

}

fun main(args: Array<String>) {
    val bilgiver = BilgiVer()
    bilgiver.urunOzellikleri("Peynir", "kahvaltılık")
    bilgiver.urunStokSayisi(300)
    bilgiver.urunTedarikSuresi(5)

}