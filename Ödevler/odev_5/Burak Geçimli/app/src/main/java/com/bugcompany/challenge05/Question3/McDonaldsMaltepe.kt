package com.bugcompany.challenge05.Question3

class McDonaldsMaltepe(
    override val location: String,
    override val superVisorCount: Int,
    override val fridgeCount: Int,
    override val employeeCount: Int
) : IMcDonalds {

    /**
     * @author Burak Geçimli
     * @param product
     * @return sum:Int
     */
    override fun calculateIncome(product: Product): Int {
        var sum = 0
        sum += (product.productPrice * product.productCount + 3000)
        return sum
    }

    override fun info() {
        println("Bölge:$location, Müdür Sayısı:$superVisorCount Dolap Sayısı:$fridgeCount İşçi Sayısı:$employeeCount")
    }

}