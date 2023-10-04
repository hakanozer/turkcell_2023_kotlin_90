package com.works.turkcell.hw2

fun main(args: Array<String>) {

    val prime = isPrime(7)
    println("$prime")

}
fun isPrime(sayi: Int): Boolean {
    var response = true
    if (sayi >= 2){
        for (i in 2 until sayi){
            if (sayi % i == 0){
                response = false
                break
            }
        }
    }else{
        response = false
    }
    return response
}


