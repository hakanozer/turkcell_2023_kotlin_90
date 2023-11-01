package com.works.odev4

fun main(args: Array<String>) {
    //1.soru
    val sinif = RandomSayi()
    sinif.rastgeleSayi()

    //2.Soru
    val buyuksayi = BuyukSayi()

    //4.Soru
    val kotlin = KotlinList()

    //5.soru
    val setList = SetList()

    //6.soru
    val sayiTekrar = SayiTekrar()
    val sayiTekrarFun = sayiTekrar.tekrarKontrol(5)

    //7.soru
    val yas= listOf(18,24,30,36,25,34,40,32,35,32,44,50,52,54).sorted()
    val yasGruplama = YasAraligi(yas)
    yasGruplama.yasAraligi()

    //8.Soru
    val listtoplam = ListToplam()


    //9.soru
    val listem = listOf<Any?>(1,2,3,null, "Ali", "Bilmem", null, "")
    val listfiltre = ListFiltre(listem)
    listfiltre.filtreList()

    //10.soru
    val kelimeLen = KelimeMaxMin()


    //11.soru
    val kotlin1 = ListSort()

    //12.soru
    val ortakEleman = OrtakEleman()
    ortakEleman.Set()
}