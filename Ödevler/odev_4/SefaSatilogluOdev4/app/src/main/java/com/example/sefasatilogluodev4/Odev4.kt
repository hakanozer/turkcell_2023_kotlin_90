package com.example.sefasatilogluodev4

import java.math.BigInteger
import java.util.Random
import java.util.Scanner

fun main() {
    println("**************************1.SORU**************************************************")
    //1. 1-49 Arası, 6 Farklı Sayı Seçip Gösterecek Bir Uygulama Yapın

    val random = Random()
    for (i in 1..6) {
        val altiSayi = random.nextInt(49)
        println(altiSayi)
    }
    println("**************************2.SORU**************************************************")
    //2. 2 Tane Çok Uzun String Değeriniz Var Bu İki Sayiyi Toplayacak Bir Uygulama Yazın
    //String a  = "23456789876543234567890987654567890";
    //String b =  "99999999999988888888882222222688981";
    var a = "23456789876543234567890987654567890"
    var b =  "99999999999988888888882222222688981"

    val aSayisi = BigInteger(a)
    val bSayisi = BigInteger(b)

    val toplam = aSayisi+bSayisi
    println("Toplam :$toplam")
    /*
    3. Kisi Diye Bir Nesneniz Olsun Ve ad, soyad, tel Özellikleri Olsun

    Uygulamanızda Kullanıcıya Aşağıdaki Menuyu Göstereceksiniz :

    1 - Tüm Kayıtları Göster
    2 - Yeni Kayıt Ekle
    3 - Kayıt Sil
    4 - Kayıt Güncelle
    5 - Tümünü Temizle
    6 - Kayıt Ara (Ad veya Soyada Göre)
    7 - Kayıt Ara (Telefon Numarasına Göre)
    8 - Çıkış


    Uygulamanız Sonsuz Döngü İçerisinde Yukarıdaki Menüyü Gösterecek
    Kullanıcı 1-8 Dışında Bir Değer Girerse, Hatalı Seçim Diye Mesaj Gösterip Tekrar Menuyu
    Gösterecek

    Kisi Instance'larını Bir List'te Tutacaksınız. Ve Bu ArrayList Üzerinde Çalışacaksınız.
     */
    println("**************************3.SORU**************************************************")
    val girdi = Scanner(System.`in`)
    val array = arrayListOf<Kisi>()
    val yeniKisi = Kisi()
    while (true) {
        println("""
            
    1 - Tüm Kayıtları Göster
    2 - Yeni Kayıt Ekle
    3 - Kayıt Sil
    4 - Kayıt Güncelle
    5 - Tümünü Temizle
    6 - Kayıt Ara (Ad veya Soyada Göre)
    7 - Kayıt Ara (Telefon Numarasına Göre)
    8 - Çıkış
    """.trimIndent())
        println()
        print("Lutfen Secim Yapiniz")
        val secim = girdi.nextInt()

        if (secim == 1) {
            yeniKisi.kayitlariGoster(array)
            Thread.sleep(3000)

        }
        else if (secim == 2) {
            println("Yeni Kisi Eklemeyi Sectiniz!")
            Thread.sleep(1000)
            print("Ad:")
            val ad = girdi.next()
            print("Soyad:")
            val soyad = girdi.next()
            print("Tel-No:")
            val telNo = girdi.next()
            array.add(Kisi(ad,soyad,telNo))
            println("Bir saniye ekleniyor...")
            Thread.sleep(2000)
            println("Kisi basariyla listeye eklendi!")
            Thread.sleep(1000)
        }
        else if (secim == 3) {
            println("Kimi Silmek İstiyorsunuz? \n Liste Asagidadir")
            Thread.sleep(2000)
            yeniKisi.kayitlariGoster(array)
            print("Silmek istediginiz kisinin sirasini yazmaniz yeterlidir")
            val silme = girdi.nextInt()
            println("$silme. Kisi Siliniyor... ")
            Thread.sleep(4000)
            println("Silme islemi tamamlandi!")
            Thread.sleep(1000)
            array.removeAt(silme-1)


        }
        else if (secim == 4) {
            println("Kayit Güncelle Secildi")
            Thread.sleep(2000)

            println("Liste Asagida biraz sonra listelenecek;")
            Thread.sleep(2000)
            yeniKisi.kayitlariGoster(array)
            println("Lütfen güncellemek istediginiz kisiyi seciniz:")
            val kisiSec = girdi.nextInt()
            print("Ad:")
            val ad = girdi.next()
            print("Soyad:")
            val soyad = girdi.next()
            print("Tel-No:")
            val telNo = girdi.next()
            array.set(kisiSec-1, Kisi(ad,soyad,telNo))
            println("Güncelleme yapiliyor...")
            Thread.sleep(3000)
            println("Güncelleme Basariyla Tamamlandi!")
            Thread.sleep(2000)

        }
        else if (secim == 5) {
            println("Tümünü Temizle Secildi")
            Thread.sleep(2000)
            println("Listeniz temizleiyor...")
            Thread.sleep(3000)
            println("Son 3 saniye")
            Thread.sleep(3000)
            println("Listeniz Temizlendi")
            Thread.sleep(1000)
            yeniKisi.temizleListeyi(array)

        }
        else if (secim == 6) {
            println("Kayıt Ara (Ad veya Soyada Göre) Secildi")
            Thread.sleep(2000)
            print("Aranacak Kisi (Ad veya Soyad) Giriniz:")
            val arananKelime = girdi.next()
            val kisiBulma = array.filter { (it.ad.contains(arananKelime,ignoreCase = true ) || (it.soyad.contains(arananKelime,ignoreCase = true )))}
            if(kisiBulma.isEmpty()) {
                println("Aranan isim veya soyadına göre kimse bulunamadi!")
            }else {
                println("Aranan isim veya soyad ile eslesen kisiler ")
                Thread.sleep(3000)
                for ((index,kisi) in kisiBulma.withIndex()) {
                    println("""
                        ${index+1}.Kisi 
                        Ad:${kisi.ad}
                        Soyad:${kisi.soyad}
                        Tel-No:${kisi.telNo}
                        ********************
                        """.trimIndent())

                }
            }
        }
        else if (secim == 7) {
            println("Kayıt Ara (Telefon Numarasına Göre) Secildi")
            Thread.sleep(2000)
            print("Aranacak Kisi Telefon Numarasini Giriniz:")
            val arananTelefon = girdi.next()
            val kisiBulma = array.filter { it.telNo.contains(arananTelefon,ignoreCase = true) }
            if(kisiBulma.isEmpty()) {
                println("Aranan Telefon Numarasina Göre kimse bulunamadi!")
            }else {
                println("Aranan Telefon numarası ile eslesen kisiler ")
                Thread.sleep(3000)
                for ((index,kisi) in kisiBulma.withIndex()) {
                    println("""
                        ${index+1}.Kisi 
                        Ad:${kisi.ad}
                        Soyad:${kisi.soyad}
                        Tel-No:${kisi.telNo}
                        *******************
                        """.trimIndent())
                }
                Thread.sleep(2000)
            }
        }
        else if (secim == 8) {
            println("Cikis Yapiliyor...")
            Thread.sleep(5000)
            println("Cikis Yapildi!")
            break
        }else {

            println("Hatali Tuslama Yaptiniz!")

        }
    }
    println("**************************4.SORU**************************************************")
    //4. Bir Kotlin List oluşturun ve bu listede bulunan elemanları ekrana yazdırmak için bir döngü kullanarak her elemanı dolaşan bir program yazın.
    val list = listOf<String>("sefa","turkcell","cevdet","satiloglu","liste","elemanlarini","tek","tek","yazdirma","dongu","kullanarak")
    for (listeDorduncu in list)
    {
        println(listeDorduncu)
    }
    println("**************************5.SORU**************************************************")
    //5. Bir Set ve bir List oluşturun. Set'teki benzersiz elemanları, List'teki sırayla bulunan elemanları koruyarak birleştirin.
    // Sonuçta nasıl bir koleksiyon elde edersiniz, bunu ekrana yazdırın.

    val set = mutableSetOf(1,2,3,4,5,6)
    val listBesinci = listOf(4,5,6,7,8,9)
    set.addAll(listBesinci)
    println(set)
    println("**************************6.SORU**************************************************")
    //6. Verilen bir List içinde belirli bir değerin kaç kez tekrarlandığını hesaplayan bir Kotlin işlevi yazın.
    val listeAltinci = listOf(1,2,2,2,4,4,4,5,5,1,1,1,1,2,6,7,8,9,5,5,5,5,5,1,1,1,1,1,1)
    val tekrarlananlar = listeAltinci.filter{
        elemanlariSayma -> listeAltinci.count() {it == elemanlariSayma } > 1
    }.toSet()
    println(tekrarlananlar)
    println("**************************7.SORU**************************************************")
    //7. İçinde çeşitli yaşları bulunduran bir List oluşturun. Bu yaşları gruplayarak yaş gruplarını içeren bir Map oluşturun.
    // Örneğin, "18-24" yaş aralığındaki kişileri bir grup olarak tutun.
    val yasListesi = arrayListOf<Int>(0,6,12,34,67,85,25,21,18,16,3,45,50,31,9,45,24,19,20)
    val yasMaps = mutableMapOf<String,List<Int>>()

    val cocukGrup = yasListesi.filter { it in 0..12 }
    yasMaps["Cocuk"] = cocukGrup
    val gencGrup = yasListesi.filter { it in 18..30 }
    yasMaps["Genc"] = gencGrup
    val ortaYasGrup = yasListesi.filter { it in 32..50 }
    yasMaps["Orta Yas"] = ortaYasGrup
    val yasliGrup = yasListesi.filter { it>60 }
    yasMaps["Yasli"] = yasliGrup
    println(yasMaps)
    println("**************************8.SORU**************************************************")
    //8. Bir List'teki tüm elemanların toplamını hesaplayan bir Kotlin işlevi yazın. Ayrıca, bu işlevin sadece pozitif sayıları dikkate almasını sağlayın.
    val sayilariTopla = arrayListOf<Int>(-20,10,12,43,54,122,567,-22,-80,45,350,600,-1000,2500,23,27,81,-10,55)
    var total = 0
    println(sayilariTopla.size)
    for (i in sayilariTopla) {
        if (i>0) {
            total+=i

        }

    }
    println("Toplam : $total")
    //9. Bir List içinde null değerler de dahil olmak üzere karmaşık veriler bulunduğunu varsayalım.
    // Bu verileri filtreleyerek null olmayan elemanları yeni bir List'e ekleyen bir işlev yazın.
    println("**************************9.SORU**************************************************")
    val karisikListe = listOf(null,12,"ahmet","sefa",15,7,null,"Hello",null,null,null,"Deneme","Cevdet",27,null,"Gaziantep",null)
    val nullOlmayanListe = mutableListOf<Any>()
    for (i in karisikListe) {
        if (i !=null) {
            nullOlmayanListe.add(i)
        }
    }
    println("Null Olmayan Liste: $nullOlmayanListe")
    println("**************************10.SORU**************************************************")
    //10. İçinde metin içeren bir List oluşturun. Bu metinleri uzunluğuna göre sıralayarak en kısa ve en uzun metinleri bulun.
    val metinListesi = arrayListOf("Merhaba","Sefa","Ahmet","Cevdet")
    val siraliMetin = metinListesi.sortedBy { it.length }
    println(siraliMetin)
    val kisaMetin = siraliMetin.first()
    println("En kisa metin: $kisaMetin")
    val uzunMetin = siraliMetin.last()
    println("En uzun metin: $uzunMetin")

    println("**************************11.SORU**************************************************")
    //11. Bir List içinde rastgele sayılar bulunsun. Bu sayıları büyükten küçüğe sıralayarak sıralama işlemini gerçekleştiren bir Kotlin işlevi yazın.

    val randomList = arrayListOf<Int>()
    for (i in 1..30) {
        randomList.add(random.nextInt(50))

    }
    val buyuktenKucuge = randomList.sorted().reversed()
    println(buyuktenKucuge)

    //12. İki Set'i karşılaştırarak, her iki Set'in de içinde bulunan ortak elemanları bulan bir Kotlin programı yazın.
    println("**************************12.SORU**************************************************")
    val aSet = mutableSetOf<Int>(1,2,3,4,5,6,7,8)
    val bSet = setOf<Int>(6,7,8,9,10,11,12)
    val ortakEleman = aSet.intersect(bSet) // intersect methodu ortak elemanlari bulur. iki set arasinda
    println("İki Set Arasinda Ortak Elemanlar: $ortakEleman")




}