package com.bugcompany.challenge03

import java.io.File


fun main() {

    val fileName = "C:\\Users\\burak\\Desktop\\TurkcellOdevler\\numbers.txt"
    val dumpFilePath = "C:\\Users\\burak\\Desktop\\dump.txt"
    val dumpReversedFilePath = "C:\\Users\\burak\\Desktop\\dump_reverse.txt"
    val dumpReversedWordFilePath = "C:\\Users\\burak\\Desktop\\dump_reverse2.txt"


    val sourceFile = File(dumpFilePath)
    val targetFile = File(dumpReversedFilePath)
    val targetFileWord = File(dumpReversedWordFilePath)


    //Question 1
    val counter = Question1(fileName)
    counter.countNumbers()

    //Question 2
    val randomNumber = Question2()
    randomNumber.createRandomNumber(fileName)

    //Question 3
    val question3 = Question3()
    question3.createOddEvenFile(fileName)

    //Question 4
    val question4 = Question4()
    question4.infoDump(dumpFilePath)

    //Question 5
    val question5 = Question5()
    question5.reverse(sourceFile, targetFile)

    //Question 6
    val question6 = Question6()
    question6.reverse(sourceFile, targetFileWord)

    //Question 7
    val question7 = Question7()
    question7.find(sourceFile)

    //Question 8
    val directoryPath = readlnOrNull()
    val question8 = Question8()

    if (directoryPath != null) {
        val directorySize = question8.calculateSize(File(directoryPath))
        println("The total size of the directory is: ${question8.formatSize(directorySize)}")
    }

    //Question 9 testi kendi classında oluşturulan fun main() de.


}

