package com.bugcompany.challenge05.Question1

//  Bu sınıf Kurumsal Müşteri sınıfını temsil etmektedir.
/**
 * @author Burak Geçimli
 * @param id
 * @param customerNumber
 * @param companyName
 */
class CorporateCustomer(id: Int, customerNumber: String, val companyName: String,
) : Customer(id, customerNumber) {


    override fun info() {
        super.info()
        println("Company Name: $companyName")

    }

}