package com.bugcompany.challenge05.Question1

//Bu sınıf Base Class olan Müşteri sınıfını temsil ediyor.
/**
 * @author Burak Geçimli
 * @param id
 * @param customerNumber
 */
open class Customer(val id: Int, val customerNumber: String) {

   open fun info() {
        println("Customer Info")
    }

}