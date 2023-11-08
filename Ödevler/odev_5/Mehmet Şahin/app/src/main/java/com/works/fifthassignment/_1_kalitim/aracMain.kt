package com.works.fifthassignment._1_kalitim

fun main(args: Array<String>) {
    //alt sınıf
    //Gemi sınıfımız Arac sınıfından miras aldı
    //Gemi sınıfımız Arac sınıfının aracTuru, gidisYolu, hiz ve renk gibi özelliklerini aldı
    //Arac sınıfının metodu olan yazdir metodunu da aldık
    //Yani kalıtım sınıf özellik ve metodlarının başka bir sınıf tarafından kullanılabilmesi yani aktarılması işlemidir.
    val gemi = Gemi("gemi", "deniz", 300, "beyaz")
    gemi.yazdir()
}