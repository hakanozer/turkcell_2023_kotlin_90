package com.work_turkcell._odev_5

/* 1-a)
Miras, bir sınıfın (alt sınıf) başka bir sınıftan (üst sınıf) özelliklerini ve davranışlarını miras almasıdır. Bu sayede,
alt sınıf, üst sınıfın özelliklerine ve davranışlarına doğrudan erişebilir ve bunları kullanabilir.
Miras, kod tekrarını önlemek, kodunuzu daha organize etmek ve bir sınıftaki değişikliklerin diğer sınıfları da etkilemesini
sağlamak için kullanılabilir.
Örneğin, bir "Ürün" sınıfı tanımlayabiliriz. Bu sınıf, tüm ürünlerin ortak özelliklerini içerebilir, örneğin:

class Ürün {
val adı: String
val fiyatı: Double
}
Bu sınıftan "Kitap", "Bilgisayar" ve "Telefon" gibi alt sınıflar türetebiliriz. Bu alt sınıflar, "Ürün" sınıfından "adı" ve
"fiyatı" özelliklerini miras alabilirler.
Bu sayede, "Ürün" sınıfı, tüm ürünlerin ortak özelliklerini kapsayan bir üst sınıf olarak kullanılabilir.
Bu, kodunuzu daha organize ve yönetilebilir hale getirir.
Miras, bir sınıftaki değişikliklerin diğer sınıfları da etkilemesini sağlayabilir. Örneğin, "Ürün" sınıfında bir değişiklik
yaparsak, bu değişiklik tüm "Kitap" ve "Telefon" alt sınıflarını da etkiler. Bu, kodunuzun daha tutarlı olmasını sağlar.
Sonuç olarak, miras, yazılım geliştirmede oldukça kullanışlı bir araçtır. Kod tekrarını önlemek, kodunuzu daha organize etmek
ve bir sınıftaki değişikliklerin diğer sınıfları da etkilemesini sağlamak için kullanılabilir.
 */

// 1-b)
open class Sekil {
    open val renk: String
    open val alan: Double
    constructor(renk: String, alan: Double) {
        this.renk = renk
        this.alan = alan
    }
    fun ciz() {
        println("Şekil çiziliyor")
    }
}
class Kare(renk: String, alan: Double) : Sekil(renk, alan) {
    fun kareCiz() {
        println("Kare çiziliyor")
    }
}
fun main(args: Array<String>) {
//1
    val kare = Kare("Sarı", 1.0)
    println(kare.renk)
    println(kare.alan)
    kare.kareCiz()

//2
    val dikdortgen = Dikdortgen("Kırmızı", 1.0)
    dikdortgen.ciz()

//3
    var sekil: ISkl = Daire()
    sekil.ciz()
    sekil = Ucgen()
    sekil.ciz()

//4a
    val sekl: ISekl = Yamuk()
    sekl.ciz()

//5
    val hayvanlar = arrayOf(
        Kopek("Alas", "Köpek"),
        Kedi("Lila", "Kedi")
    )
    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
        println(hayvan.ad)
    }

//6
    val dikdortgenn = Dikdortgenn()
    dikdortgenn.ciz()
    dikdortgenn.renklendir("Kırmızı")
}

//2
/*
Soyut sınıflar, yazılım geliştirmede soyutlama kavramını uygulamak için kullanılır. Soyutlama, bir sistemin ayrıntılarını
gizleyerek daha kolay anlaşılmasını ve kullanılmasını sağlayan bir tekniktir.
Soyut sınıflar, soyut metotları aracılığıyla soyutlama sağlar. Soyut metotlar, gövdeleri olmayan metotlardır.
Soyut metotlar, alt sınıflar tarafından override edilmelidir.
Soyut sınıflar, yazılım geliştirmede aşağıdaki rolleri oynar:
Kod tekrarını azaltır. Soyut sınıflar, ortak özellikleri ve davranışları tanımlamak için kullanılabilir. Bu, alt sınıflar
tarafından tekrar tekrar tanımlanması gereken kodu azaltır.
Kod okunabilirliğini ve anlaşılabilirliğini artırır. Soyut sınıflar, ortak özelliklerin ve davranışların bir özetini sağlar.
Bu, kodu daha kolay anlaşılmasını ve okunmasını sağlar.
Kod testini kolaylaştırır. Soyut sınıflar, alt sınıflar tarafından implemente edilen soyut metotları aracılığıyla soyutlama
sağlar. Bu, soyut sınıfları test etmeyi kolaylaştırır.
Kotlin'de bir soyut sınıf tanımlamak için "abstract" anahtar kelimesini kullanırız. Soyut bir sınıf, soyut metotlar
içerebilir ve bu metotların gövdesi olmaz. Alt sınıflar, soyut metotları uygulamak zorundadır.
 */

abstract class Sekl {
    abstract fun ciz()
}
open class Dikdortgen(renk: String, alan: Double) : Sekl() {
    override fun ciz() {
        println("Dikdörtgen çiziliyor")
    }
}

/*
3-a)
Polimorfizm, bir nesnenin farklı şekillerde yorumlanabileceği veya davranabileceği yeteneğidir.
Bu, kodun daha esnek ve genişletilebilir olmasını sağlar ve nesneler arasındaki etkileşimi kolaylaştırır
Polimorfizmin önemli nedenleri şunlardır:
Kodun yeniden kullanılabilirliği: Polimorfizm, birçok nesne türünün aynı arayüzü kullanabilmesine olanak tanır. Bu, aynı
işlevselliği paylaşan farklı nesnelerin kodun tekrarını önlemesine ve daha az kod yazılmasına yardımcı olur.
Genişletilebilirlik: Yeni nesne türleri eklediğinizde veya var olanları değiştirdiğinizde, kodunuzu daha az etkileyecek
şekilde yapabilirsiniz. Bunu yapmak, yazılımınızın genişletilebilirliğini artırır.
Daha az bağımlılık: Polimorfizm, bağımlılığı azaltır. Bir sınıfın sadece belirli bir arayüzü uygulaması gerektiği için,
kodunuzun farklı parçaları birbirinden daha bağımsız hale gelir.
 Örneğin,
Bir bilgisayar oyunu geliştirelim. Oyundaki karakterlerinizi temsil etmek için "Karakter" adında bir sınıf var.
Her karakterin belirli bir "saldır" metodu olsa da, farklı karakterlerin bu metodu farklı şekillerde uyguladığını düşünün.
Örneğin, bir kahraman karakter "silahla saldır" fonksiyonunu kullanırken, bir canavar karakter "pençeyle saldır" fonksiyonunu
kullanır.
Polimorfizm bu noktada devreye girer. Karakter sınıfı, karakterlerin "saldır" metotunu tanımlar, ancak her alt sınıf
(kahramanlar, canavarlar vb.) bu metodu kendi ihtiyaçlarına göre uygular. Bu, aynı "saldır" metodu kullanılarak farklı
karakterlerin farklı davranışlar sergilemesini sağlar.
Polimorfizmin bu örneği, aynı işlevselliği paylaşan nesnelerin, farklı nesne türlerine sahip olmalarına rağmen aynı arayüzü
kullanarak farklı davranışlar sergileyebilmesini ifade eder. Bu, yazılım geliştirmede kodun daha esnek ve genişletilebilir
olmasını sağlar, çünkü yeni karakter türleri eklemek veya var olan karakterlerin davranışını değiştirmek, diğer kod
parçalarını etkilemeden yapılabilir.
 */

//3-b)
interface ISkl {
    fun ciz()
}
class Daire : ISkl {
    override fun ciz() {
        println("Daire çiziliyor")
    }
}
class Ucgen : ISkl {
    override fun ciz() {
        println("Üçgen çiziliyor")
    }
}

/*
Polimorfizmin avantajları:
Esneklik: Polimorfizm, farklı nesne türlerini aynı arayüz altında kullanmamıza olanak tanır, bu da kodun daha esnek
ve genişletilebilir olmasını sağlar.
Kod testini kolaylaştırır. Polimorfizm, farklı türdeki nesneleri aynı şekilde test etmeyi mümkün kılar.
Bu, kod testini daha kolay hale getirir.
Kod okunabilirliğini ve anlaşılabilirliğini artırır. Polimorfizm, farklı türdeki nesneleri aynı şekilde işlemeyi mümkün
kılar. Bu, kodu daha okunabilir ve anlaşılabilir hale getirir.
Kod tekrarını azaltır. Polimorfizm, ortak davranışları tek bir yerde tanımlamayı mümkün kılar.
Bu, kodu daha kısa ve daha az tekrarlı hale getirir.
 */

/*
4-a)
Arayüzler (interfaces), yazılım geliştirmede aşağıdaki amaçlarla kullanılır:
Soyutlama: Arayüzler, belirli bir davranışı tanımlar ve bu davranışı uygulamak isteyen sınıflara bir şablondur.
Bu sayede programcılar, bir sınıfın belirli bir davranışı uygulaması gerektiğini anlarlar.
Çoklu Kalıtım: Kotlin gibi bazı dillerde sınıflar yalnızca bir sınıftan kalıtım alabilir, ancak birden fazla arayüzü
uygulayabilirler. Bu, bir sınıfın birden fazla davranışı (arayüzü) bir arada kullanabilmesini sağlar.
Kodun Daha Okunaklı Olması: Arayüzler, programcılara bir sınıfın ne tür davranışları uyguladığını hızlıca gösterir.
Bu, kodun daha okunaklı ve anlaşılır olmasını sağlar.
Kod tekrarını azaltmak: Arayüzler, ortak davranışları tek bir yerde tanımlayarak kodu daha kısa ve daha az tekrarlı
hale getirir.
Kod testini kolaylaştırmak: Arayüzler, farklı türdeki nesneleri aynı şekilde test ederek kod testini daha kolay hale getirir.
 */

interface ISekl {
    fun ciz()
}
class Yamuk : ISekl {
    override fun ciz() {
        println("Yamuk çiziliyor")
    }
}

/*
4-b)
Kotlin'de bir sınıf, virgülle ayrılmış şekilde birden fazla interface'i uygulayabilir.
 */
interface ISekil {
    fun ciz()
}
interface IHareket {
    fun hareketEt()
}
class Yuvarlak : ISekil, IHareket {
    override fun ciz() {
        println("Yuvarlak çiziliyor")
    }
    override fun hareketEt() {
        println("Yuvarlak hareket ediyor")
    }
}

/*
Çoklu arayüz uygulamalarının neden önemli olduğu:
Reusable (Yeniden Kullanılabilir) Kod: Çoklu arayüz uygulamaları, aynı sınıfın farklı amaçlar için kullanılmasını sağlar.
Bu, kodun yeniden kullanılabilirliğini artırır.
Tekrar Kullanılabilir Tasarım Desenleri: Belirli bir tasarım deseni uygulamak için birden fazla arayüz gerekebilir.
İşlevsellik Genişletme: Var olan bir sınıfa yeni davranışlar eklemek istediğinizde, yeni bir arayüzü uygulamak ve
sınıfa yeni metotlar eklemek, mevcut kodu değiştirmeksizin işlevselliği genişletmenizi sağlar.
İyi Tasarım Prensipleri: İyi bir yazılım tasarımı, sınıfların tek sorumluluk ilkesini takip etmelerini önerir.
Birden fazla arayüz kullanarak, her bir arayüz belirli bir sorumluluğu temsil edebilir, bu da daha temiz ve daha okunaklı
kod sağlar.
Sonuç olarak, çoklu arayüz uygulamaları, yazılım geliştirmede kodun daha esnek ve yeniden kullanılabilir olmasını sağlar ve
tasarım desenlerini uygulamak için önemlidir.
 */

//5
open class Hayvan(val ad: String, val tür: String) {
    open fun sesCikar() {
        println("Hayvan ses çıkarıyor")
    }
}
class Kopek(ad: String, tür: String) : Hayvan(ad, tür) {
    override fun sesCikar() {
        println("Hav hav!")
    }
}
class Kedi(ad: String, tür: String) : Hayvan(ad, tür) {
    override fun sesCikar() {
        println("Miyav!")
    }
}

//6
abstract class Sekill {
    abstract fun ciz()
}
interface Renklenebilir {
    fun renklendir(renk: String)
}
class Dikdortgenn : Sekill(), Renklenebilir {
    override fun ciz() {
        println("Dikdörtgen çiziliyor")
    }
    override fun renklendir(renk: String) {
        println("Dikdörtgen ${renk} rengine boyandı.")
    }
}

/*
Bu birleştirme sonucunda, Dikdortgen sınıfı, Sekil soyut sınıfından ciz() metoduna ve Renklendir arayüzünden renklendir()
metoduna erişebilir. Ayrıca, Dikdortgen sınıfı, kendi özelliklerine ve metodlarına da erişebilir.
 */

