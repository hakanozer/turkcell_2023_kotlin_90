package com.works.myapplicationsec.work

import java.util.Scanner
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    //1.Soru Asal mı?
    val asalSayi = 83
    val asalMi = isPrime(asalSayi)
    if(asalMi) {
        println("Evet $asalSayi sayısı bir asal sayıdır")
    }else {
        println("Hayır $asalSayi sayısı bir asal sayı değildir!")
    }

    //2.soru
    try{
        val scanner = Scanner(System.`in`)
        print("Lütfen alt sınırı giriniz : ")
        val num1 = scanner.nextInt()
        print("Lütfen üst giriniz : ")
        val num2 = scanner.nextInt()
        val total = sum(num1,num2)
        println("$num1(hariç) $num2(dahil) aralığındaki sayıların toplamı : $total")
    }catch (ex: Exception) {
        println("Lütfen geçerli sayı giriniz")
    }


    //3.Soru
    try{
        val scan = Scanner(System.`in`)
        print("Lütfen ilk sayıyı giriniz : ")
        val firstnum = scan.nextInt()
        print("Lütfen ikinci sayıyı giriniz : ")
        val secondnum = scan.nextInt()
        val sm = evenOrOdd(firstnum,secondnum)
        if (sm != null ) {
            println("Sonuç: $sm")
        }else {
            println("Hatalı giriş! Sonuç bulunamadı")
        }
    }catch(ex: Exception){
        println("Hata!!")
    }


    //4.Soru
    try {
        val scan1 = Scanner(System.`in`)
        println("Lütfen sayı giriniz")
        val numa = scan1.nextLong()
        val lng = lng(numa)
        println(lng)
    }catch (ex: Exception) {
        println("Hata!")
    }



    //5.Soru
    try{
        val scan2 = Scanner(System.`in`)
        print("Lütfen kilonuzu kilogram cinsinden giriniz : ")
        val kilo = scan2.nextDouble()
        print("Lütfen boyunuzu cm cinsinden giriniz : ")
        val boy = scan2.nextDouble()
        val resBmi = bmi(kilo,boy)
        println(resBmi)
    }catch(ex: Exception) {
        println("Geçersiz Giriş!")
    }


    //6.soru
    try{
        val scan3 = Scanner(System.`in`)
        println("Lütfen bir sayı giriniz")
        val sayi = scan3.nextInt()
        val ters = tersYazma(sayi)
        println(ters)
    }catch(ex: Exception) {
        println("Hata!!")
    }



    //7.Soru
    try{
        val scan4 = Scanner(System.`in`)
        println("Lütfen polindrome kontrolü için sayı giriniz")
        val polind = scan4.nextInt()
        val polindrom = polindrome(polind)
        if(polindrom) {
            println("Evet $polind polindromedur")
        }else {
            println("Hayır $polind polindrome değildir!")
        }

    }catch(ex: Exception) {
        println("Hata!!")
    }


    //8.Soru en küçük en büyük toplam
    val liste = mutableListOf<Int>(1,8,15,19)
    val maxMin = minSumMax(liste)
    println("Liste max + min = $maxMin")

    //9.Soru dizi sayıyı içeriyor mu
    val arr = intArrayOf(12,12,3,5,7,8)
    val number3 = 5
    val contain = arrSayi(arr,number3)
    if(contain) {
        println("Evet sayı içeriyor")
    }else {
        println("Hayır sayı içermiyor")
    }

    //10. Soru girilen sayılardan büyük olanı bulma
    try{
        val scan5 = Scanner(System.`in`)
        print("Lütfen 1.sayıyı giriniz")
        val nm1 = scan5.nextInt()
        print("Lütfen 2.sayıyı giriniz")
        val nm2 = scan5.nextInt()
        print("Lütfen 3.sayıyı giriniz")
        val nm3 = scan5.nextInt()
        print("Lütfen 4.sayıyı giriniz")
        val nm4 = scan5.nextInt()
        val maxDeger = enBuyukSayi(nm1,nm2,nm3,nm4)
        println("Girdiğiniz sayılar içerisinde en büyük sayı: $maxDeger")
    }catch(ex: Exception) {
        println("Hata!!")
    }


    //11.Soru
    val dizi1 = intArrayOf(1,3,5,6,7)
    val dizi2 = intArrayOf(1,7,8,3,5)
    val ortakEleman = arrOrtak(dizi1,dizi2)
    println("Dizideki ortak elemanlar: $ortakEleman")
    println("Ortak eleman sayısı: ${ortakEleman.size}")

    //12.Soru
    try{
        val scan6 = Scanner(System.`in`)
        println("Lütfen sayı giriniz")
        val firstNum = scan6.nextInt()
        println("Lütfen sayı giriniz")
        val secondNum = scan6.nextInt()
        val sonuc = sifiraBolme(firstNum,secondNum)
    }catch(ex: Exception) {
        println("Hata!!")
    }



    //13.Soru
    val input = sayiMi()
    if(input != null) {
        println("Girilen $input  bir sayıdır")
    }else {
        println("Girilen $input bir sayı değildir")
    }


    //14.Soru
    try{
        val scan7 = Scanner(System.`in`)
        println("Lütfen ilk sayiyi giriniz")
        val a1 = scan7.nextDouble()
        println("Lütfen ikinci sayıyı giriniz")
        val a2 = scan7.nextDouble()
        val sonucBolme = bolen(a1,a2)
        if(sonucBolme != null) {
            println("Bölme sonucu: $sonucBolme")
        }

    }catch(ex: Exception) {
        println("Hata!!")
    }



    //15.Soru
    calAvr()

    //16.Soru
    strMatch()

    //17.soru
    textToInt()

    //18.soru
    carpma()

    //19.Soru
    ikiyeBolme()

    //20.Soru
    rangeOddOrEven()

    //21.Soru
    indexTopla()

    //22.Soru Mükemmel sayı mı ?
    mukemmelSayi()

    //23.soru
    calsqrt()


    //24.Soru Armstrong sayı mı?
    armstrong()



    //25.soru
    try {
        println("Pozitif bir sayı giriniz")
        val giris = readLine()?.toInt()
        if(giris != null && giris >= 0) {
            val faktoriyel = faktoriyel(giris)
            println(faktoriyel)
        }else {
            println("Geçersiz sayı!")
        }
    }catch(ex: Exception){
        println("Hata! Pozitif sayı giriniz")
    }

    //26.Soru
    ehliyetYas()

    //27.Soru
    kacinciSoru()

    //28.Soru
    lysPuani()


    //29.Soru
    quiz()

}


//1.Soru Asal mı?
fun isPrime(asal: Int): Boolean {
    if(asal <= 1) {
        throw Exception("Asal sayılar 1 den küçük olamaz!")
    }
    if(asal == 2) {
        return true
    }
    val bolen = (asal/2) +1
    for(i in 3 until bolen) {
        if(asal % i == 0 ) {
            return false
        }
    }
    return true
}



//2.Soru
fun sum(number1: Int, number2: Int): Int {
    var total = 0
    for(i in number1 +1..number2) {
        total +=i
    }
    return total
}

//3.Soru
fun evenOrOdd (a: Int, b: Int):Double? {
    if (a == 0 || b == 0) {
        println("a veya b sıfır olamaz!")
        return null
    } else{
        var result = if(a % 2 == 1) {
            a.toDouble() % b.toDouble()
        }else{
            a.toDouble() / b.toDouble()
        }
        return result
    }

}

//4.Soru
fun lng(a:Long):Long {
    val stra = a.toString()
    var total: Long = 0

    for(i in stra) {
        total += i.toString().toLong()
    }
    return total

}

//5.Soru bmi hesaplama
fun bmi (kg: Double, mtr: Double): Double {
    val kitle = (kg*10000.0)/(mtr*mtr)
    return kitle
}

//6.Soru

fun tersYazma (a: Int):Int {
    try{
        val b = a.toString().reversed()
        return b.toInt()
    }catch (ex: Exception) {
        println("Hata!")
        return -1
    }

}

//7.Soru isPolindrome

fun polindrome(a: Int): Boolean {
    if(a < 0) {
        return false
    }
    val b= a.toString()
    val c = b.reversed()
    return c == b
}


//8.Soru min ve max toplama
fun minSumMax(lst: MutableList<Int>) : Int {
    if(lst.isEmpty()) {
        throw Exception(" Hata liste boş olamaz!!")
    }
    var max = lst[0]
    var min = lst[0]

    for(item in lst) {
        if(item > max) {
            max = item
        }
        if (item < min) {
            min = item
        }
    }
    return min + max
}

//9.Soru array sayıyı içeriiyorsa?
fun arrSayi(arr: IntArray, sayi: Int): Boolean {
    for (i in arr) {
        if (i == sayi) {
            return true
        }

    }
    return false
}

//10.Soru
fun enBuyukSayi(sayi1:Int, sayi2:Int, sayi3:Int, sayi4:Int):Int {
    var max = sayi3
    if(sayi1 > max) max = sayi1
    if(sayi2 > max) max = sayi2
    if(sayi4 > max) max = sayi4
    return max
}

//11.Soru

fun arrOrtak (arr1: IntArray, arr2: IntArray) : MutableList<Int> {
    val ortak = mutableListOf<Int>()
    for(i in arr1) {
        for(k in arr2) {
            if(i == k) {
                ortak.add(i)
                break
            }
        }
    }
    return ortak

}


//12.Soru

fun sifiraBolme(a: Int, b:Int) {
    try{
        val c = a/b
    }catch (ex: Exception) {
        println("Sayı sıfıra bölünemez!!")
    }
}



//13.Soru

fun sayiMi (): Int? {
    try {
        println("Lütfen Sayı giriniz")
        val sayi = readLine()
        val sayiKontrol = sayi?.toInt()

        if( sayiKontrol != null) {
            return sayiKontrol
        }else {
            throw Exception("Girilen sayı değildir!!")
        }

    }catch(ex: Exception) {
        println("Hata adı : ${ex.message}")
        return null
    }
}

//14.Soru
fun bolen (a:Double, b: Double): Double? {
    try {
        if(b == 0.0) {
            throw Exception("Sıfıra bölünemez!")
        }
        return a/b
    } catch(ex: Exception) {
        println("Sıfır ile bölme yapılamaz")
        return null
    }
}


//15.soru

fun calAvr () {
    var sayi1:Double
    var sayi2:Double
    while(true) {
        try{
            println("Lütfen ilk sayıyı giriniz")
            sayi1 = readln().toDouble()

            println("Lütfen ikinci sayıyı giriniz")
            sayi2 = readln().toDouble()

            val avr = (sayi1 +sayi2)/2
            println("Girilen sayilarin ortalaması : $avr")
            break

        }catch(ex: Exception){
            println("Lütfen sayi giriniz!!")
        }
    }
}

//16.Soru

fun strMatch () {
    try{
        val scanner = Scanner(System.`in`)
        println("ilk metni giriniz")
        val str1 = scanner.nextLine()
        println("ikinci metni giriniz")
        val str2 = scanner.nextLine()
        if(str1.length != str2.length) {
            throw Exception("Karakter sayıları uyuşmuyor")
        }
        println("Karakter sayilari uyuşuyor")
    }catch(ex: Exception) {
        println(ex.message)
    }
}


//17.Soru
fun textToInt () {
    try {
        println("Metin giriniz")
        val metin = readLine()
        if ( metin != null) {
            val numInt = metin.toIntOrNull()
            if(numInt != null) {
                println("Tam sayıya çevirilen metin: $numInt")
            }else{
                println("Geçerli sayı giriniz")
            }

        }else {
            println("Geçerli bir text giriniz")
        }
    }catch(ex: Exception) {
        println("Hata! Geçersiz sayi")
    }
}

//18.Soru Çarpma

fun carpma(){
    try {
        println("Lütfen ilk sayıyı giriniz")
        val num1 = readLine()!!.toInt()
        println("Lütfen ikinci sayıyı giriniz")
        val num2 = readLine()!!.toInt()
        val carpim = num1*num2
        println("Çarpım sonucu: $carpim")
    }catch(ex: Exception){
        println("Lütfen geçerli sayı giriniz")
    }
}

//19.Soru 4 Basamaklı 2 ile Bölümü Tek mi çift mi
fun ikiyeBolme() {
    try{
        println("Lütfen 4 basamaklı sayı giriniz")
        var dortbasamak = readLine()!!.toInt()
        if(dortbasamak in 1000..9999) {
            val kalan = dortbasamak % 2
            if(kalan == 0) {
                println("Girilen sayı çift sayıdır")
            }else{
                println("Girilen sayı tek sayıdır")
            }
        }else{
            println("Geçersiz sayı!! Lütfen 4 basamaklı sayı giriniz")
        }
    }catch(ex: Exception) {
        println("Geçersiz sayı!")
    }
}

//20.soru Random 0-20 arası sayılardan 5 tanesinin çift tek olma durumu
fun rangeOddOrEven() {
    val listeler = mutableListOf<Int>()
    var sayac = 0
    try {
        while (sayac < 5) {
            println("Lütfen $sayac. sayıyı giriniz(İzin verilen aralık 0-20)")
            val girdi = readln()?.toInt()

            if(girdi != null && girdi in 0..20) {
                listeler.add(girdi)
                sayac++
            }else {
                println("Sadece 0-20 arasında sayı giriniz!")
            }
        }
        val even = listeler.filter { it %2 == 0}
        val odd = listeler.filter { it % 2 == 1}

        if(odd.isNotEmpty()) {
            val oddAvr = odd.average()
            println("Tek sAyıların ortalaması : $oddAvr")
        }else{
            println("Tek sayı yok!")
        }

        if(even.isNotEmpty()) {
            val evenAvr = even.average()
            println("Çift sayı ortalaması: $evenAvr")
        }else{
            println("Çift sayı yok!")
        }

    }catch(ex: Exception){
        println("Hata!")

    }
}



//21.Soru
fun indexTopla() {
    print("Liste boyutunu giriniz: ")
    val boyut = try {
        readln().toInt()
    }catch(ex: Exception) {
        println("Geçersiz boyut!")
        return
    }
    if(boyut <= 0) {
        println("Geçersiz boyut! Pozitif sayı giriniz")
        return
    }

    val yeniListe = mutableListOf<Int>()
    for(item in 0..boyut-1) {
        println("Liste elemanı : $item. eleman")
        val eleman = try {
            readln().toInt()
        }catch (ex: Exception) {
            println("Hata! tam sayı giriniz")
            return
        }
        yeniListe.add(eleman)
    }

    var oddIndex = 0
    var evenIndex = 0

    for(i in yeniListe.indices) {
        if(i % 2 == 0) {
            evenIndex += yeniListe[i]
        }else {
            oddIndex += yeniListe[i]
        }
    }
    println("Çift index toplamı : $evenIndex")
    println("Tek index toplamı : $oddIndex")

}




//22.Soru
fun mukemmelSayi() {
    try{
        val scanner = Scanner(System.`in`)
        println("**Mükemmel Sayı Kontrol**")
        println("Lütfen sayı giriniz:")
        val giris = scanner.nextInt()
        var toplam = 0
        for(i in 1 until giris) {
            if(giris % i == 0) {
                toplam +=i
            }
        }
        if(giris == toplam) {
            println("$giris sayısı mükemmel bir sayıdır")
        }else {
            println("$giris sayısı mükemmel bir sayi değildir!")
        }
    }catch(ex: Exception){
        println("Hata!!")
    }

}


//23.Soru
fun calsqrt() {
    try {
        println("Lütfen karekökünü hesaplamak istediğiniz sayiyi giriniz")
        val sqrt = readLine()?.toDouble()

        if(sqrt != null && sqrt >= 0) {
            val kok = Math.sqrt(sqrt)
            println(kok)
        }else {
            println("Hata!! Lütfen pozitif sayi giriniz")
        }

    }catch(ex: Exception) {
        println("Geçersiz sayı!")
    }
}

//24.Soru Armstrong sayısı mı ?
fun armstrong() {
    try{
        println("**Armstrong Sayısı**")
        var scanner = Scanner(System.`in`)
        println("Lütfen 3 basamaklı sayı giriniz")
        var num = scanner.nextLine()
        if(num != null && num.length ==3 ){
            var strNum = num.toInt().toString()
            var total = 0.0
            for(item in strNum) {
                var strDouble = item.toString().toDouble()
                var lenDouble = strNum.length.toDouble()
                total += strDouble.pow(lenDouble)
            }
            if(total == num.toDouble()){
                println("$total sayısı armstrong bir sayıdır")
            }else {
                println("$num sayısı armstrong bir sayı değildir!")
            }
        }else {
            println("Hata! Lütfen 3 basamaklı sayı giriniz!")
        }


    }catch (ex: Exception){
        println("Hata!!")
    }

}


//25.Soru

fun faktoriyel(n: Int): Long {
    if(n < 0) {
        throw Exception("Negatif olamaz!")
    }
    if(n == 0 || n==1) {
        return 1
    }
    var result: Long =1
    for (i in 2..n) {
        result *=i
    }
    return result
}

//26.Soru Ehliyet Yaşı
fun ehliyetYas(){
    try {
        println("Lütfen yaşınızı giriniz")
        val yas = readln().toInt()

        if(yas != null && yas >= 0 ) {
            val ehliyetYas = 18
            if(yas >= ehliyetYas) {
                println("Ehliyet alabilirsiniz")
            }else {
                val ehliyetZamani = ehliyetYas - yas
                println(" Ehliyet alamazsınız! Ancak $ehliyetZamani yıl sonra ehliyet alabilirsiniz ")
            }

        }else{
            println("Geçersiz yaş girildi!!")
        }
    }catch(ex : Exception) {
        println("Geçerli bir yaş değeri girmelisiniz!")
    }

}

//27.Soru Kaçıncı soru olduğunu bulma 0-50 aralığı

fun kacinciSoru() {
    try {
        print("1 ile 50 arasında sayı giriniz: ")
        val giris = readLine()?.toInt()
        if(giris != null && giris in 1..50) {
            println("Girdiğiniz sayı : $giris")
        }else {
            println("Geçersiz aralık!")
        }
    }catch(ex: Exception) {
        println("Geçersiz format! Lütfen sayi giriniz !")
    }
}

//29.Soru Lys puanına Göre fakülteye yerleşme

fun lysPuani() {
    try {
        println("Lütfen lys puanını giriniz")
        val puan = readLine()
        if( puan != null && !puan.isEmpty()) {
            val lysPuan = puan.toInt()
            if(lysPuan in 400..430) {
                println("Mühendislik Fakültesi'ne yerleşebilirsiniz ")
            }else {
                println("Üzülme, Vazgeçme!")
            }
        }else {
            println("Hata! lütfen bir sayı giriniz!")
        }
    }catch (ex: Exception) {
        println("Hata! Lütfen geçerli formatta sayı giriniz")
    }finally {
        println("İşlem tamamlandı")
    }
}

//29.Soru Quiz Sorusu
fun quiz(){
    try{
        var cevap = 4
        val quiz = "2345*265 = 621?25 soru işareti yerine hangi sayi gelmelidir?"

        println(quiz)
        println("İpucu: 9 ile bölünebilme kuralından faydalabilirsiniz")
        val ans = readln().toInt()
        if(cevap == ans) {
            println("Doğru cevap verdiniz")
        }else{
            println("Yanlış cevap verdiniz")
        }

    }catch (ex: Exception) {
        println("Hata!")
    }
}
