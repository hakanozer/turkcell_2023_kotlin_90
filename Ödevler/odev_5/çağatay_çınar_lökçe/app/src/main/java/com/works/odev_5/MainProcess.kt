package com.works.odev_5

fun main(args: Array<String>) {
    println("==============Inheritence a şıkkı==============")
    UseInheritenceClass().explaination()
    println("==============Inheritence b şıkkı==============")

    if(Cow().giveBirthSkill){
        println("İnekler doğurabilir.")
    }
    if (Cow().breastFeedingSkill){
        println("İnekler yavrularını sütle besleyebilir.")
    }

    println("==============Abstract Class a şıkkı==============")

    SoyutSinif().explaination()
    val yeniKare = Kare(4.0)
    yeniKare.calculateArea()
    yeniKare.display()

    println("==============Polymorphism a şıkkı==============")
    ExplainPolymorphism().explaination()

    println("==============Polymorphism b şıkkı==============")
    acikla(UseInheritenceClass())
    acikla(SoyutSinif())
    acikla(ExplainPolymorphism())

    println("==============Interface a şıkkı==============")
    ExplainInterface().explaination()

    println("==============Interface b şıkkı==============")
    ExplainInterface().explainationb()

    println("==============Inheritence ve Polymorphism==============")

    val hayvanDizisi = mutableListOf<Hayvan>()
    val yeniKedi = Kedi()
    val yeniKopek = Kopek()
    hayvanDizisi.add(yeniKedi)
    hayvanDizisi.add(yeniKopek)
    hayvanDizisi.forEach { it.sesCikar() }

    println("==============Abstract ve Interface kullanımı==============")

    AbstractAndInterface().callInterface()
    AbstractAndInterface().abstractCall()
}

fun acikla(aciklama: Aciklama) {
    aciklama.explaination()
}