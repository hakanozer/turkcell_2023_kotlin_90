package com.gorkemarslanbogan.gorkem_arslanboganodev2

import java.lang.Math.sqrt
import kotlin.math.pow

class Odevler2 {
      fun isPrime(num: Int): Boolean {
        var response = true
        if (num >= 2) {
            for (i in 2 until num) {
                if (num % i == 0) {
                    response = false
                    break
                }
            }
        } else {
            response = false
        }
        return response
    }

    fun toplamHesapla(ilki: Int, ikincisi: Int): Int {
        var sum = 0
        for (sayi in ilki + 1..ikincisi) {
            sum += sayi
        }

        return sum
    }

    fun tekmimiCiftmi3Soru(a: Int, b: Int): Double {
        var sonuc = 0.0
        val sayi1 = a.toDouble()
        val sayi2 = b.toDouble()
        try {
            if(b == 0){
                throw java.lang.NumberFormatException("Bölen sayi 0 olamaz")
            }
            if(a % 2 == 0) {
                sonuc = sayi1 % sayi2
            }else {
                sonuc = sayi1 / sayi2
            }
        }catch (e: java.lang.NumberFormatException) {
            e.printStackTrace()
            print(e.message)
        }
        return sonuc
    }

    fun LongrakamlarToplami(sayi: Long): Int {
        val sayiString = sayi.toString()
        var toplam: Int = 0

        for (rakam in sayiString) {
            if (rakam.isDigit()) {
                toplam += rakam.toString().toInt()
            }
        }

        return toplam
    }

    fun VucutKitleEndeksiHesapla(kilo: Double, boy: Double): Double {
        if (kilo <= 0.0 || boy <= 0.0) {
            throw IllegalArgumentException("Kg ve boy değerleri pozitif olmalıdır.")
        }
        return kilo / (boy * boy)
    }

    fun SayinintersiniYaz(sayi: Int): Int {
        try {
            val sayiString = sayi.toString()
            val tersString = sayiString.reversed()
            return tersString.toInt()
        } catch (ex: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girildi")
            return 0
        }
    }


    fun isPalindrom(num: Int): Boolean {
        return num == SayinintersiniYaz(num)
    }


    fun enBuyukEnKucukToplami(dizi: IntArray): Int {
        var response = 0;
        if (!dizi.isEmpty()) {
            val enBuyuk = dizi.maxOrNull() ?: 0
            val enKucuk = dizi.minOrNull() ?: 0
            response = enBuyuk + enKucuk
        }
        return response
    }
    fun DizininIcındeSayiVarmi(dizi: IntArray, num: Int): Boolean {
        var response = false;
        if(dizi.isNotEmpty()){
            for (i in dizi){
                if(i == num){
                    response = true
                    break
                }
            }
        }
        return response
    }

    fun EnBuyukSayiyiBul(): Int {
        val sayilar = mutableListOf<Int>()
        Yazdir("Lütfen 4 tamsayı girin:")
        for (i in 1..4) {
            Yazdir("Sayı $i: ")
            val sayi = readLine()?.toIntOrNull() ?: 0
            sayilar.add(sayi)
        }
        return sayilar.maxOrNull() ?: 0
    }

    fun DizilerdekiOrtakElemanSayisi(dizi: IntArray, dizi2: IntArray): Int {
        var response = 0;
        if(dizi.isNotEmpty() && dizi2.isNotEmpty()){
            for (dizi1Num in dizi){
                for (dizi2Num in dizi2){
                    if(dizi1Num == dizi2Num){
                        response++
                        break
                    }
                }
            }
        }
        return response
    }

    fun Soru12(num1: Int, num2: Int) {
        try {
            val sonuc = num1 / num2
            Yazdir("Sonuç: $sonuc")
        } catch (e: ArithmeticException) {
            Yazdir("Sıfıra bölmeye çalışırken hata oluştu: ${e.message}")
            e.printStackTrace()
        }
    }
    fun Soru13(){
        try {
            Yazdir("Bir sayı girin: ")
            val girilenSayi = readLine()
            val sayi = girilenSayi?.toInt()
            if (sayi != null) {
                Yazdir("Girilen sayı: $sayi")
            } else {
                Yazdir("Geçersiz giriş. Lütfen bir sayı girin.")
            }
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçerli bir sayı girilmedi.")
        }
    }

    fun Soru14(bolunenSayi: Int, bolen: Int) : Int{
        return try {
            if (bolen == 0) {
                throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")
            }
            bolunenSayi / bolen
        } catch (e: ArithmeticException) {
            Yazdir(e.message.toString())
            e.printStackTrace()
            0
        }
    }

    fun Soru15() {
        try {
            Yazdir("Lütfen iki tam sayı girin:")
            val sayilar = IntArray(2)
            sayilar[0] = readLine()?.toInt() ?: 0
            sayilar[1] = readLine()?.toInt() ?: 0
            Yazdir("Ortalama: ${sayilar.average()}")
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Lütfen sadece tam sayı değerleri giriniz.")
            e.printStackTrace()
            Soru15()
        }

    }
    fun Soru16() {
        Yazdir("Lütfen iki string ifade girin:")
        val str1 = readLine()
        val str2 = readLine()
        try {
            if (str1 != null && str2 != null) {
                if(str1.length == str2.length){
                    Yazdir("Karakter sayıları eşit.")
                }
            }
        } catch (e: NumberFormatException) {
            Yazdir("Karakter sayıları uyuşmuyor")
            e.printStackTrace()
        }

    }

    fun Soru17(){
        Yazdir("Lütfen bir tamsayı girin:")
        val userInput = readLine()

        try {
            val sayi = userInput?.toInt() ?: throw NumberFormatException("Geçersiz giriş. Lütfen bir tamsayı girin.")
            Yazdir("Girilen tamsayı: $sayi")
        } catch (e: NumberFormatException) {
            Yazdir("Hata: ${e.message}")
            e.printStackTrace()
        }
    }

    fun Soru18(){
        try {
            Yazdir("Birinci sayıyı girin:")
            val sayi1 = readLine()?.toInt()  ?: throw NumberFormatException()
            Yazdir("İkinci sayıyı girin:")
            val sayi2 = readLine()?.toInt()  ?: throw NumberFormatException()
            val carpim = sayi1 * sayi2
            Yazdir("Çarpım $carpim")
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            Yazdir("Hata: Geçerli bir tam sayı girilmedi.")
        }
    }
    fun Soru19(){
        try {
            Yazdir("Dört basamaklı bir sayı girin: ")
            val userInput = readLine()?.toInt() ?: throw NumberFormatException()

            if (userInput in 1000..9999) {
                if (userInput % 2 == 0) {
                    Yazdir("Girilen sayı 2 ile bölündüğünde kalan sıfırdır.")
                } else {
                    Yazdir("Girilen sayı 2 ile bölündüğünde kalan sıfır değildir.")
                }
            } else {
                Yazdir("Girilen sayı dört basamaklı değil.")
            }
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçerli bir dört basamaklı sayı girilmedi.")
            e.printStackTrace()
        }
    }

    fun Soru20(){
        val ciftSayilar = arrayListOf<Int>()
        val tekSayilar = arrayListOf<Int>()
        try {
            for (i in 1..5) {
                Yazdir("Lütfen 0 ile 20 arasında bir sayı girin: ")
                val userInput = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
                if (userInput < 0 || userInput > 20) {
                    throw IllegalArgumentException("Girilen sayı 0 ile 20 arasında olmalıdır!")
                }
                if(userInput % 2 == 0){
                    ciftSayilar.add(userInput)
                }else {
                    tekSayilar.add(userInput)
                }
            }

            if (ciftSayilar.isNotEmpty()) {
                val ciftlerinOrtalamasi = ciftSayilar.average()
                Yazdir("Çift sayıların aritmetik ortalaması: $ciftlerinOrtalamasi")
            } else {
                Yazdir("Çift sayı bulunamadı.")
            }

            if (tekSayilar.isNotEmpty()) {
                val teklerinOrtalamasi = tekSayilar.average()
                Yazdir("Tek sayıların aritmetik ortalaması: $teklerinOrtalamasi")
            } else {
                Yazdir("Tek sayı bulunamadı.")
            }
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: IllegalArgumentException) {
            Yazdir("Hata: Girilen sayı 0 ile 20 arasında olmalıdır.")
        }
    }


    fun Soru21(){
        try {
            Yazdir("Bir pozitif sayı girin: ")
            val diziSize = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
            if (diziSize < 0) {
                throw IllegalArgumentException("Negatif sayı girişi yapılamaz!")
            }
            val dizi = IntArray(diziSize)

            for (i in 0 until diziSize) {
                print("Eleman $i: ")
                dizi[i] = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz eleman!")
            }
            val ciftSayilarToplam = dizi.filterIndexed() { index, _ -> index % 2 == 0 }.sum()
            val tekSayilarToplam = dizi.filterIndexed() { index, _ -> index % 2 != 0 }.sum()
            Yazdir("Çift indeksteki elemanların toplamı: $ciftSayilarToplam")
            Yazdir("Tek indeksteki elemanların toplamı: $tekSayilarToplam")
        }catch (e: NumberFormatException) {
            Yazdir(e.message.toString())
            e.printStackTrace()
        }catch (e: IllegalArgumentException) {
            Yazdir(e.message.toString())
            e.message
        }
    }

    fun Soru22(){
        try {
            Yazdir("Bir pozitif sayı girin: ")
            val mukemmelSayimi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
            if (mukemmelSayimi < 0) {
                throw IllegalArgumentException("Negatif sayı girişi yapılamaz!")
            }
            var bolenlerinToplami = 0
           for(i in 1 until mukemmelSayimi){
               if(mukemmelSayimi % i == 0){
                   bolenlerinToplami+= i
               }
           }
            Yazdir("${mukemmelSayimi}: sayısı ${if (bolenlerinToplami == mukemmelSayimi) "mükemmel sayidir" else "mükemmel sayi değil"}")

        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: IllegalArgumentException) {
            Yazdir("Hata: Negatif sayı girişi yapılamaz.")
        }
    }
    fun Soru23(){
        try {
            Yazdir("Bir pozitif sayı girin: ")
            val userInput = readLine()?.toDouble() ?: throw NumberFormatException("Geçersiz giriş!")
            if (userInput < 0) {
                throw IllegalArgumentException("Negatif sayı girişi yapılamaz!")
            }
            val squareRoot = kotlin.math.sqrt(userInput)
            Yazdir("Girdiğiniz sayının karekökü: $squareRoot")
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: IllegalArgumentException) {
            Yazdir("Hata: Negatif sayı girişi yapılamaz.")
        }
    }


    fun Soru24(){
        try {
            Yazdir("Lütfen 3 basamaklı bir sayı girin: ")
            val girilenSayi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
            if (girilenSayi !in 100..999) {
                throw IllegalArgumentException("3 basamaklı bir sayı girmelisiniz!")
            }
            val usAlinacakSayi = girilenSayi.toString()[0].digitToInt().toDouble()
            var sonuc = 0.0
                for(i in girilenSayi.toString()) {
                  sonuc += i.digitToInt().toDouble().pow(usAlinacakSayi)
                }
            Yazdir("${girilenSayi}: sayısı armstrong ${if (girilenSayi.toDouble() == sonuc) "sayidir" else "değil"}")
        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girdiniz.")
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            Yazdir(e.message.toString())
            e.printStackTrace()
        }
    }

    fun Soru25(){
        try {
            Yazdir("Pozitif bir tam sayı girin: ")
            val userInput = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")

            if (userInput < 0) {
                throw IllegalArgumentException("Negatif bir sayı girişi yapılamaz!")
            }
            var faktoriyel = 1

            for (i in 1..userInput) {
                faktoriyel *= i
            }
            Yazdir("Girilen sayinin faktöriyeli : $faktoriyel")
        } catch (e: NumberFormatException) {
            Yazdir(e.message.toString())
        } catch (e: IllegalArgumentException) {
            Yazdir(e.message.toString())
        }

}

    fun Soru26(){
        val ehliyetAlmaYasi = 18
        try {
            Yazdir("Yaşınızı Girin: ")
            val userInput = readLine()?.toDouble() ?: throw NumberFormatException("Hata: Geçersiz bir sayı girdiniz.")
            if (userInput < 0) {
                throw IllegalArgumentException("Negatif sayı girişi yapılamaz!")
            }
            if(userInput < ehliyetAlmaYasi) {
                Yazdir("Maalesef ehliyet alacak yaşta değilsiniz,\n" +
                        "${ehliyetAlmaYasi - userInput} yıl sonra ehliyet almaya hak kazanabilirsiniz!")
            }else {
                Yazdir("Ehliyet Alabilirsiniz.")
            }

        } catch (e: NumberFormatException) {
            Yazdir(e.message.toString())
        } catch (e: IllegalArgumentException) {
            Yazdir(e.message.toString())
        }
    }


    fun Soru27(){
        try {
        Yazdir("Lütfen 0 ile 50 arası bir tam sayı girin ")
        val girilenSayi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
        if (girilenSayi !in 1..50) {
            throw IllegalArgumentException("0 ile 50 arası bir sayı girmelisiniz!")
          }
        } catch (e: Exception){
            Yazdir(e.message.toString())
            e.printStackTrace()
        }
    }

    fun Soru28(){
        try {
            Yazdir("Lys puanınızı girin: ")
            val userInput = readLine()

            if (userInput == null || userInput.isEmpty()) {
                throw IllegalArgumentException("Puan boş bırakılamaz!")
            }
            val lysPuan = userInput.toDouble()

            if (lysPuan >= 400 && lysPuan <= 430) {
                Yazdir("Mühendislik Fakültesi'ne yerleşebilirsiniz.")
            } else {
                Yazdir("Üzülme, Vazgeçme ! 😊")
            }

        } catch (e: NumberFormatException) {
            Yazdir("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: IllegalArgumentException) {
            Yazdir("Hata: ${e.message}")
        } finally {
            Yazdir("İşlem Tamamlandı")
        }

    }

    fun Soru29(){
        Yazdir("Quiz Başlıyor!\n")

        Yazdir("1. Türkiye'nin başkenti neresidir?")
        val cevap1 = readLine()
        if (cevap1.equals("Ankara")) {
            Yazdir("Doğru cevap! Ankara Türkiye'nin başkentidir.")
        } else {
            Yazdir("Yanlış cevap. Doğru cevap Ankara'dır.")
        }

        Yazdir("\n2. Türkiye'nin ilk cumhurbaşkanı kimdir?")
        val cevap2 = readLine()
        if (cevap2.equals("Mustafa Kemal Atatürk")) {
            Yazdir("Doğru cevap! Mustafa Kemal Atatürk Türkiye'nin ilk cumhurbaşkanıdır.")
        } else {
            Yazdir("Yanlış cevap. Doğru cevap Mustafa Kemal Atatürk'tür.")
        }
        
        Yazdir("\n3. Türkiye kaç yılında kuruldu?")
        val cevap3 = readLine()
        if (cevap3 == "1923") {
            Yazdir("Doğru cevap! Türkiye 1923 yılında kuruldu.")
        } else {
            Yazdir("Yanlış cevap. Doğru cevap 1923'tür.")
        }

    }
    fun Yazdir(text:String){
        println(text)
    }
}