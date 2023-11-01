package com.works.turkcellodevler.Odev_4

/*
6. Verilen bir List içinde belirli bir değerin kaç kez tekrarlandığını hesaplayan bir Kotlin işlevi yazın.
 */

fun main(args: Array<String>) {

    val list = listOf(1,2,2,3,4,5,5,5,6)
    val target = 5
    val same = countSame(list,target)

    println("Listedeki $target elemanı $same kez tekrarlanmıştır.")

}

fun countSame(list: List<Int>,target: Int): Int {
    var count = 0
    for (item in list){
        if (item == target){
            count++
        }
    }
    return count
}