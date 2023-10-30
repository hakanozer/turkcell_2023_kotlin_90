package com.works.odev_4

open class Odev4 {
    open fun soru1(){
        for (i in 1..6){
            println((1..49).random())
        }
    }

    open fun soru2(){
        val a = "23456789876543234567890987654567890"
        val b = "99999999999988888888882222222688981"

        val aInt = a.toBigInteger()
        val bInt = b.toBigInteger()

        println("$a + $b = ${aInt+bInt}")
    }



    open fun soru4(){
        val isimListe = listOf<String>("Ahmet","Ali","Veli","Ayşe","Fatma")
        for(i in isimListe){
            println(i)
        }
    }

    open fun soru5(){
        val set = setOf<Char>('a','b','c','d','e','f')
        val charList = listOf<Char>('d','e','f','g','h','i')
        val finalSet = mutableSetOf<Char>()
        finalSet.addAll(set)
        finalSet.addAll(charList)
        finalSet.forEach { println("Son oluşan setin ${finalSet.indexOf(it)}. elemanının değeri $it") }
    }

    open fun soru6(list: List<Int>,sayi: Int): Int {
        return list.count {
            it.equals(sayi)
        }
    }

    open fun soru7(list: List<Int>){
        val ageMap = mutableMapOf<String,Int>("0-18" to 0,"18-25" to 0,"25-60" to 0,"60 ve üzeri" to 0)
        ageMap["0-18"] = list.count { it>=0 && it<18 }
        ageMap["18-25"] = list.count { it>=18 && it<=25 }
        ageMap["25-60"] = list.count { it>25 && it<=60 }
        ageMap["60 ve üzeri"] = list.count { it>60 && it<100 }

        ageMap.forEach { println("${it.key} yaş grubunda ${it.value} kişi bulunmaktadır.") }
    }

    open fun soru8(valueList: List<Int>): Int {
        return valueList.filter { it>0 }.sum()
    }

    open fun soru9(complicatedList: List<Any?>): List<Any?> {
        return complicatedList.filter { it!=null }
    }

    open fun soru10(metinList : List<String>){
        val metinListSorted = metinList.sortedWith(compareBy { it.length })
        val min = metinListSorted[0]
        val max = metinListSorted[metinListSorted.size-1]

        println("""
            En kısa metin "$min" ve ${min.length} harf uzunluğunda.
            En uzun metin "$max" ve ${max.length} harf uzunluğunda.
        """.trimIndent())
    }

    open fun soru11(sayiListe: List<Int>): List<Int> {
        return sayiListe.sorted()
    }

    open fun soru12(set1: Set<Int>, set2: Set<Int>){
        val ortakElemanlar = mutableListOf<Int>()

        for (i in set1){
            for (j in set2){
                if (i == j){
                    ortakElemanlar.add(i)
                }
            }
        }
        print("Ortak Elemanlar: ")
        ortakElemanlar.forEach { print("$it ") }
    }
}