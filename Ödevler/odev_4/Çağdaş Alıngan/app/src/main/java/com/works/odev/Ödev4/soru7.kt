package com.works.odev.Ödev4

/**
 * 7. İçinde çeşitli yaşları bulunduran bir List oluşturun. Bu yaşları gruplayarak yaş gruplarını
 * içeren bir Map oluşturun. Örneğin, "18-24" yaş aralığındaki kişileri bir grup olarak tutun.
 */
fun main(args: Array<String>) {

    val yas = listOf<Int>(1,7,8,3,5,77,14,15,17,23,26,27,74,45,3,25,55,59,62,24,35,36,31,27,29,19,20,11,13,17,16,15,9,10,7,11,55,)

    val grupla = yas.groupBy {
       when(it){
           in 1..17 -> "Çocuk"
           in 18..35 -> "Genç"
           else -> "Yaşlı"
       }
    }
    println("GRUPLAR")
    grupla.forEach{ grup,yaslar ->
        println("$grup ,$yaslar")
    }
}