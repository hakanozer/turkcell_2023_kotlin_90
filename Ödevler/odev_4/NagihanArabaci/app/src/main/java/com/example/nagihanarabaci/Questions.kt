package com.example.nagihanarabaci

import kotlin.random.Random

fun main() {
    questionSeven()




}

fun questionOne(){
    var randomList = List(49){Random.nextInt(1, 49)}
    println(randomList.size)

    var randomSet = listOf<Int>()
    for (i in randomList){
        if(randomSet.size<=5 && randomSet.contains(i)==false){
            randomSet += i
            continue
        }
    }

}

fun questionTwo(){
    val a  = "23456789876543234567890987654567890"
    val b =  "99999999999988888888882222222688981"
    val sum = a.toBigInteger() + b.toBigInteger()
    println(sum)
}

fun questionThree(){
    val readMenu = Menu
    readMenu.showMenu()
}

fun questionFour(){
    val myList = listOf("Ahmet","Mehmet","Ceyhan","Adana","Ayşe")
    for (i in myList){
        println("$i")
    }
}

fun questionFive(){
    val mySet = setOf(1, 2, 3, 4, 5)
    val myList = listOf(3, 4, 5, 6, 7)
    val merge = mySet + myList
    println("Merge: $merge")

}

fun questionSix(){
    var count = 0
    var recurringValue = 5
    val recurringList = listOf(5, 5, 3, 4, 5, 6, 7, 8, 9,7,8,9,2,5,4)
    for (i in recurringList){
        // recurringValue değeri kaç defa tekrar ediyor
        if(i.equals(recurringValue)){
            count++
        }
    }
    println("Count: $count")
}

fun questionSeven(){
    val userCount:Int = 20
    val ageList = List(userCount){Random.nextInt(0, 100)}

    val ageGroups = mutableMapOf<String, ArrayList<Int>>()
    println("$userCount kişi içinde yaş grupları:\n")
    fun addAgeGroup(age: Int){
        when(age){
            in 0..14 -> {
                if(ageGroups.containsKey("0-14")){
                    ageGroups["0-14"]?.add(age)
                }else{
                    ageGroups["0-14"] = arrayListOf(age)
                }
            }
            in 15..24 -> {
                if(ageGroups.containsKey("15-24")){
                    ageGroups["15-24"]?.add(age)
                }else{
                    ageGroups["15-24"] = arrayListOf(age)
                }
            }
            in 25..64 -> {
                if(ageGroups.containsKey("25-64")){
                    ageGroups["25-64"]?.add(age)
                }else{
                    ageGroups["25-64"] = arrayListOf(age)
                }
            }
            in 65..100 -> {
                if(ageGroups.containsKey("65+")){
                    ageGroups["65+"]?.add(age)
                }else{
                    ageGroups["65+"] = arrayListOf(age)
                }
            }
        }
    }

    for (i in ageList){
        addAgeGroup(i)
    }

    for (i in ageGroups){
        println("${i.key} yaş grubunda: ${i.value.size} kişi")
    }

}

fun questionEight(){
    val numbersList = listOf(1,5,-9,36,8,-52,34)
    val positiveNumbers = numbersList.filter { it > 0 }.sum()
    println("Positive numbers: $positiveNumbers")

}

fun questionNine(){
    val anyList = listOf(1,5,"numbers",null,-96,null,0)
    val positiveNumbers = anyList.filterNotNull()
    println("Positive numbers: $positiveNumbers")

}

fun questionTen(){
    val stringList = listOf("Kelimenin","Uzunluklarınıbulan","bir","fonksiyon","yazınız")
    val longestString = stringList.maxByOrNull { it.length }
    val shortestString = stringList.minByOrNull { it.length }
    println("En uzun kelime: $longestString")
    println("En kısa kelime: $shortestString")
}

fun questionEleven(){
    val randomNumberList = List(10){Random.nextInt(1, 100)}
    println(randomNumberList.sorted())
}

fun questionTwelve(){
    val firstSet = setOf(1, 2, 3, 4, 5)
    val secondSet = setOf(3, 4, 5, 6, 7)
    for (i in firstSet){
        if(secondSet.contains(i)){
            println("Ortak eleman: $i")
        }
    }
}