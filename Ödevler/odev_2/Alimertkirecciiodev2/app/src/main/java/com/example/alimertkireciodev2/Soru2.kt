package com.example.alimertkireciodev2
//2 - Parametre olarak 2 int sayı alan,
//bu sayilarin (ilki hariç, 2.si dahil olmak
//üzere) toplamlarını döndüren bir method
//yazın
fun toplamHesapla(birinci: Int, ikinci: Int): Int {
    // İlk sayı hariç, ikinci sayı dahil olmak üzere toplamı hesapla
    var toplam = 0
    for (i in birinci + 1..ikinci) {
        toplam += i
    }
    return toplam
}
fun main() {
    val birinci = 28
    val ikinci = 36
    val islem = toplamHesapla(birinci, ikinci)
    println("$birinci ile $ikinci birinci sayı dahil edilmeden sayıların toplamı : $islem ")
}