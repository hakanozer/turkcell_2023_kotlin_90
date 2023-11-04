package com.example.sefasatilogluodev5

/*

Inheritance:
a. Yazılım geliştirmede "inheritance" (miras) nedir ve ne amaçla kullanılır? Bir örnek vererek açıklayınız.
b. Kotlin programlama dilinde bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş bir alt sınıf (derived class) tanımlayın.
Alt sınıfın üst sınıftan miras aldığı özellikleri ve metotları kullanarak bir örnek oluşturun.

 */


open class GeometrikSekiller() {

    var en:Int = 0
    var boy:Int = 0
    //Nesne olusturulmadan once arka plan init methodu bekler. Nesne olusturdugumuzda ilk calisacak methodtur. init methodu
    init {
        println("Nesne Olusturuldu!")
    }

    //Simdi Geometrik sinifimizi olusturduk. En ve boy degerlerini verecegiz. Bu geometrik sekillerden kalitim yaparak kare ve dikdortgen alt siniflarini olusturacagız. Burada ki temel amac
    //Burada kare ve dikdortgen'de aynı özelliklerini var olmasidir. Geometrik sekilde ki özellikler kare ve dikdortgene inherit edecegiz. Yani miras alacağız.
    //Eger bir sinif kalitim alacaksa open anahtar kelimesini koymamiz gerekiyor. Bu sayede alt siniflar kalitim yapabileceklerdir.

    open fun AlanHesapla() {
        println("Geometrik Alani: ${en * boy}") //Burada alan hesapllla yaptik daha sonra override islemi yapacagız. Miras alacağız.
    }


}
//Kare sinifi olusturduk Burada Geometrik sekkillerinden kalitim yoluyla tum özelliiklerini kullancagiz. Bir siniftan kalitimi ': ' yoluyla alabiliriz.
class Kare: GeometrikSekiller() {

    // burada ise üst sınıfın özelliklerini override ile aliyoruz.
    override fun AlanHesapla() {
        println("Karenin Alani : ${en*boy}") // Burada üst siniftan en boy özelliklerini aldık.
    }

}
class Dikdortgen:GeometrikSekiller() {

    override fun AlanHesapla() {
        println("Dikdortgenin Alani: ${en*boy}")
    }

}



fun main() {

    /*inheritance(Kalıtım) :  Bir türetilen siniftan özelliklerini ve diğer davranışlarını bir alt sinifa miras birakmasidir.
    Anne babamizin genlerinden alarak bizler oldugumuzda onların genleri alt sinifa yani bizlere iletmiş oluyor. Onlarin özelliklerini alıyoruz.

    */

    //Nesnemizi olsuturuyoruz.
    var kare = Kare()
    kare.en = 12
    kare.boy = 12
    //Burada simdi alanimizi hesaplayacagimiz fonksiyonu cagiriyoruz.
    kare.AlanHesapla()

    var dikdortgen = Dikdortgen()
    //Dikdortgenin alani kisa kenar ile uzun kenari carparsak sonucu bulabiliriz.
    dikdortgen.en = 5
    dikdortgen.boy = 7
    dikdortgen.AlanHesapla()
}