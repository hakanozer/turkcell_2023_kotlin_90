package com.works.turkcell_odevler.giris


import java.lang.Math.sqrt
import java.util.Scanner

@Suppress("UNREACHABLE_CODE")
class Turkcell_Odevler {


//    1 - Parametre olarak aldığı sayıyı
//    asal mı diye kontrol edip,
//    sayı asal ise true, değilse false döndüren
//    isPrime methodunu yazın

    fun isPrime(n1: Int): Boolean {

        var sonuc = true
        if (n1 >= 2) {
            for (i in 2 until n1) {
                if (n1 % i == 0) {
                    sonuc = false
                    break
                }
            }
        } else {
            sonuc = false
        }
        print(sonuc)

        return sonuc
    }

//    2 - Parametre olarak 2 int sayı alan,
//    bu sayilarin (ilki hariç, 2.si dahil olmak
//    üzere) toplamlarını döndüren bir method
//    yazın


    fun soru2(n1: Int, n2: Int): Int {
        var sonuc = 0
        if (n2 > n1 && n2 > 0) {
            for (i in n1 + 1..n2) {
                sonuc += i
            }
        } else {
            throw NumberFormatException("Lütfen 2. sayisi 1. sayidan büyük giriniz!")
        }
        print(sonuc)
        return sonuc
    }


//    3 - Parametre olarak 2 int sayi alan (a,b),
//    ilk sayi tek ise a/b'yi,
//    ilk sayi çift ise a%b'yi double olarak
//    döndüren bir method yazın

    fun soru3(a: Int, b: Int): Double {
        var sonuc = 0.0
        try {
            if (b == 0) {
                throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")

            } else if (a % 2 !== 0) {
                sonuc = (a / b).toDouble()
            } else {
                sonuc = (a % b).toDouble()
            }

        } catch (e: Exception) {

        }
        println(sonuc)
        return sonuc
    }


//    4 - parametre olarak verilen long sayisinin
//    rakamlarinin toplamını döndüren methodu
//    yazin

    fun soru4(n1: Long): Int {
        var sonuc = 0
        var donusturucu = n1.toString()
        for (i in donusturucu) {
            if (i.isDigit()) {
                // Eğer karakter bir rakam ise (0-9 arasındaysa)
                sonuc += i.digitToInt()
            }
        }
        println(sonuc)
        return sonuc
    }


//    5 - parametre olarak verilen kg ve boy (double)
//    değerlerinden BMI'yi hesaplayip double
//    olarak döndüren methodu yazın

    fun soru5(kg: Double, boy: Double): String {
        if (kg < 0.0 || boy <= 0.0) {
            throw IllegalArgumentException("Kilo ve boy pozitif değerler olmalıdır.")
        }
        val sonuc = kg / (boy * boy)
        val sonucMetni: String

        if (sonuc < 18.5) {
            sonucMetni = "Zayıf"
        } else if (sonuc >= 18.5 && sonuc <= 24.9) {
            sonucMetni = "Normal"
        } else if (sonuc >= 25.0 && sonuc <= 29.9) {
            sonucMetni = "Fazla Kilolu"
        } else {
            sonucMetni = "Obez"
        }

        println("VKİ Sonucu: $sonucMetni")
        println("VKİ Değeri: $sonuc")

        return sonucMetni
    }


//    6 - parametre olarak verilen int sayinin
//    tersten yazilmiş halini int olarak döndüren
//    bir method yazin

    fun soru6(n1: Int): Int {
        var sonuc = 0

        sonuc = n1.toString().reversed().toInt()

        println(sonuc)
        return sonuc
    }

//    7 - parametre olarak verilen int sayinin
//    palindrome olup olmadığını test eden
//    sonucu boolean olarak döndüren  bir method
//    yazın
//
//    palindrome : düz ve ters yazılışı aynı
//    olan şeyler örn :
//    1441 <--> 1441
//    ata <--> ata
//    1223221 <--> 1223221


    fun soru7(num: Int): Boolean {
        var ilkhal = num.toString()
        var ters: String

        ters = num.toString().reversed()
        println("Girilen say:$num")
        println("Çevirilen sayı: $ters")
        var durum = ters == ilkhal

        if (durum) {
            println("Palindorom bir sayıdır")
        } else {
            println("Palindrom değildir.")
        }
        println(durum)
        return durum
    }

    //    8 - parametre olarak verilen int[] deki
//    en büyük ve en küçük sayının toplamını
//    int olarak döndüren method yazın
    fun soru8(dizi: IntArray): Int {
        var toplam = 0
        if (!dizi.isEmpty()) {
            val enBuyuk = dizi.maxOrNull() ?: 0
            // ?: simgesi sol taraf null ise sağ taraftakini verir
            val enKucuk = dizi.minOrNull() ?: 0
            toplam = enBuyuk + enKucuk
        }


        println(toplam)
        return toplam
    }


//    9 - parametre olarak bir int[]ve bir sayi
//    alan, eğer array sayiyi içeriyorsa true,
//    içermiyorsa false döndüren bir method yazin


    fun soru9(dizi: IntArray, sayi: Int): Boolean {
        for (i in dizi) {
            if (i == sayi) {
                println("Dizide istediğiniz sayı bulunuyor")
                return true
            }
        }

        println("Dizide istediğiniz sayı bulunmuyor")
        return false
    }

//    10 - kullanıcıdan 4 tane int değer alan,
//    ve en büyük olan değeri geri döndüren bir
//    method yazın

    fun soru10(n1: Int, n2: Int, n3: Int, n4: Int): Int? {
        val dizi: IntArray = intArrayOf(n1, n2, n3, n4)
        var sonuc = dizi.maxOrNull()

        // Dizi üzerinde işlem yapılabilir

        return sonuc
    }

//    11 - kullanıcıdan iki int[] değer alan
//    bu arraylerdeki ortak elemanların
//    sayısını döndüren bir method yazın


    fun soru11(dizi1: IntArray, dizi2: IntArray): IntArray? {
        val sonucdizi = mutableListOf<Int>()

        for (i in dizi1) {
            for (j in dizi2) {
                if (i == j) {
                    sonucdizi.add(i)
                }
            }
        }

        if (sonucdizi.isEmpty()) {
            println("Hİç eşleşme yok")
            return null
        } else {
            println(sonucdizi)
            return sonucdizi.toIntArray()
        }
    }

//    12 - bir sayıyı sıfıra bölmeye çalışırken
//    karşılaşılan bir hata durumunu ele almak için
//    nasıl bir try-catch bloğu oluşturursunuz? (Sefa Satiloglu)


    fun soru12(bolunen: Int, bolen: Int): Double {
        try {
            if (bolen == 0) {
                throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")
            }

            return bolunen.toDouble() / bolen
        } catch (e: ArithmeticException) {
            println("Hata: ${e.message}")
        }
        return 0.0 // Eğer hata oluşursa 0.0 döndürülür.
    }


//    13 - kullanıcıdan bir sayi alan ve bu sayıyı
//    ekrana gösteren bir değer alın girilen değerin
//    sayı olup olmadığın try-cath ile kontrol edip
//    hata yönetimini sağlayın. (Görkem Arslanboğan)


    fun soru13() {
        try {
            val scanner = Scanner(System.`in`)
            print("Bir sayı girin: ")
            val girdi = scanner.nextInt()

            val sayi = girdi.toInt()

            println("Girilen sayı: $sayi")
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir sayı girmediniz.")
        }
    }


//    14- İki tam sayıyı bölen bir method yazın ve
//    bölenin sıfır olma durumunu try-catch bloğu ile ele alın.
//    Eğer bölen sıfır ise "Bölme işlemi sıfıra bölünemez."
//    şeklinde bir hata mesajı döndürsün.
//    Aksi takdirde sonucu döndürsün. (Eyüp Balcan)

    fun soru14(bolen: Int, bolunen: Int): Double {
        try {
            if (bolen == 0) {
                throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")
            }

            return bolunen.toDouble() / bolen
        } catch (e: ArithmeticException) {
            println("Hata: ${e.message}")
        }
        return 0.0 // Eğer hata oluşursa 0.0 döndürülür.
    }
//
//    15- Kullanıcıdan iki değer alan ve bu değerlerin ortalamasını hesaplayıp
//    ekrana bastıran bir metod yazın.Eğer girilen inputlardan birisi integer
//    değilse "Lütfen integer değerler giriniz." diye uyarı ekrana bastırsın ve method
//    input almaya baştan başlasın. (Çağatay Çınar Lökçe)


    fun soru15() {
        try {
            val scanner = Scanner(System.`in`)
            print("Bir sayı girin: ")
            val sayi1 = scanner.nextInt().toInt()
            print("Bir sayı girin: ")
            val sayi2 = scanner.nextInt().toInt()

            println("$sayi1 -- $sayi2")

            println("Girilen sayılar: $sayi1 --- $sayi2")
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir sayı girmediniz.")
        }
    }


//    16-Girilen 2 String ifadenin  karakter sayılarını karşıllaştıran ve eşit değilse
//    "Karakter sayıları uyuşmuyor"
//    uyarısı veren Try-catch alıştırması yapınız.(Çağdaş Alıngan)


    fun soru16(str1: String, str2: String) {
        try {
            if (str1.length != str2.length) {
                throw IllegalArgumentException("Karakter sayıları uyuşmuyor")
            }
            println("Karakter sayıları uyuşuyor")
        } catch (e: IllegalArgumentException) {
            println("Hata: ${e.message}")
        }
    }


//    17- Bir kullanıcıdan alınan metin verisini tamsayıya
//    dönüştüren bir kotlin prgoramı yazınız. (Keremcan Karakaya)


    fun soru17() {
        println("Metini girin: ")
        val metin = readLine()

        try {
            // ?. null güvenliği
            val tamsayi = metin?.toInt()

            if (tamsayi != null) {
                println("Girilen tamsayı: $tamsayi")
            } else {
                println("Geçerli bir tamsayı girilmedi.")
            }
        } catch (e: Exception) {
            println("Hata: Geçerli bir tamsayı girilmedi.")
        }
    }

//    18- Kullanıcıdan alınan 2 verinin çarpımını bulan bir program yazınız.
//    Verilerin integer olmaması durumunu try-catch
//    bloğu ile kontrol ediniz. (Davut Karakuş)


    fun soru18() {
        try {

            val scanner = Scanner(System.`in`)
            print("Bir sayı girin: ")
            val sayi1 = scanner.nextInt().toInt()
            print("Bir sayı girin: ")
            val sayi2 = scanner.nextInt().toInt()
            val sonuc = (sayi1.toInt() * sayi2.toInt())

        } catch (e: Exception) {
            println("Sayılar integer değil")
        }

    }

//    19- Kullanıcıdan dört basamaklı bir sayı alınız.
//    Alınan sayının 2 ile bölümünden kalanın sıfır olup olmadığını
//    try-catch ile kontrol eden bir program yazınız.(Hatice Kılıç)

    fun soru19() {

        //try hatalarını çözümleyemediğim için "IllegalArgumentException" kullandım
        try {
            val scanner = Scanner(System.`in`)
            print("4 basamaklı bir sayı giriniz: ")
            val girilenSayi = scanner.next()

            if (girilenSayi.length != 4) {
                throw Exception("Lütfen 4 basamaklı bir sayı girin.")
            }

            val sayi = try {
                girilenSayi.toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("Lütfen geçerli bir sayı girin.")
            }

            if (sayi % 2 == 0) {
                println("Girdiğiniz sayı çifttir.")
            } else {
                println("Girdiğiniz sayı çift değildir.")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

//    20-kullanıcıdan ,0 ile 20 arasından
//    5 sayı seçin sayıların tek mi çift mi olduğunu bulunuz,
//    Bulduğunuz sayıların tek ve çift olanların aritmetik ortalamasını ayrı ayrı bulunuz,
//    Try Catch İle Doğrulayın.(Ali Mert Kireçci)


    fun soru20() {
        try {

            val scanner = Scanner(System.`in`)
            val ciftSayilar = mutableListOf<Int>()
            val tekSayilar = mutableListOf<Int>()


            print("0-20 arası bir 5 adet sayı giriniz.")
            for (i in 1..5) {
                val girilenSayi = scanner.nextInt()


                if (girilenSayi < 0 || girilenSayi > 20) {
                    throw Exception("Geçerli sayı giriniz.")

                }

                if (girilenSayi % 2 == 0) {
                    ciftSayilar.add(girilenSayi)
                } else {
                    tekSayilar.add(girilenSayi)
                }
            }

            println("Çift Sayılar: ${ciftSayilar.joinToString(", ")}")
            println("Tek Sayılar: ${tekSayilar.joinToString(", ")}")

            println("Çift sayı sayısı: ${ciftSayilar.size}")
            println("Tek sayı sayısı: ${tekSayilar.size}")
        }catch (e: Exception){
            println(e.message)

        }

    }



//    21- Kullanıcıdan bir listenin boyutunu ve elemanlarını tamsayılar
//    ile doldurmasını isteyin.Geçersiz boyut ve eleman girişini
//    Try-catch yapısı ile kontrol edin.Ve listenin çift indeksteki ve tek indeksteki
//    tamsayıların toplamını yazdırın.(Burak Geçimli)


    fun soru21() {
        val scanner = Scanner(System.`in`)

        print("Listenin boyutunu giriniz: ")
        val boyut = scanner.nextInt()

        val liste = mutableListOf<Int>()

        for (i in 1..boyut) {
            try {
                print("Listeye eklemek istediğiniz tam sayıyı giriniz: ")
                val girilenSayi = scanner.next()
                val tamSayi = girilenSayi.toInt()

                liste.add(tamSayi)
            } catch (e: NumberFormatException) {
                println("Hatalı giriş! Lütfen bir tam sayı giriniz.")
            }
        }

        println("Girilen Liste: $liste")
    }




    //    22-Mükemmel sayıları bulan bir try-catch algoritması yazınız.(Furkan Akı)
    fun hesaplaMukemmelSayi() {
        try {
            print("Lütfen pozitif bir sayı giriniz: ")
            val girilenSayi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş")

            if (girilenSayi < 0) {
                throw IllegalArgumentException("Negatif giriş yapılamaz")
            }

            val bolenlerinToplami = (1 until girilenSayi).filter { girilenSayi % it == 0 }.sum()

            val sonuc = if (bolenlerinToplami == girilenSayi) "Mükemmel bir sayıdır" else "Mükemmel bir sayı değil"
            println("$girilenSayi: $sonuc")

        } catch (e: Exception) {
            println("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: Exception) {
            println("Hata: Negatif sayı girişi yapılamaz.")
        }
    }


//    23- Try catch kullanarak kullanıcının girdiği bir
//    sayının karekökünü hesaplayan program yazınız.
//    Negatif sayı girilmediğinden emin olunuz.(Büşra Tutku Özdemir)


    fun soru23() {
        try {
            print("Karekökünü hesaplamak istediğiniz pozitif bir sayı girin: ")
            val sayi = readLine()?.toDouble() ?: throw Exception("Geçersiz giriş!")

            if (sayi < 0) {
                throw IllegalArgumentException("Negatif bir sayının karekökü hesaplanamaz!")
            }
            // sqrt fonksiyonunu kullanarak karekök hesaplıyormuş :)
            val karekok = sqrt(sayi)
            println("Girdiğiniz sayının karekökü: $karekok")
        } catch (e: NumberFormatException) {
            println("Hata: Geçersiz bir sayı girdiniz.")
        } catch (e: Exception) {
            println("Hata: Negatif bir sayı girişi yapılamaz.")
        }
    }
//    24- Kullanıcıdan 3 basamaklı sayılar isteyiniz
//    ve bu sayılardan armstrong sayısı bulan bir algoritma
//    olusturunuz ve verilerin sayı girilmesini de Try catch
//    yapısı ile kontrolünü sağlayınız.(Kemal Çetinkaya)


    fun soru24() {
        val scanner = Scanner(System.`in`)



    }
//    25- Kullanıcıdan pozitif bir tam sayı alınız ve
//    bu sayının faktöriyelini hesaplayınız. Kullanıcı metin veya
//    negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz. (Mehmet Şahin)


    fun soru25(): Int {
        try {
            print("Bir tam sayı girin: ")
            val sayi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")

            if (sayi < 0) {
                throw Exception("Negatif bir sayı girişi yapılamaz!")
            }

            var faktoriyel: Long = 1
            for (i in 2..sayi) {
                faktoriyel *= i.toLong()
            }
            return faktoriyel.toInt()
        } catch (e: NumberFormatException) {
            println("Hata: Geçersiz bir giriş yaptınız. Lütfen pozitif bir tam sayı girin.")
        } catch (e: Exception) {
            println("Hata: Negatif bir sayı girişi yapılamaz. Lütfen pozitif bir tam sayı girin.")
        }
        return -1 //
    }


//    26 - Kullanıcıdan yaşını girmesini talep ederek sayı girmesini bekleyiniz.
//    Girilen yaşa göre kullanıcının ehliyet alabilip alamayacağını kullanıcıya bildiriniz.
//    Eğer kullancı ehliyet alacak yaşta değilse kaç sene
//    sonra ehliyet alabileceğini kullanıcıya bildiriniz.
//    Örnek senaryoda ehliyet alabilme yaşını 18 olarak kabul edelim ve kullanıcı, yaşını 16 olarak girsin.
//    Bu durumda beklenen çıktı "Maalesef ehliyet alacak yaşta değilsiniz,
//    2 yıl sonra ehliyet almaya hak kazanabilirsiniz!" olacaktır.
//    (Girilen değerin sayısal bir değer ve yaş olabilitesi kontrol edilmelidir.) (Umutcan EMEK)


    fun soru26() {
        try {
            print("Yaşınızı girin: ")
            val yas = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")

            if (yas < 0) {
                throw IllegalArgumentException("Negatif yaş girişi yapılamaz!")
            }

            val ehliyetYasi = 18

            if (yas >= ehliyetYasi) {
                println("Ehliyet alabilirsiniz.")
            } else {
                val sene = ehliyetYasi - yas
                println("Maalesef ehliyet alacak yaşta değilsiniz, $sene yıl sonra ehliyet almaya hak kazanabilirsiniz.")
            }
        } catch (e: NumberFormatException) {
            println("Hata: Geçersiz bir yaş girdiniz. Lütfen pozitif bir yaş girin.")
        } catch (e: IllegalArgumentException) {
            println("Hata: Negatif yaş girişi yapılamaz. Lütfen pozitif bir yaş girin.")
        }
    }


//    27- Sizden buraya kaçıncı soruyu yazdığınızı örnek olarak girmeniz isteniyor.
//    Geçersiz bir sayı veya karakter girildiğinde hata mesajı bastırınız
//    ve kaçıncı soruyu yazdığınızın yeniden girilmesini sağlayınız.
//    (soru sayısını 50 olarak alabilirsiniz.) (Berin Aslantaş)

    fun soru27() {
        try {
            println("Lütfen 0 ile 50 arası bir tam sayı girin ")
            val soru = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz")
            if (soru !in 1..50) {
                throw Exception("0 ile 50 arası bir sayı girin!")
            }
            println("$soru. soruyu girdiniz ")
        } catch (e: Exception){
            println(e.message)
        }

    }

//    28- Kullanıcıdan ‘ Lys  ’ puanını girmesini isteyin. Girilen puan aralığını kontrol edin.
//    Puanı 400-430 arasında ise ‘ Mühendislik Fakültesi’ne yerleşebilirsiniz ’ , değilse ‘ Üzülme, Vazgeçme ! 😊
//    ’mesajını ekrana basın. Ve Finally ile ‘ İşlem Tamamlandı ’ mesajını yazdırın.
//    ( Kullanıcıdan alınan değerin 0, null ve String olma durumlarını kontrol edin )  ( ESMA SALKIM )

    fun soru28() {
        try {
            var lys = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz")
            if(lys >= 0 && lys<=500){
                if (lys >=400 && lys<=430) println("Mühendislik kazandınız") else ("Üzülme vazgeçme")
            }else throw NumberFormatException("Girilen puan doğru değil.")

        }catch (e: Exception){
            println(e.message)
        }finally {
            println("İşlem Tamamlandı")
        }

    }

//    29-Bir Quiz uygulaması geliştirin bir soru sorun doğru cevap verince tebrik mesajı ,
//    yanlış cevap verince hata mesajı versin. ( Oğuz Baran Şahingil)
    fun soru29() {
    val scanner = Scanner(System.`in`)
    val soru = "Kotlin kaç yılında çıkmıştır?"
    val soruCevap = "2011"
    println("$soru")
    try {
        val cevap = scanner.nextLine()
        if (soruCevap.equals(cevap)) {
            println(" Doğru !")
        }else {
            println("Yanlış!")
        }
    }catch (e:Exception) {
        println(" Gecerli metin  giriniz!")
    }
    }




//    30- Kullanıcıdan, ad soyad, yaş ve mail istediğiniz 3 değer alınız.
//    Try catch yapısını kullanarak, mailin doğru yazılılıp yazılmadığını,
//    ad ve soy adı birleştirip küçükterek kullanıcı adı oluşturmayı ve yaş 18 ve üzeri girildiyse
//    bilgileri listeleyip kaydı tamamlayınız aksi takdirde kayıt kabul edilmesin. (Muhammed Zeyd Satılmış)

    fun soru30() {
        val scanner = Scanner(System.`in`)
        println("Adınız :")
        val name = scanner.nextLine();
        println("Yaşınız :")
        val age = scanner.nextLine();
        println("Mailiniz :")
        val mail = scanner.nextLine();
        try {
            val ageInt = age.toInt()
            if (ageInt < 18) {
                throw Exception("Yaşınız 18 yaşından küçük.")
            }
//            val username = name.lowercase().replace(" ", "")
//
//            println("Kullanıcı Adı: $username")
//            println("Ad: $name")
//            println("Yaş: $ageInt")
//            println("E-posta: $mail")
//            println("Kayıt başarıyla tamamlandı.")

        } catch (e: NumberFormatException) {
            println("Hata: Yaş için geçerli bir tam sayı girilmedi.")
        } catch (e: IllegalArgumentException) {
            println("Hata: ${e.message}")
        }
    }
}


