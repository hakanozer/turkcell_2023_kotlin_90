package com.works.fifthassignment._4_interface


//Interfaceler belirli standartları olan taslaklar olarak düşünebiliriz
//Daha doğrusu şirket içinde kod yazımında belirli bir standart yazim yakalamak istiyorsak interface kullanabiliriz
//metodları abstracta olduğu gibi implement etmeyi zorunlu kılar
//Abstractan farkı metodun önünden interface kullanmaya gerek yoktur
//Diğer sınıflarda ve abstracta 1 sınıfa kalıtım verebiliyorken
//interfacete birden fazla miras alınabilir
interface IHesapla {
    fun cevreHesapla()
}

class Hesapla(val birinciKenar: Int, val ikinciKenar: Int): IHesapla {
    override fun cevreHesapla() {
        val sonuc = 2*birinciKenar*ikinciKenar
        println("Dikdörtgen/Kare çevre uzunluğu: $sonuc")
    }

}

fun main(args: Array<String>) {
    val hesapla = Hesapla(3,5)
    hesapla.cevreHesapla()
}
