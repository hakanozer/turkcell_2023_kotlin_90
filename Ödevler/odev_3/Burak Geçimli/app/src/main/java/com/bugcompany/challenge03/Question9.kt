package com.bugcompany.challenge03

import java.io.File

class Question9(private val searchKeyword: String) {
    fun search(directoryPath: String) {
        val directory = File(directoryPath)

        //Dosya var mı yok mu kontrol et.
        if (!directory.exists() || !directory.isDirectory) {
            throw IllegalArgumentException("The specified directory is not valid or cannot be found.")
        }

        //Rekürsif olarak kelimeyi arar.
        try {
            for (file in directory.listFiles() ?: arrayOf()) {
                if (file.isFile && file.name.contains(searchKeyword, ignoreCase = true)) {
                    println("File name: ${file.name}")
                    println("File path: ${file.absolutePath}")
                    println("File size: ${formatSize(file.length())}")
                    println()
                }

                if (file.isDirectory) {
                    search(file.path)
                }
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("An error occurred during file operations: ${e.message}")
        }
    }

    //Formatlama İşlemi
    private fun formatSize(size: Long): String {
        val units = arrayOf("B", "KB", "MB", "GB")
        var unitIndex = 0

        var currentSize = size.toDouble()
        while (currentSize >= 1024.0) {
            unitIndex++
            currentSize /= 1024.0
        }
        return String.format("%.2f %s", currentSize, units[unitIndex])
    }
}

fun main(args: Array<String>) {
    print("Enter the keyword to search for: ")
    val searchKeyword = readLine()

    if (searchKeyword.isNullOrBlank()) {
        println("A valid keyword was not provided.")
        return
    }

    val directoryPath = if (args.isNotEmpty()) args[0] else "."
    val fileSearcher = Question9(searchKeyword)

    try {
        fileSearcher.search(directoryPath)
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

