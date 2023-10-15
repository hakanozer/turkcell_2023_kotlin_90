package com.works.turkcellodevler.Odev_3

import java.io.File
import kotlin.random.Random

/*
#2. 1. Sorudaki Dosyayı -1000, +1000 Arası 500 Tane Random Sayıyla Dolduran Bir Uygulama Yazın.
 */

fun main(args: Array<String>) {

    val file = File("C:\\Users\\umutc\\Desktop\\num.txt")
    val numOfNums = 500
    val filePrinter = file.bufferedWriter()

    for (i in 1..numOfNums){
        val randomNum = Random.nextInt(-1000,1000)
        filePrinter.write(randomNum.toString())
        filePrinter.newLine()
    }
    filePrinter.close()

    println("Dosyaya -1000 ila 1000 arasında random sayılar eklendi.")

}

