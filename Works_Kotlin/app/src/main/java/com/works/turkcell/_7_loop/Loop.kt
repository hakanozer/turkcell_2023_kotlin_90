package com.works.turkcell._7_loop

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

    // do - while
    // dönme koşulu sağlanmasa bile en az bir sefer dönen bir döngüdür.
    val status = false
    var ii = 0
    do {
        println("This Line Call")
        ii++
    }while (ii < 5)


    if ( ii == 0 ) {
        println("if line call")
    }else {
        for ( j in 0..ii) {
            println("if line call")
        }
    }

    // break - continue
    // break -> döngüyü durdurmak için kullanılır.
    val name = "Kaan"
    val names = arrayOf("Ali", "Veli", "Asya", "Kaan", "Zehra", "Ayşe")
    for( item in names ) {

        if(item.equals("Veli")){
            continue
        }

        if ( item.equals(name) ) {
            println("Kaan Bulundu")
            break;
        }

        println("For loop.. $item")
    }

    var isBreak = false
    for (i in 0..10) {
        for (j in 0..10) {
            println("j - $j")
            if (j == 5) {
                isBreak = true
                break
            }
        }
        if (isBreak) break
    }

    label@ for (i in 0..10) {
        for (j in 0..10) {
            println("jj - $j")
            if (j == 5) {
                break@label
            }
        }
    }


}