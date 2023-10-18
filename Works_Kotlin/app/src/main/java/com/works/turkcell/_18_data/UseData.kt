package com.works.turkcell._18_data

fun main(args: Array<String>) {

    val arr = mutableListOf<Product>()

    val p1 = Product(100, "Pro-1", 1000, "Pro-1 Detail")
    val p2 = Product(101, "Pro-2", 1001, "Pro-2 Detail")
    val p3 = Product(102, "Pro-3", 1002, "Pro-3 Detail")
    val p4 = Product(103, "Pro-4", 1003, "Pro-4 Detail")
    val p5 = Product(103, "Pro-4", 1003, "Pro-4 Detail")

    println(p3.hashCode())
    println(p4.hashCode())
    println(p5.hashCode())

    if (p4 == p5) {
        println("p4 == p5")
    }else {
        println("p4 != p5")
    }

    arr.add(p1)
    arr.add(p2)
    arr.add(p3)
    arr.add(p4)

    for ( item in arr ) {
        println("${item.pid} - ${item.title}")
        println(item)
    }

}