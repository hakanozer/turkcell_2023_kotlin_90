package com.gorkemarslanbogan.myapplication.Odev4
import java.util.*

abstract class UserProcessAbstractClass {
    protected  fun EkranaYazdir(text: String) {
        println(text)
    }
    protected fun getUserInput(message: String, inputType: String): Any {
        EkranaYazdir(message)
        val userInput = readLine() ?: ""
        return when (inputType) {
            "double" -> {
                val doubleValue = try {
                    userInput.toDouble()
                } catch (e: NumberFormatException) {
                    EkranaYazdir("Geçersiz giriş. Lütfen bir sayı girin.")
                    null
                }

                doubleValue ?: userInput
            }
            "int" -> {
                val intValue = try {
                    userInput.toInt()
                } catch (e: NumberFormatException) {
                    EkranaYazdir("Geçersiz giriş. Lütfen bir tam sayı girin.")
                    null
                }

                intValue ?: userInput
            }
            "boolean" -> {
                val lowerCaseInput = userInput.toLowerCase(Locale.ROOT)
                if (lowerCaseInput == "true" || lowerCaseInput == "false") {
                    lowerCaseInput.toBoolean()
                } else {
                    EkranaYazdir("Geçersiz giriş. Lütfen 'true' veya 'false' girin.")
                    userInput
                }
            }
            else -> userInput
        }
    }
}