package com.works.odev5._Ödev5_

fun main(args: Array<String>) {

    // Soru 1 :
    println("Soru 1 : Bir sınıfı başka bir sınıftan miras aldığınızda, üst sınıfın özelliklerini ve davranışlarını tekrar yazmadan kullanabilirsiniz.\nBu, kodun daha az tekrarlamayla daha etkili bir şekilde yazılmasını sağlar.")
    println("\n")
    val team = takimlar("Fenerbahçe" , 1907)
    val team2 = takimlar("Galatasaray" , 1905)
    val team3 = takimlar("Beşiktaş" , 1903)

    println("${team.göster()}/n ${team2.göster()}/n ${team3.göster()}")
    println("\n")

    // Soru 2 :
    println("Soru 2 : Bir soyut sınıf, doğrudan örnekleri oluşturulamayan bir sınıftır.\nYani, soyut sınıftan türetilen somut sınıflar oluşturulabilir, ancak soyut sınıfın kendisi bir nesne oluşturulamaz.\nSoyut sınıflar, bir grup somut sınıf arasında paylaşılan davranışları ve özellikleri tanımlamak için kullanılır.")
    println("\n")
    val ulke1 = ulkeler("Türkiye" , "Avrupa ve Asya")
    val ulke2 = ulkeler("İngiltere" , "Avrupa")
    val ulke3 = ulkeler("Azerbaycan"  , "Asya" )
    val ulke4 = ulkeler("Brezilya" , "Güney Amerika")
    println("${ulke1.ulke()}/n ${ulke2.ulke()}/n ${ulke3.ulke()}/n ${ulke4.ulke()}/n")
    println("\n")

    // Soru 3 :
    println("Soru 3 : Bir nesnenin farklı türdeki nesneler gibi davranabilmesini sağlar.Aynı arayüzü veya soyut sınıfı uygulayan farklı sınıfların nesnelerini aynı şekilde ele alabilmenizi sağlar")
    println("\n")
    val yil : araba = mercedesamg(2023)
    arabafiyatogrenme(yil)
    println("\n")

    // Soru 4 :
    println("Soru 4 : Arayüzler, kodun daha soyut ve bağımsız olmasını sağlar. Arayüzleri kullanarak, kodun bir sınıfın iç detaylarına fazla bağımlı olmadan çalışmasını sağlayabiliriz.\nFarklı sınıfların aynı arayüzü uygulayarak aynı metotları farklı şekillerde uygulamasını sağlar.")
    println("\n")
    val insanyas = insanyasi("Türkiye Cumhuriyeti",100)
    insanyas.kisi()
    insanyas.yasi()

    println("")
    println("***************************")
    println("")

    // Soru 5 :
    val hayvan = arrayOf(at("At"),balik("Balık"))
    for (i in hayvan){
        i.yasamayeri()
    }

    println("")
    println("***************************")
    println("")

    // Soru 6 :
    val ogrenci = Okulkulupleri("Naz","Elif","Oğuz","Baran")
    ogrenci.Ogrencikulupleri()
    ogrenci.dans()
    ogrenci.spor()
    ogrenci.muzik()


}