package com.works.odev.Odev5

/**
 * Abstract (Soyut) Sınıf:
 * a. Soyut sınıfların yazılım geliştirmedeki rolünü açıklayınız. Soyut sınıfların
 * nasıl tanımlandığını ve soyut metotlarının nasıl kullanıldığını gösteren bir örnek veriniz.
 */

fun main(args: Array<String>) {

    /*
    abstract sınıflar genellikle ortak özelliklere veya işlevlere sahip alt sınıfların temelini oluşturur.
    soyut sınıflar , somut sınıfların ortak davranışlarını ve ya özelliklerini tanımlamak için kullanılır
    ve kod tekrarını azaltmaya yardımcı olur.
     */


    val futbolcu = Futbolcu("Mauro Emanuel İcardi Riveiro","Galatasaray")
    val basketbolcu = Basketbolcu("Chauncey Billups","emekli")
    val yuzucu = Yuzucu("Michael Phelps","Kelebek")

    futbolcu.sporYap()
    basketbolcu.sporYap()
    yuzucu.sporYap()

}