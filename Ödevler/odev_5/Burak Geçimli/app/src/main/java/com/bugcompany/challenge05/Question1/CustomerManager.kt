package com.bugcompany.challenge05.Question1

//Bu sınıf Müşteriler için veritabanındaki CRUD operasyonlarını gerçekleştirir.
class CustomerManager {

    //Bu fonksiyon ile polymorphizm sağlanır.
    /**
     * @author Burak Geçimli
     * @param customer
     */
    fun add(customer: Customer) {
        println("${customer.customerNumber} numaralı müşteri eklendi")
    }
}