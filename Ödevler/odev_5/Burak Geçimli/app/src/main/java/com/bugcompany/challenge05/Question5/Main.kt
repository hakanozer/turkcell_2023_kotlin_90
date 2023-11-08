package com.bugcompany.challenge05.Question5

fun main() {
    val cat = Cat("Tekir", 2)
    val dog = Dog("Karabaş", 5)

    val animalList = ArrayList<Animal>()
    animalList.add(cat)
    animalList.add(dog)

    animalList.forEach { animal ->
        animal.info()
    }
}