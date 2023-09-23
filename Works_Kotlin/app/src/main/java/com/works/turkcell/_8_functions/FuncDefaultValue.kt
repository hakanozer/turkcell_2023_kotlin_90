package com.works.turkcell._8_functions

fun main(args: Array<String>) {

    val dbName = dbConnect(2)
    println(dbName)

    call(param2 = 10)
    call("", 20)

    // lambda sample
    val fncLambda : (Int, String) -> Int = { num, data -> data.length + num  }
    charCall(10, "I'm Lambda", fncLambda)
}

fun charCall( s1: Int, s2: String, lambda: (Int, String) -> Int ) {
    val payload = lambda(s1, s2)
    println(payload)
}


fun dbConnect( num : Int = 1 ) : String {
    var fncResponse = ""
    if( num == 1 ) {
        fncResponse = "user.db"
    }else if ( num == 2 ) {
        fncResponse = "data.db"
    }else {
        fncResponse = "empty.db"
    }
    return fncResponse
}

fun call( param1: String = "Kahraman Maraş", param2: Int ) {
    println( "$param1 - $param2" )
}
