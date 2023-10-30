package com.works.odev.Ödev4

/**
 * 6. Verilen bir List içinde belirli bir değerin kaç kez tekrarlandığını hesaplayan bir Kotlin işlevi yazın.
 */
fun main(args: Array<String>) {

    val liste = listOf<Any>(1,"çağdaş",7,7,"çağdaş","çağdaş","çağdaş","çağdaş","çağdaş","çağdaş","çağdaş","çağdaş",1,7,8,8,8,8,)

    val deger = "çağdaş"

    val islev = liste.count {
        it == deger
    }
    println(islev)
}