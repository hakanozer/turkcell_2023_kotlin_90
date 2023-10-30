package com.works.odev_4

fun main(args: Array<String>) {
    println("=================SORU 1===================")
    Odev4().soru1()
    println("=================SORU 2===================")
    Odev4().soru2()
    println("=================SORU 3===================")

    Kisi("","","").menu()

    println("=================SORU 4===================")
    Odev4().soru4()
    println("=================SORU 5===================")
    Odev4().soru5()
    println("=================SORU 6===================")

    val tekrarSayisi = Odev4().soru6(listOf(3,4,5,6,7,8,1,2,3,4,5,6,8,9,7,8,9),3)
    println(tekrarSayisi)

    println("=================SORU 7===================")

    val ages = listOf<Int>(1,2,3,5,9,11,14,19,22,24,26,32,45,56,63,76,84)
    Odev4().soru7(ages)

    println("=================SORU 8===================")

    val valueList = listOf<Int>(3,8,46,12,-32,-65,-8,5,16,-9,-26,38)
    val positiveSum = Odev4().soru8(valueList)
    println("Listedeki pozitif sayıların toplamı $positiveSum.")

    println("=================SORU 9===================")

    val karmasikListe = listOf<Any?>(null, 1.3, null, "Ali", 3, false, null, 4.6, 2, 8.3, null, "Veli")
    val karmasikListeWithoutNull = Odev4().soru9(karmasikListe)
    println(karmasikListeWithoutNull)

    println("=================SORU 10===================")

    val metinList = listOf<String>("Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir.","Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır.","Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır.","1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.","Yinelenen bir sayfa içeriğinin okuyucunun dikkatini dağıttığı bilinen bir gerçektir.","Lorem Ipsum pasajlarının birçok çeşitlemesi vardır. Ancak bunların büyük bir çoğunluğu mizah katılarak veya rastgele sözcükler eklenerek değiştirilmişlerdir.")
    Odev4().soru10(metinList)

    println("=================SORU 11===================")

    val sayiListe = arrayListOf<Int>(3,7,8,24,56,45,22,36,85,72,48)
    val siralanmisListe = Odev4().soru11(sayiListe)
    println(siralanmisListe)

    println("=================SORU 12===================")

    val set1 =  setOf<Int>(1,2,3,4,5,6,7,8,9,0)
    val set2 = setOf<Int>(6,7,8,9,10,11,12,13,0)

    Odev4().soru12(set1, set2)
}