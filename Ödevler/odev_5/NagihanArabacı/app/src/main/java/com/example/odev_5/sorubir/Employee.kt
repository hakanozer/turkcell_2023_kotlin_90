package com.example.odev_5.sorubir

open class Employee(var name: String, var age: Int? = null, var salary: Int) {
    /// Inheritance
    /// Üst sınıf ve alt sınıf arasında bir ilişki kurulur.
    /// Alt sınıf üst sınıfın özelliklerini ve metodlarını kullanabilir ve yeni metotlar ekleyebilir.
    /// Alt sınıf üst sınıfın metodlarını override edebilir.

    init {
        println("Name: $name, Age: $age, Salary: $salary")
    }
    open fun calculateSalary(): Int {
        return salary * 12
    }




}