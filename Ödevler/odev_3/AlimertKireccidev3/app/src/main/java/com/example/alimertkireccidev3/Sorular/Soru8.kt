package com.example.alimertkireccidev3.Sorular
import java.io.File
import java.util.Scanner
fun Toplamboyutuhesapla(klasor: File): Double {
    var Boyutlarıntoplamı: Double = 0.0
    if (klasor.isDirectory) {
        val dosyalar = klasor.listFiles()
        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isFile) {
                    Boyutlarıntoplamı += dosya.length()
                } else if (dosya.isDirectory) {
                    Boyutlarıntoplamı += Toplamboyutuhesapla(dosya)
                }}}}
    return Boyutlarıntoplamı
}
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    print("Gitmek istediğiz Klasör edresini giriniz!== ")
    val klasoruzantısı = scanner.nextLine()
    val klasor = File(klasoruzantısı)
    if (!klasor.exists() || !klasor.isDirectory) {//dosyanınn var olup olmadığına bakmak için kullanılır isdirectory
        println("Belirtilen klasör bulunamadı veya geçerli değil.")
        return
    }
    val Dosyaboyutu = Toplamboyutuhesapla(klasor)
    val Kilobayt = Dosyaboyutu / 1024.0
    val Megebayt = Kilobayt / 1024.0
    val Gigabayt = Megebayt / 1024.0
    println("Klasörün Toplamda Aldığı Boyut:")
    println("Byte Türünden: $Dosyaboyutu bytes")
    println("Kilobayt Türünden: $Kilobayt Kilobayt")
    println("Megabayt Türünden: $Megebayt Megabayt")
    println("Gigabayt Türünden: $Gigabayt Gigabayt")
}

