package com.works.turkcell.hw2

fun main(args: Array<String>) {
    val max = maxNumber(intArrayOf())
    println("$max")
}
fun maxNumber(array:IntArray):Int{
    var sonuc = 0
    val array = intArrayOf(4)
    try {
        for (i in array.indices){
            println("Lutfen ${i+1}. sayiyi giriniz ")
            array[i] = (readLine()?.toInt() ?:throw NumberFormatException("Lutfen gecerli bir sayi giriniz")) as Int
        }
        println("Dizideki en buyuk sayi ${array.maxOrNull()}")
        sonuc = array.maxOrNull() ?: 0
    }catch (ex:Exception){
        println("Lutfen gecerli bir sayi giriniz")
    }
    return sonuc

}
