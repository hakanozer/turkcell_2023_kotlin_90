package com.works.turkcell._7_loop_

fun main(args: Array<String>) {

    // çoğul dataların tükelilmesi veya belirli bir sayıda bir işlemin tekrarlanması için kullanılır.
    val arr = arrayOf("İstanbul", "Ankara", "Adana", "Bursa", "Samsun", "İzmir", "Antalya")
    for ( item in arr ) {
        println(item)
        for ( i in 0..item.length - 1 ) {
            if (i == item.length - 1) {
                print("${item.get(i)}")
            }else {
                print("${item.get(i)}-")
            }
        }
        println()
    }
    // İ-s-t-a-n-b-u-l
    val city = "Gaziantep"
    for ( char in city ) {
        println(char)
    }

    // range loop
    for( i in 0..10 step 2 ) {
        println("i - $i")
    }

    // downTo loop
    for( i in 10 downTo 0 step 3 ) {
        println("i - $i")
    }

    // iterator
    for ( item in arr ) {
        println(item)
    }

    val iter = arr.iterator()
    while ( iter.hasNext() ) {
        val item = iter.next()
        println("while $item")
    }

    while ( iter.hasNext() ) {
        val item = iter.next()
        println("while $item")
    }

    var i = 0
    while( i < 10 ) {
        println("while - i - $i")
        i++
    }

}