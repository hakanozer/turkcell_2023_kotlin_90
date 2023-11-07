package com.example.odev_5.sorubir

class Engineer(name: String,salary:Int,age:Int) : Employee(name,age,salary) {
    override fun calculateSalary(): Int {
        return super.calculateSalary() + 2000
    }

    fun calculateProjectSalary(price:Int): Int {
        return super.calculateSalary() + (price* 0.2).toInt()
    }

}

fun main() {
    val engineer = Engineer("Ahmet", 1000, 25)
    println(engineer.calculateSalary())
    println(engineer.calculateProjectSalary(50000))
}