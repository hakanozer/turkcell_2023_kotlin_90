package com.works.fifthassignment._3_polymorphism

fun main(args: Array<String>) {
    //Bir arayüzün veya superclassın metodlarını farklı amaca yönelik kullanmak polymorphism olarak adlandırılır
    val tren = Tren()
    tren.bilgiVer()

    val ucak = Ucak()
    ucak.bilgiVer()

}