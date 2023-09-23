package com.works.turkcell._Homeworks_

import kotlinx.coroutines.yield
import java.util.Scanner

fun main(args: Array<String>) {

    println("First practice (triangle rule)")
    try {
        val scanner1 = Scanner(System.`in`)
        println("write your first edge !!")
        val edge1 = scanner1.nextInt()
        println("write your second edge !!")
        val edge2 = scanner1.nextInt()
        println("write your third edge !!")
        val edge3 = scanner1.nextInt()
        val x1 = edge2 - edge3
        val x1Minus = Math.abs(x1)
        val x2 = edge1 - edge2
        val x2Minus = Math.abs(x2)
        val x3 = edge1 - edge3
        val x3Minus = Math.abs(x3)

        if(((x2Minus < edge3) && (edge3 < (edge1 + edge2))) &&
            ((x1Minus < edge1) && (edge1 < (edge2 + edge3))) &&
            ((x3Minus < edge2) && (edge2 < (edge1 + edge3)))){
            println("you can have the the triangle with these three edges $edge1 , $edge2 and $edge3.")
        }else{
            println("you can not have a triangle with these edges.")
        }

    }catch (ex:Exception){
        println("write only numbers , not letters ...")
    }
    println("------------------------------------------------------------")
    println("Second practice (Making menu)")
    try {
        println("1 - F -> C")
        println("2 - C -> F")
        val scanner1 = Scanner(System.`in`)
        val choosenWay = scanner1.next()
        if(choosenWay.equals("1")){
            println("write your fahrenheit value to exchange with celcius")
            val fahr = scanner1.nextDouble()
            val celcius = (fahr -32.0) / 1.8
            println("$fahr F = $celcius C")
        }else if (choosenWay.equals("2")){
            println("write your celcius value to exchange with fahrenheit")
            val celc = scanner1.nextDouble()
            val fahrenheit = celc * 1.8 + 32
            println("$celc C = $fahrenheit F ")

        }else{
            println("write only 1 or 2 do not enter different digit...")
        }

    }catch (ex:Exception){
        println("if you want to see a double value; use comma( , ) not dot( . )")
    }
    println("------------------------------------------------------------")
    println("third practice (compare two number)")
    val scanner1 = Scanner(System.`in`)
    val nb1 = scanner1.nextInt()
    val nb2 = scanner1.nextInt()
    if(nb1<nb2){
        println("$nb1 < $nb2")
    }else if(nb1>nb2){
        println("$nb1 > $nb2")
    }else if(nb1 == nb2){
        println("these numbers equal each other")
    }else{
        println("you are going to compare only numbers")
    }
    println("------------------------------------------------------------")
    println("fourth exercise addition numbers until your values...")
    var number = scanner1.nextInt()
    if(number > 0 ){
        var additionOfnumb = number * (number+1) / 2
        println(additionOfnumb)
    }else{
        println("please write a number which is greater than 0...")
    }
    println("------------------------------------------------------------")
    println("fifth exercise (addition place values)")
    println("write a number which has 3 place value and you will see addition of the places.")
    try {
        val number2 = scanner1.nextInt()
        if ( 99< number2 && number2<1000){
            val additionPlaceValue = number2 / 100 + (number2 / 10) % 10 + number2%10
            println(additionPlaceValue)
        }else{
            println("write a number which has 3 place values...")
        }
    }catch (ex:Exception){
        println("write number not letters..")
    }
    println("------------------------------------------------------------")
    println("sixth exercise (the reverse number)")
    val number3 = scanner1.nextInt()
    if (number3>99 && number3<1000){
        print(number3%10)
        print((number3/10)%10)
        println(number3/100)

    }else{
        println("write only number which has 3 places.")
    }
    println("------------------------------------------------------------")
    println("seventh exercise (the reverse number)")
    println("write that how many times that you want to enter value.")

    val hmtVal = scanner1.nextInt()
    var i = 0
    var arrayOfNumb = ArrayList<Int>()
    println("write your values")
    while(i < hmtVal){

        var numbFuser = scanner1.nextInt()
        arrayOfNumb.add(numbFuser)
        i++
    }
    println(" your values are = $arrayOfNumb")
    var evenVal = ArrayList<Int>()
    var oddVal = ArrayList<Int>()

    println("your maximum value is ${arrayOfNumb.max()}")
    println("your minimum value is ${arrayOfNumb.min()}")
    for (i in arrayOfNumb){
        if(i%2 == 0 ){
            evenVal.add(i)
        }else{
            oddVal.add(i)
        }

    }
    println("your even values are ${evenVal} you have ${evenVal.size} different even values.")
    println("your odd values are${oddVal} you have ${oddVal.size} different odd values.")
    var firstV = 0
    for(i in arrayOfNumb){
        firstV += i
    }
    println("addition of all values that you enter is   $firstV")
    var averageVal = firstV / arrayOfNumb.size
    println("average of the values that you enter is $averageVal")



}
