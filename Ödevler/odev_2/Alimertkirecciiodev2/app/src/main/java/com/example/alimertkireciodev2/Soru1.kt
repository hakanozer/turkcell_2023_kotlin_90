package com.example.alimertkireciodev2
//1 - Parametre olarak aldığı sayıyı
//asal mı diye kontrol edip,
//sayı asal ise true, değilse false döndüren
//isPrime methodunu yazın

fun isPrime(parametre: Int):Boolean{
    if (parametre<=1){
return false
    }
//burda önemli olan n değeri 2 ile number yani girilen sayı değeri olarak bütün değerleri al bu n değerine eşittir!!
   //aşağı kısımda da aralıkdaki değerler bu sayıya mod olduğunda 0 a eşit oluyorsa sayı asal değildir!
 for (n in 2 until parametre){
     if (parametre%n==0){
       return false
        }
    }
    return true
}
fun main(args: Array<String>) {
    val parametre = 121
    val asalsayi = isPrime(parametre)
    println("Girilen $parametre Değeri bir asal sayı mı? $asalsayi")
}