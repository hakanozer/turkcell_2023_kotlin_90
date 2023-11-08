package com.example.odev_5

fun main(args: Array<String>) {
    val bitki=Bitki("Çam Ağacı", 20)
    bitki.cicekAcıyor()
    val  cicek = Cicek("Gül", 2, "Kırmızı")
    cicek.cicekAcıyor()


    // soru2 çağrımı (abstract)
    val ogrenciBilgi = Ogrenci("ESMA", "SALKIM", "234463")
    val ogretmenBilgi = Ogretmen("AHMET", "SALKIM", "BİLGİSAYAR")

    println(ogrenciBilgi.bilgileriGoster())
    println(ogretmenBilgi.bilgileriGoster())

// Soru3
    val esmaBilgi = EsmaSalkimOgrencisi()
    val ahmetBilgi = AhmetSalkimOgrencisi()

    anaProgramBilgisi(esmaBilgi)
    anaProgramBilgisi(ahmetBilgi)


    // soru4

    val esma = EsmaSalkim()
    val diger = DigerOgrenciler()

    anaProgram(esma)
    anaProgram(diger)



    // soru5 Interface (Arayüz):
    //a. Bir interface tanımlayın ve bu interface'i uygulayan bir sınıfı göstererek nasıl çalıştığını açıklayınız.

    val esmaSonuc = EsmaSonuc()
    esmaSonuc.sonucBildir(100)


    // Çoklu interface

    val egitimSonuc = TurkcellSonuc()
    egitimSonuc.SinavSonucBildir(100)
    egitimSonuc.iseAlimSonucBilgisi("olumsuz ama sonuna kadar savaşmaya devam")



    //Inheritance ve Polymorphism:
    //a. "Hayvan" adında bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş farklı hayvan
    // türlerini temsil eden alt sınıflar (örneğin, "Köpek" ve "Kedi") oluşturun.
    // Polimorfizm kullanarak bu hayvanları bir dizi içinde depolayın ve özelliklerine nasıl erişeceğinizi gösterin.


    val hayvanlar: Array<Hayvan> = arrayOf(Köpek("Sivas Kangalı"), Kedi("Van Kedisi"))

    for (hayvan in hayvanlar) {
        println("${hayvan.ad} şu şekilde ses çıkarıyor:")
        hayvan.hayvanSesiniCikar()
    }

    /*
    Abstract ve Interface Kullanımı:
a. Bir soyut sınıf (abstract class) ve bir arayüz (interface) oluşturun.
Bu soyut sınıfı ve arayüzü bir sınıfta nasıl birleştirirsiniz?
 Bu birleştirme sonucunda hangi özelliklere ve metotlara erişebilirsiniz?
     */

    val sonuc = EgitimSonuc(100.0)

    println("Sınav sonucunuz: ${sonuc.sinavSonucHesapla()}")
    println("Eğitim organize eden cevap: ${sonuc.egitimSonucAcikla()}")
    sonuc.cokCalis()


}
/*
 Inheritance:
a. Yazılım geliştirmede "inheritance" (miras) nedir ve ne amaçla kullanılır? Bir örnek vererek açıklayınız.

---> "inheritance" : Bir sınıfın özelliklerini başka bir sınıfa miras bırakma işlemidir.
                  kullanım amaçlarının başında kodun tekrar kullanılabilir olmasını sağlamak ve kodun organize bir şekilde
                  çalışmasını sağlamak.
                  Örneğin; Bitki sınıfımız olsun. Bu sınıfta bitkinin ismi , boyu vs. gibi özellikleri olsun.
                           Bu sınıfı başka bir sınıfa miras vererek diğer bitkiyi tanımlayabilir ve kalan özelliklerini ekleyebiliriz.

b. Kotlin programlama dilinde bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş bir alt sınıf
(derived class) tanımlayın. Alt sınıfın üst sınıftan miras aldığı özellikleri ve metotları kullanarak bir örnek oluşturun.
  */

// üst sınıf
open class Bitki (val ad:String, val yas: Int){
    open fun cicekAcıyor(){
        println("$ad Çiçek Açıyor")
    }
}
//Alt sınıf
class Cicek (ad: String, yas: Int , val renk:String):Bitki(ad, yas) {
    override fun cicekAcıyor() {
        println("$renk $ad çiçek açıyor")
    }
}

// Abstract (Soyut) Sınıf:
//a. Soyut sınıfların yazılım geliştirmedeki rolünü açıklayınız.
// Soyut sınıfların nasıl tanımlandığını ve soyut metotlarının nasıl kullanıldığını gösteren bir örnek veriniz.


// CEVAP : Abstract classlar arasında karmaşıklıkların önüne geçmek , kullanımı sıklıkla yapılan özelliklerin kullanımını mkolaylaştırmak
// tek yerden yönetimini sağlamak açısından önemlidir. Yeni classların oluşturulmasına kalıtım vererek olanak sağlar .
//Aynı yöntemi farklı kullanım şekillerinde uygulamada kolaylık sağlar. Daha temiz,esnek ve etkileşimli bir kod yazmaya olanak sağlar.

// Abstract örneği ; insan abstract sınıfı oluşturulup , öğretmen ve öğrenci yapısı örneği aşağıdadır ;

abstract class InsanClass(val ad: String, val soyad: String) {
    abstract fun bilgileriGoster(): String
}

class Ogrenci(ad: String, soyad: String, val okulNumarasi: String) : InsanClass(ad, soyad) {
    override fun bilgileriGoster(): String {
        return "Öğrenci: $ad $soyad, Okul Numarası: $okulNumarasi"
    }
}

class Ogretmen(ad: String, soyad: String, val brans: String) : InsanClass(ad, soyad) {
    override fun bilgileriGoster(): String {
        return "Öğretmen: $ad $soyad, Branşı: $brans"
    }
}


// Polymorphism (Polimorfizm):
//a. Polimorfizm yazılım geliştirmede ne anlama gelir ve neden önemlidir? Bir örnek ile açıklayınız.
//b. Bir arayüz (interface) tanımlayın ve bu arayüzü uygulayan farklı sınıfları kullanarak polimorfik
// bir örnek yaratın. Polimorfizmin avantajları hakkında görüşlerinizi paylaşınız.

/*
 CEVAP : Bir nesnenin farklı şekilde davranabilme yeteneğinin adıdır. Kodun daha esnek ve genel etkileşim açısından genişletilmiş
olmasını sağlar. Yani override kullanımı ile bir çok sınıftan istenilen metodun çağrımını yaparak classlar
 içerisinde kod tekrarının önüne geçer
Bu sayede değişiklik yapılacağında (özellikle birden fazla kişinin çalıştığı yapılarda , örneğin TFS gibi 4
 kod taşıma yapılan şirketlerde)
aynı nesnede birden fazla kişininn çalışması durumunda herkes için kolaylık sağlar. Zira tek bir değişiklik
 ile diğer kişilerin değişiklikleri etkilenmden
süreç tamamlanabilir.r
,*/


//Aşağıda örnek ile açıklamaya çalışacağım .
// Öğrenciler için bir örnek verildi.Bu örnekte öğrencilerden şirket seçim cevapları alındı.


/*
Polimorfizm avantajları :
Kodun daha esnek,anlaşılır ve yorumlanabilir olmasını sağlar.
Etkileşimi daha az olacğından çok fazla geliştiricinin olduğu şirketlerde kullanımı etkileşimin önüne geçmek için önemlidir.
Kod tekrarını minimize eder. Aynı metotların her class içerisinde yazılmamasına olanak sağlarr. ,,
 */

open class OgrencilerSirketSecim {
    open fun sirketSecimBilgisi() {
        println("TURKCELL")
    }
}

class EsmaSalkimOgrencisi : OgrencilerSirketSecim() {
        override fun sirketSecimBilgisi() {
            println("TURKCELL DE ÇALIŞMAK İSTİYORUM!")
        }
}

class AhmetSalkimOgrencisi : OgrencilerSirketSecim() {
    override fun sirketSecimBilgisi() {
        println("ZİRAAT TEKNOLOJİDE ÇALIŞMAKTAN MEMNUNUM")
    }
}

fun anaProgramBilgisi(ogrenci: OgrencilerSirketSecim) {
    ogrenci.sirketSecimBilgisi()
}


// Polimorfizm

interface EgitimSonundaCalisacaklar {
    fun ogrenciCalismaBilgisi()
}

class EsmaSalkim : EgitimSonundaCalisacaklar {
    override fun ogrenciCalismaBilgisi() {
        println("Çok emek veriyorum ancak mezuniyet tarihim eski..")
    }
}

class DigerOgrenciler : EgitimSonundaCalisacaklar {
    override fun ogrenciCalismaBilgisi() {
        println("Mezuniyet tarihi kriterini sağladığınız için olumludur.")
    }
}

fun anaProgram(ogrenci: EgitimSonundaCalisacaklar) {
    ogrenci.ogrenciCalismaBilgisi()
}



/*
Interface (Arayüz):
a. Arayüzler (interface) yazılım geliştirmede hangi amaçlarla kullanılır? Bir interface tanımlayın ve bu interface'i uygulayan bir sınıfı göstererek nasıl çalıştığını açıklayınız.
b. Birden fazla interface'i aynı sınıf içinde nasıl uygularsınız? Bu çoklu arayüz uygulamalarının neden önemli olduğunu açıklayınız.



CEVAP :
Kod mimarisinin sağlanmasında etkilidir.
Aynı sınıf içerisinde mimari kuralları sağlar. Bu sayede diğer yazılımcıların nasıl kod geliştireceğini belirler.


İnterface örnek aşağıdadır :


 */

interface SinavSonucBilgisi {
    fun sonucBildir(not: Int)
}

class EsmaSonuc : SinavSonucBilgisi {
    override fun sonucBildir(sonuc: Int) {
        println("Esma Salkım kotlin vize sonucunuz : $sonuc olup, almış olduğunuz sonuçtan dolayı tebrik ederiz.")
    }
}

//b Birden fazla interface'i aynı sınıf içinde nasıl uygularsınız? Bu çoklu arayüz uygulamalarının neden önemli olduğunu açıklayınız.

/*
Birden fazla arayüzü aynı sınıf içinde uygulamak için Kotlin'de virgülle ayrılmış şekilde birden fazla arayüz belirtilebilir.
Bu çoklu arayüz uygulamaları, bir sınıfın birden fazla davranışı veya sözleşmeyi taşımasına olanak tanır.Örnek aşağıdadır.
 */

interface Vize1SonucBilgisi {
    fun SinavSonucBildir(not: Int)
}

interface IseAlimBilgisi {
    fun iseAlimSonucBilgisi(not: String)
}

class TurkcellSonuc : Vize1SonucBilgisi, IseAlimBilgisi {
    override fun SinavSonucBildir(not: Int) {
        println("Esma Salkım kotlin vize sonucunuz : $not olup, almış olduğunuz sonuçtan dolayı tebrik ederiz.")
    }

    override fun iseAlimSonucBilgisi(not: String) {
        println("Mezuniyet tarihiniz geride olduğundan : $not ")
    }
}

/*
Inheritance ve Polymorphism:
a. "Hayvan" adında bir üst sınıf (base class) oluşturun ve bu sınıftan
türetilmiş farklı hayvan türlerini temsil eden alt sınıflar (örneğin, "Köpek" ve "Kedi") oluşturun.
 Polimorfizm kullanarak bu hayvanları bir dizi içinde depolayın ve özelliklerine nasıl erişeceğinizi gösterin.

 */

open class Hayvan(val ad: String) {
    open fun hayvanSesiniCikar() {
        println("Şuan için boş")
    }
}
class Köpek(ad: String) : Hayvan(ad) {
    override fun hayvanSesiniCikar() {
        println("$ad HAV HAVV")
    }
}

class Kedi(ad: String) : Hayvan(ad) {
    override fun hayvanSesiniCikar() {
        println("$ad MİYAVV MİYAVVV")
    }
}

/*
Abstract ve Interface Kullanımı:
a. Bir soyut sınıf (abstract class) ve bir arayüz (interface) oluşturun. Bu soyut sınıfı ve arayüzü bir
sınıfta nasıl birleştirirsiniz?
 Bu birleştirme sonucunda hangi özelliklere ve metotlara erişebilirsiniz?
 */

abstract class KotlinEgitim {
    abstract fun sinavSonucHesapla(): Double
    abstract fun egitimSonucAcikla(): String
}

interface egitimSonucDegistirilebilir {
    fun cokCalis()
}

class EgitimSonuc : KotlinEgitim, egitimSonucDegistirilebilir {
    private val sinavSonucu: Double

    constructor(sinavSonucu: Double) {
        this.sinavSonucu = sinavSonucu
    }

    override fun sinavSonucHesapla(): Double {
        return sinavSonucu
    }

    override fun egitimSonucAcikla(): String {
        return "Mezuniyet tarihiniz eskidir."
    }

    override fun cokCalis() {
        println("Ancak çok çalışarak bizimle çalışmaya hak kazandınız.")
    }
}





