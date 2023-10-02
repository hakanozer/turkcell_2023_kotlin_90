package com.davutkarakus.turkcellgecelegiyazanlarodev2

import java.lang.Math.pow
import kotlin.math.pow

fun main(args: Array<String>) {
    println(isPrime(3))
    println(tekMiCiftMi(8,5))
    println(toplam(3,6))
    println(rakamlariToplami(1234567890))
    println(bmiHesapla(1.80,80.0))
    println(sayiyiTerstenYazdir(1557))
    println(isPalindrome(155551))
    println(enBuyukEnKucukToplam(arrayOf<Int>(5,6,7,8,9)))
    println(sayiyiIceriyorMu(arrayOf(5,6,7,8),8))
    println(enBuyuguYazdir(8,10,6,7))
    println(ortakElemaniBul(arrayOf(5,6,7,8), arrayOf(8,9,10,5,12)))
    println(sifiraBolunme(5))
    println(sayiAlEkranaYazdir())
    println(ikiSayiBol(0,5))
    println(ikiDegerinOrtalamasiniBul())
    println(stringKarakterSayilariKarsilastir())
    println(metinVerisinIntDonustur())
    println(carpimHesapla())
    println(dortBasamakliSayiAl())
    println(aritmetikOrtalama())
    println(listeTamSayiGir())
    println(mukemmelSayiBul())
    println(karekokHesapla())
    println(armstrongSayi())
    println(faktoriyelHesapla())
    println(kacinciSoru())
    println(lysPuan())
    println(ehliyetKontrol())
    println(quizUygulamasi())
}
fun isPrime(a:Int):Boolean{
    var sayac = 0
    for (i in 2 until a) {
        if (a % i == 0) {
            sayac++
        }
    }
    return sayac == 0
}
fun toplam(a:Int,b:Int) : Int {
    var toplam = 0
    for (i in a+1..b) {
        toplam += i
    }
    return toplam
}
fun tekMiCiftMi(a:Int,b:Int) : Double {
    if (a % 2 == 1){
        return (a/b).toDouble()
    }else{
        return (a%b).toDouble()
    }
}
fun rakamlariToplami(a:Long) : Long {
    var sayi = a
    var adet = 0
    var toplam = 0L
    while (sayi != 0L) {
        toplam += sayi % 10
        sayi /= 10
        ++adet
    }
    return toplam
}
fun bmiHesapla(boy:Double,kilo:Double) : Double {
    val bmi = kilo / (boy*boy)
    return bmi
}
fun sayiyiTerstenYazdir(a:Int) : Int {
    var sayi = a
    var reverse = 0
        while (sayi != 0) {
            reverse *= 10
            reverse += sayi % 10
            sayi /= 10
        }
       return reverse
}
fun isPalindrome(a:Int) : Boolean {
    var sonuc = true
    var sayi = a
    var reversedNumber = 0
    while (sayi > 0) {
        val mod = sayi % 10
        reversedNumber = reversedNumber * 10 + mod
        sayi /= 10
    }
    sonuc = a == reversedNumber
    return sonuc
}
fun enBuyukEnKucukToplam(a:Array<Int>) : Int{
    val enBuyuk = a.maxOrNull()
    val enKucuk = a.minOrNull()
    return enBuyuk!! + enKucuk!!
}
fun sayiyiIceriyorMu(a:Array<Int>,b:Int) : Boolean {
    var bool = true
    for (i in a) {
        bool = b == i
    }
    return bool
}
fun enBuyuguYazdir(a:Int,b:Int,c:Int,d:Int) : Int {
    var enBuyuk = a
    if (b > enBuyuk) {
        enBuyuk = b
    }
    if (c > enBuyuk) {
        enBuyuk = c
    }
    if (d > enBuyuk) {
        enBuyuk = d
    }
    return enBuyuk
}
fun ortakElemaniBul(a:Array<Int>,b:Array<Int>) : Int {
    var sayac = 0
    for (i in a) {
        for ( j in b) {
            if (i == j) {
                sayac++
            }
        }
    }
    return sayac
}
fun sifiraBolunme(a:Int) {
    var sonuc = 0
    try {
        sonuc = a / 0
        println(sonuc)
    }catch (e:Exception){
        println("Sayi sifira bolunmez")
    }
}
fun sayiAlEkranaYazdir() {
    println("Sayi Gir : ")
    val sayi = readlnOrNull()
    if(sayi != null) {
        try {
            val s = sayi.toInt()
            println(s)
        }catch (e:Exception) {
            println("Lutfen sayisal deger giriniz!")
        }
    }
}
fun ikiSayiBol(a:Int,b:Int) {
    var sonuc = 0
    try {
        sonuc = a / b
        println(sonuc)
    }catch (e:Exception) {
        println("Bolme islemi sifira bolunemez.")
    }
}
fun ikiDegerinOrtalamasiniBul() {
    println("Ilk Sayiyi Gir : ")
    val sayiBir = readlnOrNull()
    println("Ikinci Sayiyi Gir : ")
    val sayiIki = readlnOrNull()
    if(sayiBir != null && sayiIki != null) {
        try {
            val s1 = sayiBir.toInt().toDouble()
            val s2 = sayiIki.toInt().toDouble()
            val sonuc = (s1+s2) / 2
            println(sonuc)
        }catch (e:Exception) {
            println("Lutfen integer degerler giriniz")
            ikiDegerinOrtalamasiniBul()
        }
    }else {
        println("Sayilarin değerini giriniz.")
    }
}
fun stringKarakterSayilariKarsilastir() {
    println("Ilk metin degerini giriniz : ")
    val stringBir = readlnOrNull()
    println("Ikinci metin degerini giriniz : ")
    val stringIki = readlnOrNull()
    if  (stringBir != null && stringIki != null) {
        try {
            val s1 = stringBir.toString()
            val s2 = stringIki.toString()
            if (s1.length == s2.length) {
                println("Karakter sayilari esit")
            }else {
                println("Karakter sayilari esit degil")
            }
        }catch (e:Exception) {
            println("String deger giriniz")
        }
    }
}
fun metinVerisinIntDonustur() {
    println("Bir deger gir : ")
    val deger = readlnOrNull()
    if (deger != null) {
        try {
            var d = deger.toInt()
            println(d)
        }catch (e:Exception) {
            println("Girilen deger int degil")
        }
    }else {
        println("Lutfen bir sey giriniz!")
    }
}
fun carpimHesapla() {
    println("Ilk Sayiyi Gir : ")
    val sayiBir = readlnOrNull()
    println("Ikinci Sayiyi Gir : ")
    val sayiIki = readlnOrNull()
    if (sayiBir != null && sayiIki != null) {
        try {
            val s1 = sayiBir.toInt()
            val s2 = sayiIki.toInt()
            val sonuc = s1 * s2
            println(sonuc)
        }catch (e:Exception) {
            println("Lutfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen boş bırakmayınız!")
    }
}
fun dortBasamakliSayiAl() {
    println("Dort Basamakli Sayi Giriniz : ")
    val sayi = readlnOrNull()
    if (sayi != null) {
        try {
            val s = sayi.toInt()
            val a = s % 2
            if (a == 0) {
                println("Sayi 2 ye tam bolunuyor")
            }else {
                println("Sayi ikiye tam bolunmuyor")
            }
        }catch (e:Exception) {
            println("Sayisal değer giriniz")
        }
    }else {
        println("Lutfen dort basamakli sayi giriniz")
    }
}
fun aritmetikOrtalama() {
    println("1-20 Arasında 5 Adet Sayi Giriniz")
    println("Birinci Sayi Giriniz : ")
    val sayiBir = readlnOrNull()
    println("Ikinci Sayiyi Giriniz : ")
    val sayiIki = readlnOrNull()
    println("Ucuncu Sayiyi Giriniz : ")
    val sayiUc = readlnOrNull()
    println("Dorduncu Sayiyi Giriniz : ")
    val sayiDort = readlnOrNull()
    println("Besinci Sayiyi Giriniz : ")
    val sayiBes = readlnOrNull()
    if (sayiBir != null && sayiIki != null && sayiUc != null && sayiDort != null && sayiBes != null ) {
        try {
            var cifttoplam = 0
            var tektoplam = 0
            val s1 = sayiBir.toInt()
            val s2 = sayiIki.toInt()
            val s3 = sayiUc.toInt()
            val s4 = sayiDort.toInt()
            val s5 = sayiBes.toInt()
            val ciftSayilar = arrayListOf<Int>()
            val tekSayilar = arrayListOf<Int>()
            val list : ArrayList<Int> = arrayListOf()
            list.add(s1)
            list.add(s2)
            list.add(s3)
            list.add(s4)
            list.add(s5)
            for (i in list) {
                if (i % 2 == 0){
                    ciftSayilar.add(i)
                }else {
                    tekSayilar.add(i)
                }
            }
            for (i in ciftSayilar) {
                cifttoplam += i
            }
            println("Cift Sayilar Ortalamasi ${cifttoplam/ciftSayilar.size}")
            for (i in tekSayilar) {
                tektoplam += i
            }
            println("Tek Sayilar Ortalamasi ${tektoplam/tekSayilar.size}")
        }catch (e:Exception) {
            println("Lütfen sayisal degerler giriniz")
        }
    }else {
        println("Lütfen tum degerleri giriniz")
    }
}
fun listeTamSayiGir() {
    println("Kac Adet Sayi Gireceginizi Yaziniz:")
    val sayi = readlnOrNull()
    val list = arrayListOf<Int>()
    var n = 0
    if (sayi != null) {
        try {
            val s = sayi.toInt()
            while (n < s) {
                println("${n+1}.Sayiyi Giriniz:")
                val deger = readlnOrNull()
                if (deger != null) {
                    try {
                        val d = deger.toInt()
                        list.add(d)
                        n++

                    }catch (e:Exception){
                        println("Lütfen sayisal degerler giriniz")
                    }
                }
            }
            var index = 0
            var ciftToplam = 0
            var tekToplam = 0
            while (index < s){
                if (index % 2 == 0) {
                    ciftToplam = list [index] + ciftToplam
                }else {
                    tekToplam = list [index] + tekToplam
                }
                index++
            }
            println("Çift Sayilarin Toplami : ${ciftToplam}")
            println("Tek Sayilarin Toplami : ${tekToplam}")
        }catch (e:Exception) {
            println("Lütfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen degerler giriniz")
    }
}
fun mukemmelSayiBul() {
    println("Bir Sayisal Deger Yaziniz:")
    val sayi = readlnOrNull()
    var toplam = 0
    if (sayi != null) {
        try {
            val s = sayi.toInt()
            for (i in 1 until s) {
                if (s % i == 0) {
                    toplam += i
                }
            }
            if (s == toplam) {
                println("$sayi Mükemmel bir sayidir")
            } else {
                println("$sayi Mükemmel bir sayi degildir.")
            }
        }catch (e:Exception) {
            println("Lütfen sayisal degerler giriniz")
        }
    }else {
        println("Lütfen degerler giriniz")
    }
}
fun karekokHesapla() {
    println("Bir Sayisal Deger Yaziniz:")
    val sayi = readlnOrNull()
    if (sayi != null){
        try {
            val s = sayi.toInt().toDouble()
            if (s < 0) {
                println("Pozitif bir sayi giriniz.")
            }else {
                println("Kare Kök = " + (pow(s,1.0/2)));
            }
        }catch (e:Exception){
            println("Lütfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen deger giriniz")
    }
}
fun armstrongSayi () {
    println("Bir Sayisal Deger Yaziniz:")
    val sayi = readlnOrNull()
    if (sayi != null) {
        try {
            val number = sayi.toInt()
            var remainder: Int
            var result = 0
            var originalNumber: Int = number

            while (originalNumber != 0) {
                remainder = originalNumber % 10
                result += remainder.toDouble().pow(3.0).toInt()
                originalNumber /= 10
            }
            if (result == number)
                println("$number bir Armstrong sayidir.")
            else
                println("$number bir Armstrong sayi degildir.")

        }catch (e:Exception){
            println("Lütfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen deger giriniz")
    }
}
fun faktoriyelHesapla() {
    println("Bir Sayisal Deger Yaziniz:")
    val sayi = readlnOrNull()
    if (sayi != null){
        try {
            val s = sayi.toInt()
            if (s < 0) {
                println("Pozitif bir sayi giriniz.")
            }else {
                var factorial: Long = 1
                for (i in 1..s) {
                    factorial *= i.toLong()
                }
                println("$s Faktoriyel = $factorial")
            }
        }catch (e:Exception){
            println("Lütfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen deger giriniz")
    }
}
fun kacinciSoru() {
    println("Kacinci Soruyu Yazdiniz:")
    val sayi = readlnOrNull()
    if (sayi != null){
        try {
            val s = sayi.toInt()
            if (s <= 50){
                println("${s}.soruyu ben yazdim")
            }else {
                println("1 ile 50 arasinda bir deger yazmalisiniz")
                kacinciSoru()
            }
        }catch (e:Exception){
            println("Lütfen sayisal deger giriniz")
        }
    }else {
        println("Lütfen deger giriniz")
    }
}
fun lysPuan(){
    println("Lys Puaninizi Giriniz : ")
    val puan = readlnOrNull()
    if (puan != null) {
        try {
            val p = puan.toInt()
            if (p != 0 && 400<p && p<430){
                println("Mühendislik Fakültesi’ne yerleşebilirsiniz")
            }else if(p == 0) {
                println("Puanınız 0 olamaz")
            }else {
                println("Üzülme, Vazgeçme !")
            }
        }catch (e:Exception) {
            println("Lütfen sayisal deger giriniz")
        }
    }
}
fun ehliyetKontrol() {
    println("Lutfen Yasinizi Giriniz : ")
    val yas = readlnOrNull()
    if (yas != null) {
        try {
            val y = yas.toInt()
            if (y < 0) {
                println("Yasiniz 0 dan kücük olamaz")
            }else if (y < 18){
                println("Maalesef ehliyet alacak yaşta değilsiniz,${18-y} yıl sonra ehliyet almaya hak kazanabilirsiniz")
            }else if(y in 18..99) {
                println("Ehliyet alabilecek yastasiniz")
            }else {
                println("Lutfen yasinizi dogru giriniz")
            }
        }catch (e:Exception) {
            println("Lütfen sayisal deger giriniz")
        }
    }
}
fun quizUygulamasi() {
    println("Ataturk Samsun'a Kac Yilinda Cikmistir ?  : ")
    val cevap = readlnOrNull()
    if (cevap != null) {
        try {
            val c = cevap.toInt()
            if (c == 1919) {
                println("Tebrikler dogru bildiniz :)")
            }else {
                println("Yanlis cevap !")
            }
        }catch (e:Exception) {
            println("Lutfen bir yil giriniz!")
        }
    }
}