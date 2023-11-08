package com.bugcompany.challenge05.Question3

fun main() {
    val product = Product(100, 500)
    val mcDonaldA = McDonaldsMaltepe("McDonalds-Maltepe", 1, 3, 10)
    val mcDonaldB = McDonaldsTaksim("McDonalds-Taksim", 3, 6, 25)


    val mcDonaldList = ArrayList<IMcDonalds>()
    mcDonaldList.add(mcDonaldA)
    mcDonaldList.add(mcDonaldB)

    mcDonaldList.forEach {
        println("${it.location} Şubesinin günlük geliri :${it.calculateIncome(product)}")
        it.info()
    }
}