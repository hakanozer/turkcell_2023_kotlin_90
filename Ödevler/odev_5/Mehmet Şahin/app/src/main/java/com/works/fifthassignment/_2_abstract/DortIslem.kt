package com.works.fifthassignment._2_abstract


//Çoklu sınıflar arasında ortak özellik ve davranışları almamızı sağlar.
//Abstraclar doğrudan nesne oluşturamayız
//Soyut sınıfların alt sınıfları metodları uygulamak implement etmek zorundadır
abstract class DortIslem(var list: List<Int>) {
    //Metod sonuna {} kullanılmayacak ise metod önüne abstract eklenmelidir
    abstract fun topla()
    abstract fun carp()
}

class ToplaCarp(list:List<Int>) : DortIslem(list) {
    override fun topla() {
        var toplam = 0
        for(i in list) {
            toplam +=i
        }
        println("Sayıların toplamı: $toplam")

    }

    override fun carp() {
        var carpim =1
        for(i in list) {
            carpim *=i
        }
        println("Sayıların çarpımı: $carpim")

    }

}