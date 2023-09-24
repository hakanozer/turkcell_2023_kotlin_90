package com.works.turkcell._10_string

fun main(args: Array<String>) {

    // String Class
    // Karakter Katarı
    var str = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır."

    // Size
    val size = str.length
    println(size)

    println( str.get(0) )

    // Benzerini arama
    val containsStatus = str.contains("etin")
    println(containsStatus)

    // Benzeri index bulma
    val indexOf = str.indexOf("dizgi")
    println(indexOf)

    // Bulduğunu düzenle
    val words = arrayOf("Lorem", "Ipsum", "mıgır", "yazı") // ***
    for ( item in words ) {
        str = str.replace(item, "***")
    }
    println(str)


    val subStr = str.substring(18, 23)
    println(subStr)

    var countCumle = 0
    var strArr = str.split(" ")
    for ( item in strArr ) {
        if (item.contains(".")) {
            countCumle++
        }
        println(item)
    }
    println("Cümle Count : $countCumle")



}