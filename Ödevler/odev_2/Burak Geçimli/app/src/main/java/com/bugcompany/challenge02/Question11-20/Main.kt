package com.bugcompany.challenge02.`Question11-20`

fun main(args: Array<String>) {


    println(findCommonValue(arrayOf(2, 4, 6, 8, 10), arrayOf(1, 6, 7)))
    println(controlDivideZero(10, 0))
    calculatorAverage()
    compareCharacterCount()
    textToNumber()
    findMultiplication()
    calculatorEvenNumber()
    findNumber()
    printNumber()
    println(divideZero(10, 0))


}

//Question 11
fun findCommonValue(firstArray: Array<Int>, secondArray: Array<Int>): Int {
    var counter = 0
    val firstSize = firstArray.size
    val secondSize = secondArray.size

    for (i in 0 until firstSize) {
        val firstElement = firstArray[i]
        for (j in 0 until minOf(firstSize, secondSize)) {
            val secondElement = secondArray[j]
            if (firstElement == secondElement) {
                counter++
                break
            }
        }
    }
    return counter
}

//Question 12
fun controlDivideZero(number1: Int, number2: Int): Int {
    try {
        return number1 / number2
    } catch (e: ArithmeticException) {
        println("Sıfıra bölme hatası!")
        return 0
    }
}

//Question 13
fun printNumber() {
    var number: Int? = null
    try {
        print("Enter a number: ")
        val enteredValue = readLine() ?: return
        number = enteredValue.toIntOrNull()
    } catch (e: NumberFormatException) {
        println("Invalid number entered.")
    } finally {
        if (number == null) {
            println("Invalid number")
        } else {
            println("Entered number: $number")
        }
    }
}

//Question 14
fun divideZero(dividend: Int, divisor: Int): Int {
    try {
        return dividend / divisor
    } catch (e: ArithmeticException) {
        return -1
    }
}

//Question 15
fun calculatorAverage() {
    try {
        println("Enter first number")
        val number1 = readLine()?.toInt() ?: 0
        println("Enter second number")
        val number2 = readLine()?.toInt() ?: 0

        val average = (number1 + number2.toDouble()) / 2
        println("Average: $average")
    } catch (e: NumberFormatException) {
        println("Please enter Integer numbers.")
        calculatorAverage()
    }
}

//Question 16
fun compareCharacterCount() {
    try {
        println("Enter first string")
        val count1 = readlnOrNull()?.length ?: 0

        println("Enter second string")
        val count2 = readlnOrNull()?.length ?: 0

        if (count1 == count2) {
            println("Character counts are equal")
        } else {
            println("Character counts do not match")
        }
    } catch (e: Exception) {

        println("An occured fail: ${e.message}")
    }
}

//Question 17
fun textToNumber() {
    try {
        println("Enter a text data")
        val text = readLine()
        if (text.isNullOrEmpty()) {
            println("Empty value")
        } else {
            val number = text.toInt()
            println("Converted integer: $number")
        }
    } catch (e: NumberFormatException) {
        println("Please enter valid number.")
    }
}

//Question 18
fun findMultiplication() {
    try {
        println("Enter first data")
        val number1 = readLine()

        println("Enter second data")
        val number2 = readLine()

        if (number1.isNullOrEmpty() || number2.isNullOrEmpty()) {
            println("Empty Value.")
        } else {
            val multiplication = number1.toInt() * number2.toInt()
            println("Çarpım: $multiplication")
        }
    } catch (e: NumberFormatException) {
        println("Lütfen geçerli tam sayılar giriniz.")
    }
}

//Question 19
fun calculatorEvenNumber() {
    try {
        println("Enter a four-digit number")
        val number = readLine()?.toInt()

        if (number in 1000..9999) {
            val remainder = number?.rem(2)

            if (remainder == 0) {
                println("The number is divisible by 2")
            } else {
                println("The number is not divisible by 2")
            }
        } else {
            println("Please enter a four-digit number.")
        }
    } catch (e: NumberFormatException) {
        println("Please enter a valid integer.")
    }
}

//Question 20
fun findNumber() {
    val numbers = mutableListOf<Int>()
    try {
        for (i in 1..5) {
            println("Enter number")
            val number = readLine()
            if (number != null) {
                numbers.add(number.toInt())
            } else {
                println("Please valid number.")
                return
            }
        }

    } catch (e: Exception) {

    }
    val oddNumbers = numbers.filter { it % 2 != 0 }
    val evenNumbers = numbers.filter { it % 2 == 0 }

    println("You have chosen ${oddNumbers.size} odd numbers and their average is ${oddNumbers.average()}")
    println("You have chosen ${evenNumbers.size} even numbers and their average is ${evenNumbers.average()}")

}






















