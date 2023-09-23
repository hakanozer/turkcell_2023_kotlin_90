package com.works.turkcell._1_variable

fun main(args: Array<String>) {


    // Değişkenler
    var name = "Ali"
    val surname:String= "Bilmem"
    val number:Int = 30
    val ondalik = 12.5
    var status = true

    var age:Byte = 127
    var area:Short = 32767
    var starCount:Long = 4534534534534534456

    var d1:Float = 23.5f
    var d2 = 23.5;

    var char = '*'

    println( name.length )
    println(surname)


    // Değişkenlerin değerinin daha sonrdan değişmesini istemediğimiz durumlarda
    val const1 = "İstanbul"
    //const1 = "İzmir";

    val a = "a"
    var b = "b"


    // Arrays - Diziler
    // bir değişken içinde birden fazla değer tutmak için kullanılır.
    // unmutable
    var cities = arrayOf("İstanbul", "Ankara", "İzmir", "Adana")
    // index tam sayı olarak 0 ile başlar.
    println(cities[0])

    cities[3] = "Kayseri"
    println(cities[3])

    println(cities.size)

    // cities = arrayOf()
    cities.forEach {
        println(it)
    }

    val index = 2
    if ( cities.size > index && index > -1 ) {
        println( cities.get(index) )
    }

    cities.set(1, "Antalya")
    println( cities[1] )

    val numbers = Array(10, { i -> i * 2 })
    numbers.forEach {
        println("i: $it")
    }

    // String Arr
    val str = "Acıyı seven, arayan ve ona sahip olmak isteyen hiç kimse yoktur. Nedeni basit. Çünkü o acıdır"
    println( str.length )
    str.forEach {
        println(it)
    }
    println( str[0] )

    val str1 = "Yaygın \ninancın tersine"
    val str2 = "Yaygın\t inancın tersine"
    val str3 = "Yaygın\b inancın tersine"

    println(str1)
    println(str2)
    println(str3)

    val str4 = """
        Merhaba 
        Ben     Ali
        Senin adın nedir?
    """.trimIndent()
    println(str4)


}