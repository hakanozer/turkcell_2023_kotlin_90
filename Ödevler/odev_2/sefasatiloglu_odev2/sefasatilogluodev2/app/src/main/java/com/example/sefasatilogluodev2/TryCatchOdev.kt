package com.example.sefasatilogluodev2

import android.bluetooth.le.ScanCallback
import java.util.Scanner
import kotlin.math.pow

fun main() {
    /*
    12 - bir sayıyı sıfıra bölmeye çalışırken karşılaşılan bir hata durumunu ele almak için nasıl bir try-catch bloğu oluşturursunuz? (Sefa Satiloglu)
     */
    println("************************12.SORU**********************************************")
    val sayi = 10
    val sayi1 = 0

    try {
        val sonuc = sayi / sayi1
        println("Sonuc: $sonuc")
    }catch (e:Exception) {
        println("Sıfır bölünmez!")
    }
    /*
    13 - kullanıcıdan bir sayi alan ve bu sayıyı ekrana gösteren bir değer alın girilen değerin sayı olup olmadığını
        try-cath ile kontrol edip hata yönetimini sağlayın. (Görkem Arslanboğan)
     */
    println("************************13.SORU**********************************************")

    try {
        val girdi = Scanner(System.`in`)
        println("Lutfen sayi giriniz:")
        val sayi2 = girdi.nextInt()
        println(sayi2)

    }catch (e:Exception) {
        println("Lutfen Sayi Giriniz!")
    }
    /*

    14- İki tam sayıyı bölen bir method yazın ve
        bölenin sıfır olma durumunu try-catch bloğu ile ele alın.
        Eğer bölen sıfır ise "Bölme işlemi sıfıra bölünemez." şeklinde bir hata mesajı döndürsün.
        Aksi takdirde sonucu döndürsün. (Eyüp Balcan)
     */
    println("************************14.SORU**********************************************")

    val hesaplama = sayiHesaplama(10.0,0.0)
    println(hesaplama)

    /*
    15- Kullanıcıdan iki değer alan ve bu değerlerin ortalamasını hesaplayıp
        ekrana bastıran bir metod yazın.Eğer girilen inputlardan birisi integer
        değilse "Lütfen integer değerler giriniz." diye uyarı ekrana bastırsın ve method
        input almaya baştan başlasın. (Çağatay Çınar Lökçe)
     */
    println("************************15.SORU**********************************************")
    ortalamaHesaplama()
    println("************************16.SORU**********************************************")
    /*
    16-Girilen 2 String ifadenin  karakter sayılarını karşıllaştıran ve eşit değilse
    "Karakter sayıları uyuşmuyor"
    uyarısı veren Try-catch alıştırması yapınız.(Çağdaş Alıngan)
     */
    try {
        val girdi = Scanner(System.`in`)
        println("Birinci Karakterinizi Giriniz:")
        val str1 = girdi.nextLine()
        println("İkinci Karakterinizi Giriniz:")
        val str2 = girdi.nextLine()
        if (str1.length != str2.length) {
            throw Exception("Karakterler Uyusmuyor")
        }
        else{
            println("Karakter Sayilari Uyusuyor.")
        }
    }catch (e:Exception) {

        println("${e.message}")
    }
    println("************************17.SORU**********************************************")
    /*
    17- Bir kullanıcıdan alınan metin verisini tamsayıya
    dönüştüren bir kotlin prgoramı yazınız. (Keremcan Karakaya)
     */
    val girdi = Scanner(System.`in`)
    println("Bir metin giriniz:")
    val str1 = girdi.nextLine()
    try {
        val changeInt = str1.toInt()
        println("Girdiginiz tam sayi $changeInt")
     }catch (e:NumberFormatException) {
         println("Lutfen tam sayi giriniz!")
     }
    println("************************18.SORU**********************************************")
    /*
    18- Kullanıcıdan alınan 2 verinin çarpımını bulan bir program yazınız.
    Verilerin integer olmaması durumunu try-catch
    bloğu ile kontrol ediniz. (Davut Karakuş)
     */

    try {
        println("birinci sayiyi giriniz:")
        val sayi3 = girdi.nextInt()
        println("ikinci sayiyi giriniz:")
        val sayi4 = girdi.nextInt()
        val carpmaIslemi = sayi3 * sayi4
        println("Sonuc: $carpmaIslemi")
    }catch (e:Exception) {
        println("Lutfen integer deger giriniz!")
    }
    println("************************19.SORU**********************************************")
    /*
    19- Kullanıcıdan dört basamaklı bir sayı alınız.
    Alınan sayının 2 ile bölümünden kalanın sıfır olup olmadığını
    try-catch ile kontrol eden bir program yazınız.(Hatice Kılıç)
     */
    println("Dört Basamakli Sayi Giriniz:")
    val girdi2 = Scanner(System.`in`)
    val num4 = girdi2.next()
    try {
        val num5 = num4.toInt()
        if (num4.length !=4) {
            println("Dört basamakli sayi giriniz")
        }
        if (num5 % 2 == 0) {
            println("Girdiginiz Sayinin 2 ile bölümünde kalan 0")
        }else {
            println("Girdiginiz Sayinin 2 ile bölümden kalan 0 Degildir!")
        }
    }catch (e:Exception) {
        println("Lutfen 4 basamakli sayi giriniz")
    }
    println("************************20.SORU**********************************************")
    /*
    20-kullanıcıdan ,0 ile 20 arasından 5 sayı seçin sayıların tek mi çift mi olduğunu bulunuz,
    Bulduğunuz sayıların tek ve çift olanların aritmetik ortalamasını ayrı ayrı bulunuz,
    Try Catch İle Doğrulayın.(Ali Mert Kireçci)
     */
    val girdi3 = Scanner(System.`in`)
    val tekSayilar = mutableListOf<Int>()
    val ciftSayilar = mutableListOf<Int>()
    while (tekSayilar.size + ciftSayilar.size <5) {
        println("Lutfen sayi giriniz (0-20) arasi:")
        try {
            val sayiAl = girdi3.nextInt()
            if (sayiAl in 0..20){
                if (sayiAl % 2 == 0) {
                    ciftSayilar.add(sayiAl)
                }else {
                    tekSayilar.add(sayiAl)
                }
            }else {
                println("Girdiginiz Sayi 0 ile 20 arasinda olmalidir!")
            }
        }catch (e:Exception) {
            println("Lutfen tamsayi giriniz")
            girdi3.next()
        }
    }
    val tekSayilarOrtalama = tekSayilar.average()
    println("Tek sayilarin aritmetik ortalamasi : $tekSayilarOrtalama")
    val ciftSayilarOrtalama = ciftSayilar.average()
    println("Cift Sayilarin aritmetik ortalamasi: $ciftSayilarOrtalama")
    println("************************21.SORU**********************************************")
    /*
    21- Kullanıcıdan bir listenin boyutunu ve elemanlarını tamsayılar
    ile doldurmasını isteyin.Geçersiz boyut ve eleman girişini
    Try-catch yapısı ile kontrol edin.Ve listenin çift indeksteki ve tek indeksteki
    tamsayıların toplamını yazdırın.(Burak Geçimli)
     */
    val scannerGirdi = Scanner(System.`in`)
    try {
        println("Listenin Boyutunu Giriniz:")
        val listeBoyut = scannerGirdi.nextInt()
        if (listeBoyut<0) {
            throw Exception("Gecersiz Liste Boyutu!")
        }
        val list = mutableListOf<Int>()
        println("Liste Elemanlarinizi Giriniz!")
        for (i in 0 until listeBoyut) {
            println("Eleman ${i+1}")
            val element = scannerGirdi.nextInt()
            list.add(element)
        }
        var ciftIndex = 0
        var tekIndex = 0

        for (i in list.indices) {
            if (i % 2 == 0){
                ciftIndex+=list[i]
            }else {
                tekIndex+=list[i]
            }
        }
        println("Cift Elemanlarin toplami :$ciftIndex")
        println("Tek Elemanlarin toplami :$tekIndex")
    }catch (e:Exception) {
        println("Gecerli Deger Giriniz!")
    }
    println("************************22.SORU**********************************************")
    /*
    22-Mükemmel sayıları bulan bir try-catch algoritması yazınız.(Furkan Akı)
     */

    try {
        println("Sayi Giriniz:")
        var toplam = 0
        val mukemmelSayi = girdi3.nextInt()
        for (i in 1 until mukemmelSayi)
            if (mukemmelSayi % i == 0) {
                toplam+=i

            }
        if (mukemmelSayi == toplam) {
            println("Mukemmel Sayidir")
        }else {
            println("Mukemmel Sayi Degildir!")
        }
    }catch (e:Exception) {
        println("Lutfen Tam Sayi Giriniz!")
    }
    println("************************23.SORU**********************************************")
    /*
    23- Try catch kullanarak kullanıcının girdiği bir
    sayının karekökünü hesaplayan program yazınız.
    Negatif sayı girilmediğinden emin olunuz.(Büşra Tutku Özdemir)
     */
    try {
        println("Sayi giriniz:")
        val kareKokBulma = girdi3.nextInt()
        if (kareKokBulma < 0) {
            println("Negatif sayi giremezsin!")
        }else {
            val sonuc = Math.pow(kareKokBulma.toDouble(),0.5)
            println(sonuc)
        }

    }catch (e:Exception) {
        println("Luffen tam sayi giriniz!")
    }
    println("************************24.SORU**********************************************")
    /*
    24- Kullanıcıdan 3 basamaklı sayılar isteyiniz
    ve bu sayılardan armstrong sayısı bulan bir algoritma
    olusturunuz ve verilerin sayı girilmesini de Try catch
    yapısı ile kontrolünü sağlayınız.(Kemal Çetinkaya)
     */
    val girdi4 = Scanner(System.`in`)
    try {
        println("Bir sayi giriniz:")
        val sayiArms = girdi4.next()
        val sayiChan = sayiArms.toInt()
        if (sayiArms.length != 3) {
            println("3 Basamakli Sayi Giriniz")
        }
        if (sayiChan < 0 ) {
            println("Negatif sayi giremezsin!")

        }
        var temp = sayiChan
        var toplam = 0
        val hesapla = sayiChan.toString().length
        while (temp>0) {
            val modAlma = temp % 10
            toplam+=modAlma.toDouble().pow(hesapla).toInt()
            temp/=10
        }
        val armstrongSayi = toplam == sayiChan
        if (armstrongSayi) {
            println("$sayiChan bir Armstrong Sayidir")
        }else {
            println("$sayiChan Armstrong bir sayi degildir!")
        }

    }catch (e:Exception) {
        println("Lutfen tam sayi giriniz!")
    }
    println("************************25.SORU**********************************************")
    /*
    25- Kullanıcıdan pozitif bir tam sayı alınız ve
    bu sayının faktöriyelini hesaplayınız. Kullanıcı metin veya
    negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz. (Mehmet Şahin)
     */
    val girdi5 = Scanner(System.`in`)
    try {
        println("Sayi giriniz:")
        val sayi5 = girdi5.nextInt()
        var fackt = 1
        var i = 1
        if (sayi5 >= 0) {
            while (i <= sayi5) {
                fackt*=i
                i++
            }
            println("Girdiginiz sayinin fakt!: $fackt")
        }else {
            println("Negatif sayi giremezsin!")
        }
    }catch (e:Exception) {
        println("Lutfen Tam Sayi Giriniz!")
    }
    println("************************26.SORU**********************************************")
    /*
    26 - Kullanıcıdan yaşını girmesini talep ederek sayı girmesini bekleyiniz.
    Girilen yaşa göre kullanıcının ehliyet alabilip alamayacağını kullanıcıya bildiriniz.
    Eğer kullancı ehliyet alacak yaşta değilse kaç sene
    sonra ehliyet alabileceğini kullanıcıya bildiriniz.
    Örnek senaryoda ehliyet alabilme yaşını 18 olarak kabul edelim ve kullanıcı, yaşını 16 olarak girsin.
    Bu durumda beklenen çıktı "Maalesef ehliyet alacak yaşta değilsiniz,
    2 yıl sonra ehliyet almaya hak kazanabilirsiniz!" olacaktır.
    (Girilen değerin sayısal bir değer ve yaş olabilitesi kontrol edilmelidir.) (Umutcan EMEK)
     */
    try {
        val girdi6 = Scanner(System.`in`)
        println("Yasinizi Giriniz:")
        val kullaniciYas = girdi6.nextInt()
        if (kullaniciYas < 18) {
            println("Ehliyet Alamazsiniz!")
            val ehliyetAlma = 18 - kullaniciYas
            println("$ehliyetAlma yil sonra ehliyetini alabilirsin.")
        }else {
            println("$kullaniciYas yasindasiniz. Ehliyet Alabilirsin.")
        }
    }catch (e:Exception) {
        println("Lutfen sayisal deger giriniz!")
    }
    println("************************27.SORU**********************************************")
    /*
    27- Sizden buraya kaçıncı soruyu yazdığınızı örnek olarak girmeniz isteniyor.
    Geçersiz bir sayı veya karakter girildiğinde hata mesajı bastırınız
    ve kaçıncı soruyu yazdığınızın yeniden girilmesini sağlayınız.
    (soru sayısını 50 olarak alabilirsiniz.) (Berin Aslantaş)
     */
    val girdi7 = Scanner(System.`in`)
    val soruSayisiMax = 50
    var soruSayisiMin = 1
    var soruSayisi : Int

    while (true) {

        try {

            println("Kacinci soruyu yazdiginizi giriniz! (1-50)")
            soruSayisi = girdi7.nextInt()
            if (soruSayisi in soruSayisiMin..soruSayisiMax) {
                break

            }else {
                println("Gecersiz soru sayisi!")
            }
        }catch (e:Exception) {
            println("Gecersiz deger! Lutfen sayisal deger giriniz!")
            girdi7.next()
        }

    }
    println("Girdiginiz soru numarasi: $soruSayisi")
    println("************************28.SORU**********************************************")
    /*
    28- Kullanıcıdan ‘ Lys  ’ puanını girmesini isteyin. Girilen puan aralığını kontrol edin.
    Puanı 400-430 arasında ise ‘ Mühendislik Fakültesi’ne yerleşebilirsiniz ’ , değilse ‘ Üzülme, Vazgeçme ! 😊
    ’mesajını ekrana basın. Ve Finally ile ‘ İşlem Tamamlandı ’ mesajını yazdırın.
    ( Kullanıcıdan alınan değerin 0, null ve String olma durumlarını kontrol edin )  ( ESMA SALKIM )
     */
    val girdi8 = Scanner(System.`in`)
    var lyspuan : Int?
    try {
        println("Lys puaninizi giriniz:")
        val lysPuan = girdi8.nextLine()
        if (lysPuan.isNullOrEmpty() || lysPuan.trim().toIntOrNull() == null) {
            println("Lutfen gecerli puan giriniz!")
        }else {
            lyspuan = lysPuan.toInt()
            if (lyspuan in 400..430) {
                println("Muhendislik  fakultesine yerlesebilirsiniz!")
            }else {
                println("Uzulme , Vazgecme! :) ")
            }
        }
    }catch (e:Exception) {
        println("Lutfen gecerli sayi giriniz!")
    }finally {
        println("İslem tamamlandi!")
    }
    println("************************29.SORU**********************************************")
    //29-Bir Quiz uygulaması geliştirin bir soru sorun doğru cevap verince tebrik mesajı , yanlış cevap verince hata mesajı versin. ( Oğuz Baran Şahingil)
    val girdi9 = Scanner(System.`in`)
    val quizSoru = "Hangi takimlisin?"
    val soruCevap = "Galatasaray"
    println("$quizSoru")
    try {
        val kullaniciCevap = girdi9.nextLine()
        if (soruCevap.equals(kullaniciCevap,ignoreCase = true)) {
            println("Tebrikler Doğru Bildiniz!")
        }else {
            println("Bilemedin!")
        }
    }catch (e:Exception) {
        println("Lutfen gecerli metin degeri giriniz!")
    }
    println("************************30.SORU**********************************************")
    /*
    30- Kullanıcıdan, ad soyad, yaş ve mail istediğiniz 3 değer alınız.
    Try catch yapısını kullanarak, mailin doğru yazılılıp yazılmadığını,
    ad ve soy adı birleştirip küçükterek kullanıcı adı oluşturmayı ve yaş 18 ve üzeri girildiyse
    bilgileri listeleyip kaydı tamamlayınız aksi takdirde kayıt kabul edilmesin. (Muhammed Zeyd Satılmış)
     */
    val girdi10 = Scanner(System.`in`)
    try {
        print("Adınız: ")
        val kullaniciAdi = girdi10.nextLine().trim().toLowerCase()

        print("Soyadiniz: ")
        val soyAdi = girdi10.nextLine().trim().toLowerCase()

        print("Yasiniz: ")
        val kullanicininYasi = girdi10.nextInt()

        girdi10.nextLine()

        print("E-posta adresiniz: ")
        val email = girdi10.nextLine().trim()
        if (!isValidEmail(email)) {
            throw Exception("Geçersiz e-posta adresi.")
        }

        if (kullanicininYasi < 18) {
            throw Exception("Yaşınız 18'den kucuk kaydiniz kabul edilmedi!")
            }

        val username = "$kullaniciAdi$soyAdi"

        println("\nKullanıcı Bilgileri:")
        println("Kullanıcı Adı: $username")
        println("E-posta: $email")
        println("Yaş: $kullanicininYasi")
    } catch (e: Exception) {
        println("Gecerli bir deger giriniz!")
        }


}
//14.Soru
fun sayiHesaplama(sayi1:Double,sayi2:Double) :String{

    try {
        val sonuc = sayi1.toInt()/ sayi2.toInt()
        return "Sonuc: $sonuc"
    }catch (e:Exception) {
       return "Bölme islemi sifira bölünemez!"
    }


}
//15.Soru
fun ortalamaHesaplama() {
    val girdi = Scanner(System.`in`)
    var sayi3 = 0
    var sayi4 = 0
    var kontol = false
    while (!kontol) {
        try {

            println("Sayi giriniz:")
            sayi3 = girdi.nextInt()
            println("ikinci sayiyi giriniz:")
            sayi4 = girdi.nextInt()
            kontol = true

        } catch (e: Exception) {
            println("Lütfen integer değerler giriniz.")
            girdi.nextLine()
        }
    }
    val ortalama = (sayi3 + sayi4) / 2
    println("Girilen iki sayinin ortalamasi:$ortalama")

}
//30.Soru
fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}