package com.nazlican.turkcellgelecegiyazanlarhomework5

abstract class SoyutSinif {
    abstract fun metot()
}

interface Arayuz {
    fun metot()
}

class BirlesikSinif : SoyutSinif(), Arayuz {
    override fun metot() {
        println("Metot çağrıldı")
    }
}

fun main() {
    val birlesikSinif = BirlesikSinif()
    birlesikSinif.metot()
}


//Bu örnekte SoyutSinif adında bir soyut sınıf (abstract class) ve Arayuz adında bir arayüz (interface) oluşturuyoruz.
//SoyutSinif sınıfı içinde metot adında soyut bir metot tanımlıyoruz. Bu metotun implementasyonu alt sınıflarda yapılacak.
//Arayuz arayüzünde ise metot adında bir metot tanımlıyoruz.
//Daha sonra BirlesikSinif adında bir sınıf oluşturuyoruz ve
// SoyutSinif sınıfını miras alarak (extends) ve Arayuz arayüzünü uygulayarak (implements) bu sınıfı birleştiriyoruz.
//Son olarak main fonksiyonunda BirlesikSinif sınıfından bir örnek oluşturuyoruz ve metot adındaki metodu çağırıyoruz.
//Bu sayede BirlesikSinif sınıfı hem SoyutSinif sınıfının soyut metotunu implemente edebiliyor hem de Arayuz arayüzündeki metodu uygulayabiliyor.