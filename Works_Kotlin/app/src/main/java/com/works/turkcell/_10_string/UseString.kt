package com.works.turkcell._10_string

import androidx.core.net.toUri

fun main(args: Array<String>) {

    // String Class
    // Karakter Katarı
    var str = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır."
    var str1 = "Kotlin android " +
            "programlama çok eğlenceli."
    var str2 = """Android kotlin 
       |programlama çok iyi ve 
       |katliteli.""".trimMargin()
    var email = "  ali@mail.com   "

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

    println(str1)
    println(str2)
    // if (email.trim().equals("Ali@mail.com", true)) {
    if (email.trim().lowercase().equals("Ali@MAil.com".lowercase() )) {
       println("email koşulu sağlanıyor!")
    }else {
        println("email koşulu hatalı!")
    }


    // Regex
    var email1 = "ali@mail.net"
    val emailRegex = "^((?!.*?\\.\\.)[A-Za-z0-9\\.\\!\\#\\\$\\%\\&\\'*\\+\\-\\/\\=\\?\\^_`\\{\\|\\}\\~]+@[A-Za-z0-9]+[A-Za-z0-9\\-\\.]+\\.[A-Za-z0-9\\-\\.]+[A-Za-z0-9]+)\$"
    val emailStatus = email1.matches(emailRegex.toRegex())
    println(emailStatus)

    str = str.uppercase()
    println(str)
    str = str.lowercase()
    println(str)

    //str = str.reversed()
    //println(str)

    // uri
    //val strUrl = "https://google.com.tr/"
    //val uri = strUrl.toUri()

    val filter = str.filter { it === 'e' }
    println(filter)

    str = str.slice(10..20 step 2)
    println(  str )
}