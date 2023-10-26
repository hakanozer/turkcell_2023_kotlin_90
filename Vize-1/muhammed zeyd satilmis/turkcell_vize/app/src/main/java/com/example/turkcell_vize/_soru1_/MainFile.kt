package com.example.turkcell_vize._soru1_

fun main(args: Array<String>) {

//SORU 1 & 2 & 3 CEVAPLARI
    val uInput = UserInput()
    //Soru 1 :
    val basamakToplam = uInput.getInput("1515")
    //Soru 2 :
    val terstenSayi = uInput.getInput("12345")
    //Soru 3 :
    val faktoriyel = uInput.faktoriyelHesap(10)

    //Soru 4 & 5 CEVAPLARI
    val prime = Prime()
    //Soru 4 :
    val asalToplam = prime.getSumOfAllPrimes(341)
    //Soru 5 :
    val asalMi = prime.isPrime(4)

    //Soru 6 :
    val memur = Memur()
    println("${memur.isim} ${memur.ekSaatUcreti} ${memur.maas} ${memur.maasKatsayisi}")
    val mudur = Mudur()
    println("${mudur.isim} ${mudur.ekSaatUcreti} ${mudur.maas} ${mudur.maasKatsayisi}")
    val genelMudur = GenelMudur()
    println("${genelMudur.isim} ${genelMudur.ekSaatUcreti} ${genelMudur.maas} ${genelMudur.maasKatsayisi}")



    //Soru 7 & 8

//    Bir sınıfın örneğine "nesne" denir.
//    Bir nesne, bir sınıfın özelliklerini taşır ve sınıfın metodlarını çağırabilir.
//    Örneğin, "Araba" sınıfından oluşturulan bir "araba" nesnesi, o sınıfın özelliklerini (marka, model, vb.) taşır ve sınıfın metodlarını (sür, dur, vb.) çağırabilir.
//    Abstract (Soyut):
//
//    Soyut sınıflar, doğrudan örnek oluşturulamayan sınıflardır.
//    Soyut sınıflar, genellikle ortak özellikleri ve metodları tanımlamak için kullanılır.
//    Alt sınıflar, soyut sınıfın özelliklerini uygulamak zorundadır (aşırı yükleme veya aşırı yazma yoluyla).
//    Interface (Arayüz):
//
//    Bir arayüz, sınıflar arasında belirli davranışları tanımlamak için kullanılır.
//    Sınıflar, bir veya daha fazla arayüzü uygulayarak (implements) bu davranışları sağlamak zorundadır.
//    Arayüzler, çoklu kalıtımı (bir sınıfın birden fazla arayüzü uygulayabilmesi) destekler.
//    Erişim Belirteçleri (Access Modifiers):
//
//    Erişim belirteçleri, bir sınıfın, alanın veya metodun ne kadar görünür ve erişilebilir olduğunu belirler.
//    Kotlin'de sık kullanılan erişim belirteçleri şunlardır:
//    public: Her yerden erişilebilir.
//    private: Sadece aynı sınıf içinden erişilebilir.
//    protected: Aynı sınıf ve alt sınıflardan erişilebilir.
//    internal: Aynı modül içindeki sınıflardan erişilebilir.
//    Diğer sınıflarla etkileşime geçmeyi kontrol etmek için kullanılırlar, güvenlik ve sınıf tasarımını düzenlemek için önemlidirler.
}