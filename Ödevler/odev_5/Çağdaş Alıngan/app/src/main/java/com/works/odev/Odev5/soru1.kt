package com.works.odev.Odev5

/**
 * a.Yazılım geliştirmede "inheritance" (miras) nedir ve ne amaçla kullanılır? Bir örnek vererek açıklayınız.
 *
 * b.Kotlin programlama dilinde bir üst sınıf (base class) oluşturun ve bu sınıftan
 * türetilmiş bir alt sınıf (derived class) tanımlayın. Alt sınıfın üst sınıftan miras
 * aldığı özellikleri ve metotları kullanarak bir örnek oluşturun.
 */

fun main(args: Array<String>) {
    /*
    inheritance bir sınıfın özelliklerini başka bir sınıfa aktarmak amacıylaa kullanılan bir yazılım kavramıdır
    inheritance yazılım geliştirme sürecinde kod tekrarını önleyerek zamandan tasarruf etmemize olanak sağlar

    örnek olarak hayvan sınıfımız var bu sınıfa bağlı memeliler sınıfımız olsun
    memeliler sınıfı hayvanlar sınıfından özellik alır
    memeliler sınıfına bağlı bir sınıf olan inek hem hayvanlardan özellik alabilir hem de memelilerden ayrıca
    kendine özelliklerini de kendi sınıfı içinde tutabilir
     */


    val otomobil = Otomobil("Audi","Rs7",2017,"Elektrikli")
    otomobil.ozellikleri()
    otomobil.kullan()
}