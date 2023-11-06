package com.works.kemalcetinkayaodev5

fun main(args: Array<String>) {

    // Soru1
    //Yazılım geliştirmede "inheritance" (miras) nedir ve ne amaçla kullanılır? Bir örnek vererek açıklayınız.
    // Inheritace(miras) ; bir sınıfın özelliklerinin başka bir sınıfta kullanılmasıdır. Subclass  ve superclass olmak üzere 2 kısımda değerlendirebilir.
    //Özellik aktaran class superclass ; özelliği alan class ise subclass olarak nitelendirilir.
    // Özellik aktaran class in başına open anahtar keimesi kullanılır.
    // Fonksiyon içeriklerini tekrar yazabilrisiniz , değiştirebilirsiniz...

    val S1 = Saray(4,25)
    val toplamGelir = S1.kacParaEder(12)
    println(toplamGelir)
    val V1 = Villa(true,12)
    val toplamMaaliyetPencere = V1.kacParaEder(5)
    println(toplamMaaliyetPencere)

    // Soru 2
    // Soyut sınıfların yazılım geliştirmedeki rolünü açıklayınız. Soyut sınıfların nasıl tanımlandığını ve soyut metotlarının nasıl kullanıldığını gösteren bir örnek veriniz.

    // Abstrack anahtar keimesiyle başlar. Aabstrack kullanıldığında bu sınıfa ait nesne olusturulamaz.
    // yapının temel amacı taslak olusturulması olarak nitelendirebilir.
    // Kısmen tanımlanmış sınıflardır. Bu yapıdan kalıtım yoluyla başka sınıfa özellik aktardığımızda taslak sınıf ve fonkstiyonları kullanabilirz.
    // Yani bu classdan kalıtımla özelliğini çağırıdığımızda fonksiyon vs içeriğini biz belirleriz.
    // Abstrack class a baska bir class dan ozellik alınabilir(Super class in başında open olmak zorundadır.

    val DaireninAlani = Alani()
    val hesapDaire =  DaireninAlani.DaireA(12.5)
    println(hesapDaire)

    //Soru 3
    //a. Polimorfizm yazılım geliştirmede ne anlama gelir ve neden önemlidir? Bir örnek ile açıklayınız.
    // Polimorfizm aynı isimle farklı veri turlerının (double,Int) gibi aynı işlemi yapılır ancak elimize gecen veri türü farklı olabilir
    // Aynı işlem adını kullanarak ve aynı işlemi yaparak sonucları istenilen veri tipiyle almamızı sağlar.

    //Static polimorfizm
    //Fonksiyonun aşırı yüklenmesiyle elde edilir. Aynı isim farklı veri sayısı, farklı veri tipi gibi işlemleri tek fonksiyon ismiyle yapılmasıdır.

    fun addition(x : Int, y : Int):Int{
        return (x+y)
    }
    fun addition(x : Double, y : Double):Double{
        return (x+y)
    }
    println(addition(12,23))
    println(addition(12.4,23.5))

    val polymorphism1 = A()
    val polymorphism2 = B()
    polymorphism1.method1()
    polymorphism2.method1()

    // Interface (Arayüz):
    // a. Arayüzler (interface) yazılım geliştirmede hangi amaçlarla kullanılır? Bir interface tanımlayın ve bu interface'i uygulayan bir sınıfı göstererek nasıl çalıştığını açıklayınız.
    // interface ile olusturulan bir sınıfın fonksiyonları, değerleri kalıtım yoluyla özelliğini alan class ın interface de belirtilen özellikleri kullanmak zorundadır.
    // kullanım amacları arasında buyuk firmalarda yapılması gereken işleri belirtmede kullanılır.
    // bir class ın içinde kesin olması gereken ve interface deki tüm özellikleri alması gereken durumlarda kullanırız.
    // kesin kullanılması gerekn bilgi girişlerinde kullanılır. E-mail Şifre , kullanıcı adı Şifre gibi yapılar buna örnektir.

    //b. Birden fazla interface'i aynı sınıf içinde nasıl uygularsınız? Bu çoklu arayüz uygulamalarının neden önemli olduğunu açıklayınız.

    val user1:User = User()
    val IKullaniciGiris : IKullaniciGiris =User() // istenilen özelliği türü biz atayabliriz...
    val IKullaniciBilgileri :IKullaniciBilgileri =User()

    //Inheritance ve Polymorphism:
    //a. "Hayvan" adında bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş farklı hayvan türlerini temsil eden
    // alt sınıflar (örneğin, "Köpek" ve "Kedi") oluşturun. Polimorfizm kullanarak bu hayvanları bir dizi içinde depolayın ve özelliklerine nasıl erişeceğinizi gösterin.

    val gagali = Ordek()
    gagali.tirnakSayisi(2,4)
    gagali.sesCikar()
    val kedi = Kedi()
    kedi.sesCikar()

    //Abstract ve Interface Kullanımı:
    //a. Bir soyut sınıf (abstract class) ve bir arayüz (interface) oluşturun.
    // Bu soyut sınıfı ve arayüzü bir sınıfta nasıl birleştirirsiniz? Bu birleştirme sonucunda hangi özelliklere ve metotlara erişebilirsiniz?

    val absAndInterface = InterfaceAbstract()
    absAndInterface.sayHi("hello Word")
    val forAbs :Addition = InterfaceAbstract()
    println(forAbs.multiply(12,24))

}