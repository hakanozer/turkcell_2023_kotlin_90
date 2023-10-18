package com.works.turkcell._16_abstract

abstract class Customer {

    abstract fun accountNumber() : Int

    fun total () : Int {
        val number = accountNumber()
        var totalVal = 0;
        if (number == 100)
            totalVal = 1000000
        if (number == 200)
            totalVal = 2000000
        return totalVal
    }

    fun name () : String {
        val number = accountNumber()
        var name = "";
        if (number == 100)
            name = "Ali Bilmem"
        if (number == 200)
            name = "Erkan Bilirim"
        return name
    }

}