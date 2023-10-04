package com.example.odev_2
import kotlin.math.pow
class odev2 {

    fun asal_sayi(num : Int){
        if (num > 2){
            for (i in 2..num){
                if (num%i==0){
                    println("Sayınız Asal Değildir")
                    break
                }else{
                    println("Sayınız Asaldır")
                    break
                }
            }
        }else{
            println("Sayınız 2'den büyük olmalıdır ")
        }

    }

    fun toplamları (num1 : Int , num2 : Int) : Int {
        var  sum = 0
        for (sayi in num1+1..num2){
            sum+=sayi
        }
        return sum
    }

    fun tekcift (a : Int , b : Int) : Double{
        var sonuc = 0.0
        val sayi = a/b.toDouble()
        val sayi2 = a%b.toDouble()
        if (a%2==0){
            sonuc=sayi
        }else{
            sonuc=sayi2
        }
        return sonuc
    }

    fun rakamtoplami (sayi1 : Int) : Int{
        val sayistring = sayi1.toString()
        var toplam = 0
        for (i in sayistring){
            toplam+=i.toString().toInt()
        }
        return toplam
    }

    fun bmi (kg : Double, boy : Double) : Double{
        var kitleendeksi = kg / (boy*boy)
        return kitleendeksi
    }

    fun terstensayi (tsayi : Int) : Int{
        val birlerters = tsayi % 10
        val onlarters = (tsayi / 10 ) %10
        val yüzlerters = tsayi /100

        val terssayi = birlerters*100 + onlarters*10 + yüzlerters
        return terssayi
    }

    fun palindrome (psayi : Int) : Boolean{
        val c =psayi==terstensayi(psayi)
        return c
    }

    fun enbuyukkucuktoplami ( sayilar : IntArray) : Int{
        var sonuc = 0
        if (!sayilar.isEmpty()){
            val enBuyuk = sayilar.maxOrNull() ?: 0
            val enKucuk = sayilar.minOrNull() ?: 0
            sonuc = enBuyuk + enKucuk
        }
        return sonuc
    }

    fun sayiicerme (sayi9 : IntArray , sayii9 : Int) : Boolean{
        var sonuc = false
        for (i in sayi9){
            if (i==sayii9){
                sonuc = true
            }
        }
        return  sonuc
    }

    fun enbuyuksayi (sayi10 : IntArray) : Int{
        var sonuc = 0
        if (!sayi10.isEmpty()){
            val enbuyuk = sayi10.maxOrNull() ?: 0
            sonuc = enbuyuk
        }
        return sonuc
    }

    fun ortakeleman (sayi11 : IntArray , sayii11 : IntArray) : Int{
        var sonuc = 0
        for (i in sayi11){
            for (a in sayii11){
                if (i==a){
                    sonuc++
                }
            }

        }
        return sonuc
    }

    fun sifirabolme() {
        println("İlk sayınızı girin")
        var bolum = readLine()!!.toInt()
        println("İkinci sayınızı girin")
        var bolen = readLine()!!.toInt()
        var islem:Int=0
        try {
            islem=bolum/bolen
            println("Sonuc: $islem")
        }catch (ex:Exception){
            println("Hata Sıfıra bölünmez!!")
            ex.printStackTrace()
        }
    }

    fun sayimi () {
        println("Sayı giriniz : ")
        var sayi13 = readLine()!!.toInt()
        try {
            if (sayi13 != null){
                println("True")
            }

        }catch (ex:Exception){
            println("Sayı değeri giriniz")
            ex.printStackTrace()
        }
    }

    fun ikitamsayi (){
        try {
            println("İlk sayı değeriniz : ")
            var birincisayi = readLine()!!.toInt()
            println("İkinci sayı değeriniz : ")
            var ikincisayi = readLine()!!.toInt()

            if (birincisayi==0){
                println("Sayı değeriniz 0'dan farklı olmalıdır.")
            }else if (ikincisayi==0){
                println("Sayı değeriniz 0'dan farklı olmalıdır.")
            }else{
                println("Hata bulunamadı.")
            }
            var islem = birincisayi!!.toInt() / ikincisayi!!.toInt()
            println(islem)

        }catch (ex:Exception){
            println("Hatalı değer girdiniz.")
        }
    }

    fun ortalama (){
        try {
            println("İlk Sayınız : ")
            var birinci= readLine()!!.toInt()
            println("İkinci Sayınız")
            var ikinci= readLine()!!.toInt()
            val sonuc = (birinci+ikinci)/2!!.toDouble()
            println(sonuc)
        }catch (ex:Exception){
            println("Integer değer giriniz")
        }
    }

    fun stringifade (){
        try {
            println("String ifade giriniz")
            var str = readLine()!!.toString()
            println("String ifade giriniz")
            var str1 = readLine()!!.toString()
            if (str.length==str1.length){
                println("Karakter sayılarınız eşittir")
            }else{
                println("Sayılarınız eşit değildir")
            }
        }catch (ex:Exception){
            println("String sayı giriniz")
        }
    }

    fun onyedisoru (){
        println("String değer giriniz")
        var string = readLine()!!.toString()
        var rakam = 0
        try {
            rakam=string.length
            println(rakam)
        }catch (ex:Exception){
            println("Hatalı değer girdiniz")
        }
    }

    fun onsekizsoru (){
        println("İlk sayınız : ")
        var sayi18 = readLine()!!.toInt()
        println("İkinci sayınız : ")
        var sayii18 = readLine()!!.toInt()
        var carpimi = sayi18*sayii18
        try {
            if (sayi18-sayi18==0 && sayii18-sayii18==0){
                println(carpimi)
            }else{
                println("Integer değer giriniz.")
            }

        }catch (ex:NumberFormatException){
            println("Hatalı yaptınız")
        }
    }

    fun ondokuzsoru (){
        println("Dört basamaklı sayı giriniz : ")
        var dortbasamak = readLine()!!.toInt()
        try {
            if (dortbasamak in 1000..9999){
                if (dortbasamak%2==0){
                    println("İki ile bölünüyor")
                }else{
                    println("İki ile bölünemez")
                }
            }else{
                println("4 basamaklı sayı giriniz")
            }
        }catch (ex:NumberFormatException){
            println("Hatalı değer girdiniz")
        }
    }

    fun yirmisoru (){
        val Girilendeğerler = mutableListOf<Int>()
        try {for (i in 1..5) {
            print("Lütfen 0 ile 20 arasında bir sayı girin: ")
            val Sayılar = readLine()!!.toInt()
            if (Sayılar < 0 || Sayılar > 20) {
                println("Hatalı giriş! Lütfen 0 ile 20 arasında bir sayı girin.")
            }
            Girilendeğerler.add(Sayılar)
        }
        } catch (ex: Exception) {
            println("Hatalı giriş! Lütfen Sayı olarak Giriniz!")
        }
        val tekSayilar = mutableListOf<Int>()
        val ciftSayilar = mutableListOf<Int>()
        for (sayi in Girilendeğerler) {
            if (sayi % 2 == 0) {
                ciftSayilar.add(sayi)
            } else {
                tekSayilar.add(sayi)
            }
        }
        println("Tek Sayılar: $tekSayilar")
        println(" Çift Sayılar: $ciftSayilar")
        val tekOrtalama = tekSayilar.average()
        val ciftOrtalama = ciftSayilar.average()
        println("Tek  Ortalaması: $tekOrtalama")
        println("Çift  Ortalaması: $ciftOrtalama")
    }

    fun yirmibir (){
        try {
            println("Liste boyutu oluşturun : ")
            var liste = readLine()!!.toInt()
            if (liste<=0){
                println("Hatalı boyut girdiniz")
                return
            }

            var uzunluk = mutableListOf<Int>()
            for (i in 0 until liste){
                println("Sayı giriniz " + i)
                var girilensayi = readLine()!!.toInt()
                uzunluk.add(girilensayi)
            }
            var tekindtop=0
            var ciftindtop=0
            for (i in 0 until liste){
                if (i%2==0){
                    ciftindtop++
                }else{
                    tekindtop++
                }
            }
            println("Çift indekslerin sayısı: " + ciftindtop)
            println("Tek indekslerin sayısı : " + tekindtop)
        }catch (ex:Exception){
            println("Hatalı işlem yaptınız")
        }
    }

    fun yirmiiki (){
        try {
            println("Sayı giriniz")
            var muksayi = readLine()!!.toInt()
            var mukliste = 0
            for (i in 0..muksayi){
                if (muksayi%i==0){
                    mukliste+=i
                    println("Sayınız mükemmel bir sayıdır.Bölünenleri şunlardır : " + mukliste)
                }else{
                    println("Sayınız mükemmel sayı değildir")
                }
            }
        }catch (ex:Exception){
            println("Hatalı giriş yaptınız")
        }
    }

    fun yirmiuc (){
        try {
            println("Sayı giriniz : ")
            val karekok = readLine()!!.toDouble()

            if (karekok <= 0) {
                println("Yanlış değer girdiniz tekrar giriniz")
                return
            } else {
                val karekoku = Math.sqrt(karekok)
                println("Sayınızın karekökü : " + karekoku)
            }
        }catch (ex:Exception){
            println("Hatalı giriş yaptınız")
        }
    }

    fun yirmidort (){
        println("Bir sayı değeri yazınız:")
        val sayi24 = readlnOrNull()
        if (sayi24 != null) {
            try {
                val number = sayi24.toInt()
                var remainder: Int
                var result = 0
                var originalNumber: Int = number

                while (originalNumber != 0) {
                    remainder = originalNumber % 10
                    result += remainder.toDouble().pow(3.0).toInt()
                    originalNumber /= 10
                }
                if (result == number)
                    println("$number bir Armstrong sayıdır.")
                else
                    println("$number bir Armstrong sayı değildir.")

            }catch (e:Exception){
                println("Lütfen sayısal değer giriniz")
            }
        }else {
            println("Lütfen değer giriniz")
        }
    }

    fun yirmibes (){
        try {
            println("Sayı giriniz ")
            val fac = readLine()!!.toInt()
            if (fac <= 0){
                println("Pozitif sayı giriniz")
                return
            }else{
                var factoriel = 1
                for (i in 1..fac){
                  factoriel*=i
                }
                println("Sayınızın factorili : " + factoriel)
            }
        }catch (ex:NumberFormatException){
            println("Hatalı giriş yaptınız")
        }
    }

    fun yirmialti (){
        try {
            print("Yaşınızı girin: ")
            val ehliyetyas = readLine()!!.toIntOrNull()

            if (ehliyetyas == null || ehliyetyas < 0) {
                println("Geçerli bir yaş giriniz.")
                return
            }
            val ehliyetYasi = 18
            if (ehliyetyas < ehliyetYasi) {
                val nezamanalinabilir = ehliyetYasi - ehliyetyas
                println("Ehliyet alamazsınız, $nezamanalinabilir yıl sonra ehliyet alabilirsiniz!")
            } else if (ehliyetyas == ehliyetYasi) {
                println("Tebrikler! Ehliyet alabilirsiniz.")
            } else {
                println("Ehliyet alabilirsiniz.")
            }
        } catch (ex: Exception) {
            println("Geçerli bir yaş girin.")
        }
    }

    fun yirmiyedi (){
        println("Sayı giriniz")
        val sinav = readLine()!!.toInt()
        for (i in 1..50){
            if (sinav==i){
                println("Sorunuz : " + sinav)
                break
            }else{
                println("Hatalı giriş yaptınız")
                break
            }
        }
    }

    fun yirmisekiz (){
        try {
            println("Üniversite puanınızı giriniz ")
            val unipuan = readLine()!!.toInt()
            if (400<unipuan && unipuan<430){
                println("Tebrikler mühendislik fakültesine yerleştiniz")
            }else{
                println("Mühendislik fakültesine yerleşemediniz")
            }
        }catch (ex:Exception){
            println("Yanlış değer girdiniz")
        }
    }

    fun yirmidokuz (){
        val soru = "Türkiye Cumhriyetinin kurucu kimdir"
        val dcevap = "Mustafa Kemal Atatürk"

        println(soru)
        val cevap = readLine()!!.toString()

        try {
            if (cevap==dcevap){
                println("Doğru cevap verdiniz .")
            }else{
                println("Yanlış cevap verdiniz. Doğru cevap Mustafa Kemal Atatürk olacaktır.")
            }
        }catch (ex:Exception){
            println("Hatalı giriş yaptınız")
        }

    }

    fun otuzuncusoru  (){
        val dogruad = "Oğuz Baran Şahingil"
        val dyas = 26
        val demail = "oguzsahingil@mail.com"
        try {
            println("Ad ve Soyadınız")
            val ad = readLine()!!.toString()
            println("Yaşınız")
            val yas = readLine()!!.toInt()
            println("Emailiniz")
            val email = readLine()!!.toString()
            if (dogruad==ad && dyas==yas && demail==email){
                println("Kaydınız oluşturulmuştur")
            }else{
                println("Kaydınız oluşmamıştır")
            }


        }catch (ex:Exception){
            println("Hatalı giriş yaptınız")
        }
    }











}