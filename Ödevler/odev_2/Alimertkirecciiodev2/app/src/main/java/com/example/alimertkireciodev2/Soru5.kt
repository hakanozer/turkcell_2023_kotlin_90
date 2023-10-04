package com.example.alimertkireciodev2

//5 - parametre olarak verilen kg ve boy (double)
//değerlerinden BMI'yi hesaplayip double
//olarak döndüren methodu yazın
//
fun boykilo(boy:Double,Kilo:Double):Double{

    val islem=Kilo/(boy*boy)
if (islem<18){
   println("İdael Kilonun Altındasınız!!")

}
    if (islem>19&&islem<24){
      println(  "İdeal Kilodasınız!")
    }
    if (islem>25 && islem<30){
        println( "İdaeal Kilonun Üstündesiniz!")
    }
    if (islem<50&&islem>30){
    println( "Obez Sınıfındasınız!!!!!")

    }else{
        "hatalı deger"
    }

    return islem

}
fun main(args: Array<String>) {
    val boy=1.75
    val kilo=65.0
var hesaplama=boykilo( boy,  kilo)

    println("Girilen Değerinizin Ortalaması: $hesaplama")
}