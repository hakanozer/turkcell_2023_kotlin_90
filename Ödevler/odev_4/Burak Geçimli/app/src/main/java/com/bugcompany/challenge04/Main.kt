package com.bugcompany.challenge04

import com.bugcompany.challenge04.Lists.ages
import com.bugcompany.challenge04.Lists.exampleList
import com.bugcompany.challenge04.Lists.list
import com.bugcompany.challenge04.Lists.list1
import com.bugcompany.challenge04.Lists.list2
import com.bugcompany.challenge04.Lists.listNumber
import com.bugcompany.challenge04.Lists.mixedList
import com.bugcompany.challenge04.Lists.numberList
import com.bugcompany.challenge04.Lists.set
import com.bugcompany.challenge04.Lists.textList
import com.bugcompany.challenge04.Question01.Question1
import com.bugcompany.challenge04.Question02.Question2
import com.bugcompany.challenge04.Question03.PersonOperation
import com.bugcompany.challenge04.Question04.Product
import com.bugcompany.challenge04.Question05.Question5
import com.bugcompany.challenge04.Question06.Question6
import com.bugcompany.challenge04.Question07.Question7
import com.bugcompany.challenge04.Question08.Question8
import com.bugcompany.challenge04.Question09.Question9
import com.bugcompany.challenge04.Question10.Question10
import com.bugcompany.challenge04.Question11.Question11
import com.bugcompany.challenge04.Question12.Question12


fun main() {

    //Question 1
    val question1 = Question1()
    question1.createRandomList()

    //Question 2
    val question2 = Question2()
    question2.sumInteger()

    //Question 3
    val question3 = PersonOperation()
    //  question3.menu()


    //Question 4
    val product1 = Product(1, "Acer Nitro-5", 50000)
    val product2 = Product(2, "Monster Abra", 45000)
    val product3 = Product(3, "Lenovo 5", 68000)

    val productList = ArrayList<Product>()

    productList.add(product1)
    productList.add(product2)
    productList.add(product3)

    Product.printProduct(productList)

    //Question 5
    val question5 = Question5()
    question5.combineCollection(list, set)

    //Question 6
    val question6 = Question6()
    question6.countOccurrences(exampleList, 70)

    //Question 7
    val question7 = Question7()
    question7.groupAge(ages)

    //Question 8
    val question8 = Question8()
    question8.sumList(numberList)

    //Question 9
    val question9 = Question9()
    question9.findNotNull(mixedList)

    //Question 10
    val question10 = Question10()
    question10.findLongestAndShortestText(textList)

    //Question 11
    val question11 = Question11()
    question11.sort(listNumber)

    //Question 12
    val question12 = Question12()
    question12.findCommonValue(list1, list2)


}