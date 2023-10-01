package com.works.odev_2

import java.lang.NullPointerException
import java.lang.NumberFormatException
import java.util.InputMismatchException
import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt


fun main(args: Array<String>) {
//    println(isPrime(11))
//    println(rangeSum(3,7))
//    println(oddEvenRemainder(5,4))
//    println(digitSum(123456789))
//    println(bodyMassIndex(110.0,1.85))
//    println(reverseInt(321))
//    println(isPalindrome(4321234))
//    println(arrayMinMax(intArrayOf(9,6,2,7,5,1,3,4,2)))
//    println(arraySearch(intArrayOf(3,4,2,1,5,7), 9))
//    println(findMax(1,7,4,1))
//    println(arrayComparison(intArrayOf(3,6,4,5,2), intArrayOf(1,2,3)))
//    divideZero()
//    valuePrint()
//    println("Divide function 3/0 : ${divide(3, 0)}")
//    average()
//    stringComparison()
//    println(stringToInt())
//    multipler()
//    fourDigit()
//    oddEven()
//    listCreate()
//    isPerfect()
//    squareRoot()
//    isArmstrong()
//    factorial()
//    driverLicense()
//    rangeOneFifty()
//    lysCheck()
//    quiz()
}

// 1-)

fun isPrime(n: Int) : Boolean {
    var result = true
    if (n <= 1){
        result = false
    }
    for (i in 2 until n){
        if (n % i == 0){
            result = false
            break
        }
    }
    return result
}

// 2-)

fun rangeSum(a: Int, b:Int) :Int{
    var total = 0
    if ( a>=b ){
        println("Lütfen ikinci sayıyı birinci sayıdan büyük giriniz.")
    }else{
        for (i in (a+1)..b){
            total += i
        }
    }

    return total
}

// 3-)
fun oddEvenRemainder(n1: Int, n2: Int): Double {
    val result: Double = if (n1 % 2 == 0){
        n1.toDouble()%n2
    }else{
        n1.toDouble()/n2
    }
    return result
}

// 4-)
fun digitSum(a: Long): Int {
    var total = 0
    val temp = a.toString()
    for ( i in temp ){
        total += i.digitToInt()
    }
    return total
}

// 5-)
fun bodyMassIndex(kg: Double, boy: Double): Double {
    return kg / (boy*boy)
}

// 6-)
fun reverseInt(a: Int): Int{
    return a.toString().reversed().toInt()

}

// 7-)
fun isPalindrome(n: Int): Boolean {
    val nReversed = n.toString().reversed().toInt()
    return n == nReversed
}

// 8-)
fun arrayMinMax(arr: IntArray) :Int {
    return arr.min()+arr.max()
}

// 9-)
fun arraySearch(arr: IntArray, n: Int): Boolean{
    arr.forEach {
        if ( it == n ){
            return true
        }
    }
    return false
}

// 10-)
fun findMax(a: Int, b: Int, c: Int, d: Int): Int{
    val arr = intArrayOf(a,b,c,d)
    var maks = 0

    for (i in arr){
        if (i> maks){
            maks = i
        }
    }
    return maks
}

// 11-)
fun arrayComparison(arr1: IntArray, arr2: IntArray) : Int{
    var sayac = 0
    arr1.forEach {
        if(arraySearch(arr2, it)){
            sayac++
        }
    }
    return sayac
}

// 12-)
fun divideZero() {
    try {
        println("Lütfen integer bir değer giriniz: ")
        val a = readLine()?.toInt()
        if (a != null) {
            println(a / 0)
        }
    } catch (ex: NumberFormatException) {
        println("Geçersiz değer girdiniz.")
        divideZero()
    } catch (ex: NullPointerException) {
        println("Geçersiz değer girdiniz.Null")
        divideZero()
    } catch (ex: ArithmeticException) {
        println("Sayı sıfıra bölünemez.")
    }
}

// 13-)
fun valuePrint(){
    val sc = Scanner(System.`in`)
    try {
        println("Lütfen bir tamsayı giriniz: ")
        val a = sc.nextInt()
        println("Girdiğiniz sayı $a")
    }catch (ex: InputMismatchException){
        valuePrint()
    }
}

// 14-)
fun divide(a: Int, b: Int): Any {
    try {
        return a/b
    }catch (ex: ArithmeticException){
        return "Bölme işlemi sıfıra bölünemez."
    }
}

// 15-)
fun average() {
    val sc = Scanner(System.`in`)
    try {
        println("Lütfen ortalama hesaplaması için 1. sayıyı giriniz: ")
        val a = sc.nextInt()
        println("Lütfen ortalama hesaplaması için 2. sayıyı giriniz: ")
        val b = sc.nextInt()
        println("Girdiğiniz sayıların ortalaması: ${(a.toFloat()+b.toFloat())/2}")
    }catch (ex: InputMismatchException){
        println("Lütfen değerleri tamsayı giriniz.")
        average()
    }
}

// 16-)
fun stringComparison(){
    var sc = Scanner(System.`in`)
    try {
        println("1. String ifadeyi giriniz.")
        val a = readLine()
        println("2. String ifadeyi giriniz.")
        val b = readLine()
        if (a?.length != b?.length) println("Karakter sayıları uyuşmuyor.")
    }catch (ex: InputMismatchException){
        println("Lütfen String ifade giriniz")
    }
}

// 17-)
fun stringToInt(): Any{
    val sc = Scanner(System.`in`)
    var result = 0
    println("Lütfen bir tamsayı giriniz: ")
    val a = sc.nextLine()
    try {
        result = a.toInt()
    }catch (ex: Exception){
        stringToInt()
    }
    return result
}

// 18-)
fun multipler(){
    val sc = Scanner(System.`in`)
    try {
        println("Çarpılacak 1. sayıyı giriniz: ")
        val a = sc.nextInt()
        println("Çarpılacak 2. sayıyı giriniz: ")
        val b = sc.nextInt()
        println("Girdiğiniz iki sayının çarpımı: ${a*b}")
    }catch (ex: InputMismatchException){
        println("Lütfen değerleri tamsayı giriniz.")
        multipler()
    }
}

// 19-)
fun fourDigit(){
    try {
        val sc = Scanner(System.`in`)
        println("Lütfen dört basamaklı bir sayı giriniz.")
        val n1 = sc.nextInt()
        if ( n1.toString().length == 4 ){
            if ( n1 % 2 == 0 ){
                println("$n1 sayısının ikiye bölümü: ${n1/2}")
            }else{
                throw ArithmeticException("Sayı ikiye bölünemiyor.")
            }
        }else{
            fourDigit()
        }
    }catch (ex: ArithmeticException){
        println(ex.message)
    }catch (ex: InputMismatchException){
        println("Geçersiz değer girdiniz lütfen tamsayı bir değer giriniz.")
        println("")
    }
}

// 20-)
fun oddEven(){
    val arr = mutableListOf<Int>()
    val sc = Scanner(System.`in`)
    try {
        println("0 ile 20 arasında 5 adet tamsayı giriniz.")
        for (i in 1..5) {
            println("$i. sayı: ")
            val sayi = sc.nextInt()
            if ( sayi>20 || sayi<0){
                throw IndexOutOfBoundsException("Lütfen 0 ile 20 arasında bir değer giriniz.")
            }
            arr.add(sayi)
        }
        val evenArr = arr.filter { it % 2 == 0 }
        val oddArr = arr.filter { it % 2 != 0 }
        val evenCount = arr.count { it % 2 == 0 }
        val oddCount = arr.count { it % 2 != 0 }

        val evenAvg = evenArr.sum()/evenCount
        val oddAvg = oddArr.sum()/oddCount

        println("""
            Girdiğiniz tek sayıların ortalaması: $oddAvg
            Girdiğiniz çift sayıların ortalaması: $evenAvg
        """.trimIndent())

    }catch (ex: InputMismatchException){
        println("Geçersiz değer girdiniz.Lütfen tamsayı değer giriniz.")
        oddEven()
    }catch (ex: IndexOutOfBoundsException){
        println(ex.message)
        oddEven()
    }
}

// 21-)
fun listCreate(){
    val sc = Scanner(System.`in`)
    val liste = mutableListOf<Int>()
    try {
        println("Lütfen oluşturmak istediğiniz listenin boyutunu giriniz")
        var elemanSayisi = sc.nextInt()
        for (i in 1..elemanSayisi){
            println("Lütfen $i. elemanı giriniz: ")
            var eleman = sc.nextInt()
            liste.add(eleman)
        }
        val listeCiftIndex = liste.filter { liste.indexOf(it)%2 == 0 }
        val listeTekIndex = liste.filter { liste.indexOf(it)%2 != 0 }

        println("""
            Girdiğiniz listedeki;
            Çift indexli elemanların toplamı: ${listeCiftIndex.sum()}
            Tek indexli elemanların toplamı: ${listeTekIndex.sum()}
        """.trimIndent())
    }catch (ex: InputMismatchException){
        println("Boyutu veya elemanları geçersiz girdiniz.Lütfen tamsayı değerler giriniz.")
        listCreate()
    }
}

// 22-)
fun isPerfect(){
    val sc = Scanner(System.`in`)
    val posDivider = mutableListOf<Int>()
    try {
        print("Mükemmel sayı olup olmadığını kontrol etmek istediğiniz sayıyı giriniz: ")
        val sayi = sc.nextInt()
        for (i in 1 until sayi){
            if ( sayi%i == 0 ){
                posDivider.add(i)
            }else{
                continue
            }
        }
        if ( sayi == posDivider.sum() ){
            println("$sayi sayısı mükemmel sayıdır.")
        }else{
            println("$sayi sayısı mükemmel sayı değildir.")
        }
    }catch (ex: InputMismatchException){
        println("Geçersiz değer girdiniz lütfen tamsayı değer giriniz.")
        isPerfect()
    }
}

// 23-)
fun squareRoot(){
    val sc = Scanner(System.`in`)
    try {
        print("Karekökünü almak istediğiniz sayıyı girin: ")
        val n = sc.nextInt()
        if ( n<0 ){
            throw ArithmeticException("Sayı negatif olamaz!")
        }else{
            println("$n sayısının karekökü ${sqrt(n.toDouble())}")
        }

    }catch (ex: InputMismatchException){
        println("Lütfen tamsayı değer giriniz.")
        squareRoot()
    }catch (ex: ArithmeticException){
        println(ex.message)
        squareRoot()
    }
}

// 24-)
fun isArmstrong(){
    val sc = Scanner(System.`in`)
    var n1Total = 0.0
    var n2Total = 0.0
    try {
        println("Armstrong sayısı olup olmadığını kontrol etmek istediğiniz 1. sayıyı giriniz: ")
        var n1 = sc.nextInt()
        println("Armstrong sayısı olup olmadığını kontrol etmek istediğiniz 2. sayıyı giriniz: ")
        var n2 = sc.nextInt()

        val n1String = n1.toString()
        val n2String = n2.toString()


        val n1Length = n1.toString().length
        val n2Length = n2.toString().length

        if (n1Length == 3 && n2Length == 3) {
            for (i in n1String) {
                n1Total += i.digitToInt().toDouble().pow(n1Length)
            }
            if (n1 == n1Total.toInt()) {
                println("$n1 sayısı armstrong sayısıdır.")
            } else {
                println("$n1 sayısı armstrong sayısı değildir.")
            }
                for (i in n2String) {
                    n2Total += i.digitToInt().toDouble().pow(n2Length)

                }
            if (n2 == n2Total.toInt()) {
                println("$n2 sayısı armstrong sayısıdır.")
            } else {
                println("$n2 sayısı armstrong sayısı değildir.")
            }
        }else{
            println("Lütfen üç basamaklı bir sayı giriniz!")
            isArmstrong()
        }
    }catch (ex: InputMismatchException){
        println("Lütfen tamsayı bir değer giriniz")
        isArmstrong()
    }
}

// 25-)
fun factorial(){
    val sc = Scanner(System.`in`)
    println("Lütfen pozitif bir tamsayı giriniz: ")
    var faktoriyel = 1
    try {
        var sayi = sc.nextInt()
        if ( sayi >= 0 ){
            for (i in 1..sayi){
                faktoriyel *= i
            }
            println("$sayi sayısının faktoriyeli: $faktoriyel")
        }else{
            throw ArithmeticException("Lütfen sıfırdan büyük bir tamsayı giriniz!")
        }
    }catch (ex: ArithmeticException){
        println(ex.message)
    }catch (ex: InputMismatchException){
        factorial()
    }
}

// 26-)
fun driverLicense(){
    val sc = Scanner(System.`in`)
    val ehliyetYasi = 18
    try {
        println("Lütfen yaşınızı giriniz: ")
        val yas = sc.nextInt()
        if (yas >= 0){
            if (yas < ehliyetYasi){
                println("Maalesef ehliyet alacak yaşta değilsiniz,${ehliyetYasi-yas} yıl sonra ehliyet almaya hak kazanabilirsiniz!")
            }
            else{
                println("Tebrikler ehliyet alma hakkınız var.")
            }
        }

        else{
            throw ArithmeticException("Lütfen pozitif tamsayı giriniz!")
        }

    }catch (ex: InputMismatchException){
        println("Lütfen pozitif tamsayı giriniz!")
    }catch (ex: ArithmeticException){
        println(ex.message)
    }
}

// 27-)
fun rangeOneFifty(){
    val sc = Scanner(System.`in`)
    try {
        print("Lütfen 1 ile 50 arasında bir tamsayı giriniz: ")
        val sayi = sc.nextInt()
        if (sayi>=0 && sayi<=50){
            println("Girdiğiniz tamsayı 1 ile 50 arasında.")
        }else{
            throw InputMismatchException("Lütfen 1 ile 50 arasında tamsayı bir değer giriniz!")
        }
    }catch (ex: InputMismatchException){
        println("Lütfen 1 ile 50 arasında tamsayı bir değer giriniz!")
    }
}

// 28-)
fun lysCheck() {

    try {
        val sc = Scanner(System.`in`)
        print("Lys puanınızı giriniz: ")
        var puan = readlnOrNull()
        val puanInt = puan?.toInt()

        if (puanInt!! > 0 && puanInt < 500) {
            if (puanInt!! in 400..430) {
                println("Mühendislik Fakültesi’ne yerleşebilirsiniz")
            } else {
                println("Üzülme, Vazgeçme ! \uD83D\uDE0A")
            }
        } else {
            throw InputMismatchException("Lütfen 0 ile 500 arasında geçerli bir puan giriniz!")
        }
    }catch (ex: InputMismatchException){
        println(ex.message)
    }catch (ex: NumberFormatException){
        println("Lütfen geçerli bir sayı giriniz!")
    }catch (ex: NullPointerException){
        println("Lütfen geçerli bir sayı giriniz")
    }
}

// 29-)
fun quiz(){
    var sc = Scanner(System.`in`)
    val dogruCevap = 4
    try {
        println("2+2 işleminin sonucu kaçtır?")
        val cevap = sc.nextInt()
        if (cevap == dogruCevap){
            println("Tebrikler! Doğru cevap verdiniz")
        }
        else{
            println("Cevabınız yanlış.Doğru cevap $dogruCevap.")
        }
    }catch (ex: InputMismatchException){
        println("Lütfen geçerli bir cevap giriniz.")
    }
}

