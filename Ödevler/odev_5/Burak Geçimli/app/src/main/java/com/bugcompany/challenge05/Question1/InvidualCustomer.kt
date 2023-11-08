package com.bugcompany.challenge05.Question1

//  Bu sınıf Bireysel Müşteri sınıfını temsil etmektedir.
/**
 * @author Burak Geçimli
 * @param id
 * @param customerNumber
 * @param firstName
 * @param lastName
 */
class InvidualCustomer(id: Int, customerNumber: String, private val firstName: String, private val lastName: String,
) : Customer(id, customerNumber) {

    override fun info() {
        super.info()
        println("First name: $firstName")
        println("Last name: $lastName")
    }
}