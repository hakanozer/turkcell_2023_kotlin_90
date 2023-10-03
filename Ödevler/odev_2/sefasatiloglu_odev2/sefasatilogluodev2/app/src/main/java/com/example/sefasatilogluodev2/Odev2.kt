package com.example.sefasatilogluodev2

import java.util.Scanner

fun main() {

   /* 1 - Parametre olarak aldığı sayıyı
asal mı diye kontrol edip,
sayı asal ise true, değilse false döndüren
isPrime methodunu yazın*/
    //1.Soru
    val girdi = Scanner(System.`in`)
    println("*************1.SORU***************")
    println("Lutfen sayi giriniz:")
    val alinanSayi = girdi.nextInt()

    if (isPrime(alinanSayi)) {
        println("$alinanSayi bir asal sayidir.")
    }else {
        println("$alinanSayi bir asal degildir.")
    }


    /*2 - Parametre olarak 2 int sayı alan,
    bu sayilarin (ilki hariç, 2.si dahil olmak
    üzere) toplamlarını döndüren bir method
    yazın*/
    println("****************2.SORU******************")

    println("1.Sayiyi Giriniz:")
    val num1 = girdi.nextInt()
    println("2.Sayiyi Giriniz:")
    val num2 = girdi.nextInt()
    val toplam = toplamHesapla(num1,num2)
    println("Toplam: $toplam")

    /*
    3 - Parametre olarak 2 int sayi alan (a,b),
        ilk sayi tek ise a/b'yi,
        ilk sayi çift ise a%b'yi double olarak
        döndüren bir method yazın
        */
    println("************3.SORU************************")

    println("a sayisini giriniz:")
    val aNum = girdi.nextInt()
    println("b sayisini giriniz:")
    val bNum = girdi.nextInt()
    val ciftTek = ciftTekHesapla(aNum,bNum)
    println("$aNum ve $bNum : $ciftTek")

    println("************4.SORU************************")
    /*
    4 - parametre olarak verilen long sayisinin
        rakamlarinin toplamını döndüren methodu
        yazin
         */
    val rakamTopla = rakamlariTopla(66)
    println(rakamTopla)
    println("************5.SORU*************************")
    /*
    5 - parametre olarak verilen kg ve boy (double)
        değerlerinden BMI'yi hesaplayip double
        olarak döndüren methodu yazın
     */

    val bMI = boykitleIndex(109.0,1.90)
    println("BMI: $bMI")
    println("************6.SORU*************************")
    /*
     6 - parametre olarak verilen int sayinin
     tersten yazilmiş halini int olarak döndüren
     bir method yazin
     */
    val terstenYazdirma = reverSed(16)
    println(terstenYazdirma)
    println("************7.SORU*************************")
    /*
    7 - parametre olarak verilen int sayinin
    palindrome olup olmadığını test eden
    sonucu boolean olarak döndüren  bir method
    yazın
     */
    val polindrome = palindromHesaplama(1441)
    println("Polindrome Sayi Mi ? $polindrome")
    println("************8.SORU*************************")
    /*
    8 - parametre olarak verilen int[] deki
    en büyük ve en küçük sayının toplamını
    int olarak döndüren method yazın
     */
    val array = arrayOf(35,48,102,99,155,12,303,650,5,15,20)
    val minMaxBulma = minMaxHesapla(array)
    println(minMaxBulma)
    println("************9.SORU*************************")
    /*
    9 - parametre olarak bir int[]ve bir sayi
    alan, eğer array sayiyi içeriyorsa true,
    içermiyorsa false döndüren bir method yazin
     */

    val array2 = arrayOf(50,100,250,300,500,750)
    val arrayNum = arraySayiBulma(array2,50)
    val arrayNum2 = arraySayiBulma(array2,20)
    println(array2.contentToString())
    println("Listenin içinde bu sayi var mı (Sayi:50) ?$arrayNum")
    println("Listenin içinde bu sayi var mı ?(Sayi:20)$arrayNum2")
    println("************10.SORU*************************")
    /*
    10 - kullanıcıdan 4 tane int değer alan,
    ve en büyük olan değeri geri döndüren bir
    method yazın
     */
    println("1.Sayiyi Giriniz:")
    val s1 = girdi.nextInt()
    println("2.Sayiyi Giriniz:")
    val s2 = girdi.nextInt()
    println("3.Sayiyi Giriniz:")
    val s3 = girdi.nextInt()
    println("4.Sayiyi Giriniz:")
    val s4 = girdi.nextInt()
    val enBuyuk = maxsayiyiBulma(s1,s2,s3,s4)
    println(enBuyuk)
    println("************11.SORU*************************")
    /*
    11 - kullanıcıdan iki int[] değer alan
    bu arraylerdeki ortak elemanların
    sayısını döndüren bir method yazın
    */
    val array3 = arrayOf(1,5,7,3,4,9,25,12,55,78,45,99,33,2,61,27)
    val array4 = arrayOf(2,6,7,8,5,12,23,11,54,68,1,45,27,99,102)
    comparingArray(array3,array4)

}
//1.Soru
fun isPrime(n:Int):Boolean{
    if (n <= 1) {
        return false
    }
    for (i in 2 until n) {
        if (n % i == 0) {
            println(i)
            return true
        }
    }

    return true



}

//2.Soru

fun toplamHesapla(num1:Int,num2:Int):Int {
    var sum = 0
    for (i in num1+1..num2) {
        sum+=i
    }
    return sum


}
//3.Soru

fun ciftTekHesapla(a:Int,b:Int):Double {
    if (a % 2 == 0) {
        return a%b.toDouble()
    }else {
        return a/b.toDouble()
    }

}
//4.Soru
fun rakamlariTopla(long:Int):Int {
    var sum = 0
    for (i in long.toString()) {
        sum+=i.toString().toInt()
    }
    return sum
}
//5.Soru
fun boykitleIndex(kg:Double,boy:Double):Double {
    // cm'den metreye ceviriyoruz.
    val boyDonusum = boy / 100

    return kg / (boy*boy)
}
//6.Soru
fun reverSed(terstenYazdirma:Int):Int {

    return  terstenYazdirma.toString().reversed().toInt()

}
//7.Soru
fun  palindromHesaplama(test:Int):Boolean {
    val sayi = test.toString()
    return sayi == sayi.reversed()


}
//8.Soru
fun minMaxHesapla(array:Array<Int>): Int {
    var enBuyuk = array[0]
    var enKucuk = array[0]
    for (i in 1 until array.size) {
        if (array[i] < enKucuk)
            enKucuk = array[i]

        if (array[i]>enBuyuk) {
            enBuyuk = array[i]


        }

    }
    return enBuyuk + enKucuk

}
//9.Soru
fun arraySayiBulma(array: Array<Int>,anyNumber:Int):Boolean {
    for (i in array) {
        if (i == anyNumber){
            return true
        }
    }
    return false

}
//10.Soru
fun maxsayiyiBulma(s1:Int,s2:Int,s3:Int,s4:Int):Int {
    var enBuyuk = 0
    if (enBuyuk<s1) {
        enBuyuk = s1
        if (enBuyuk <s2)
            enBuyuk = s2
        if (enBuyuk < s3)
            enBuyuk = s3
        if (enBuyuk < s4)
            enBuyuk = s4
    }
    return enBuyuk

}
//11.Soru
fun comparingArray(array:Array<Int>,array2:Array<Int>)  {
    for (i in array) {
        for (j in array2) {
            if (i == j) {
                println("Ortak Elemanlar: $i")

            }
        }

    }


}