package com.example.sefasatilogluodev5

/*

Polymorphism (Polimorfizm):
a. Polimorfizm yazılım geliştirmede ne anlama gelir ve neden önemlidir? Bir örnek ile açıklayınız.
b. Bir arayüz (interface) tanımlayın ve bu arayüzü uygulayan farklı sınıfları kullanarak polimorfik bir örnek yaratın. Polimorfizmin avantajları hakkında görüşlerinizi paylaşınız.

 */

//Cok bicimlilik Burada ise Bir otogaleri ye gittik orada araba bakiyoruz. Hangi markayi söylersek o arabayi getiriyorlar. Cok model var oldugu icin hangisini cagirirsak onu getiriyorlar.

//interface abstract sinifina benziyor ama onun biraz üst modeli olarak düşünebiliriz.
//İnterfacelerden nesne üretilemez, interfaceler sinif degildir.
//Birden fazla interface kalitim yoluyla miras alabilirsin.

//interface kullanimini burada acikladim Birden fazla interFace kullanimi sagladim.
//İnterface neden önemli -> Kotlinde ve bazi programlama dilleri de  dahil  coklu kalitisim yapmaya izin vermezler. Kotlin interface sayesinde coklu kalitim yapabiliyoruz.
//Araba örnegi vermistik o örnek üzerinde düşünürsek Toyata hybrid mesela sehir icinde hybrid kulllanıyor.Uzun yolda ise benzin tuketimi yapiyor.
// interface sayesinde arabaya bu 2 kalitim yaparak özelliklerini miras olarak kullanabiliyoruz.

interface OtoGaleri {

    fun arabaSecimi() {
        println("Araba Secildi!")
    }

}
interface BenzinliArac {
    fun benzinArabaSecimi() {
        println("Benzinli Araba Secildi!")
    }
}
interface ElektrikliArac {
    fun elektrikliArabaSecimi() {
        println("Elektrikli Araba Secildi")
    }
}
//Burada ise özel tipten genel tip donusumu yapiyoruz. "upcasting" islemi yaptik.
class Mercedes:OtoGaleri,BenzinliArac {
    override fun arabaSecimi() {
        println("Mercedes Secildi!")
    }

    override fun benzinArabaSecimi() {
        println("Benzinli Mercedes Secildi!")
    }
}
class Tesla:OtoGaleri,ElektrikliArac {

    override fun arabaSecimi() {
        println("Tesla Secildi!")
    }

    override fun elektrikliArabaSecimi() {
        println("Elektrikli Tesla Secildi!")
    }
}
//Polymorphism avantajı -> Daha az kod yazmamiza olanak saglar. Kodu az tekrar etmis oluyoruz ve daha anlasilir hale getirildi. Farklı türler icin aynı kodu kullanabiliriz.
//Genellikle test asamasinda kolaylık saglar.

fun main() {

    var mercedes = Mercedes()
    mercedes.arabaSecimi()
    mercedes.benzinArabaSecimi()
    println("*****************")
    var tesla = Tesla()
    tesla.arabaSecimi()
    tesla.elektrikliArabaSecimi()




}