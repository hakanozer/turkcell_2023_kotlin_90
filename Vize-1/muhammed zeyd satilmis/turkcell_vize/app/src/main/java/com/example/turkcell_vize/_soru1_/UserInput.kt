package com.example.turkcell_vize._soru1_

class UserInput : InputSumOrReverse, Input1toN{

    override fun getInput(inp: String) {
        when (inp.length) {
            4 -> {
                val i = inp.map { it.digitToInt() }
                val total = i.sum().toString()
                println(total)
            }
            5 -> {
                val i = inp.map { it.digitToInt() }.reversed()
                val reversedInp = i.joinToString("")
                println(reversedInp)
            }
            else -> {
                println("4 veya 5 basamaklı sayı giriniz.")
            }
        }

    }

    override fun faktoriyelHesap(inp: Int) {
        val isPositive = inp >= 1

        if (isPositive) {
            var faktoriyel = 1.0
            var sonuc = 0.0

            for (i in 1..inp) {
                faktoriyel *= i
                sonuc += 1.0 / faktoriyel
            }

            println("Faktoriyel hesap sonucu: $sonuc")
        }else{
            println("0 dan büyük sayı giriniz")
        }
    }
}