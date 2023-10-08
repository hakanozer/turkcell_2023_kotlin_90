package com.works.turkcellodevler.Odev_2

/*
2 - Parametre olarak 2 int sayı alan,
bu sayilarin (ilki hariç, 2.si dahil olmak
üzere) toplamlarını döndüren bir method
yazın
 */

fun main(args: Array<String>) {

    sum(7,7)

}
fun sum(num1: Int,num2: Int): Int {
    var sumNums = 0
    if (num1 > num2){
        println("Lütfen önce küçük sayıyı giriniz.")
    }else if (num1 == num2){
        println("Aralıktaki sayıların toplamı: $num2")
    }else{
        for (i in num1 + 1..num2){
            sumNums += i
        }
        println("Aralıktaki sayıların toplamı: $sumNums")
    }

    return sumNums
}