package com.works.turkcellodevler.Odev_4

/*
4. Bir Kotlin List oluşturun ve bu listede bulunan elemanları ekrana yazdırmak için bir döngü
kullanarak her elemanı dolaşan bir program yazın.
 */

fun main(args: Array<String>) {

    val list = listOf("Mauro","Emanuel","Icardi","Rivero")

    print("Listenin elamanları: ")
    for (item in list){
        print("$item\t")
    }
}