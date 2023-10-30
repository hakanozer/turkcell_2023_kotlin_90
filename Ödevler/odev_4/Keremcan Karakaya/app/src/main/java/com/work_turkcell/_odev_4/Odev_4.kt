package com.work_turkcell._odev_4
import java.math.BigInteger
import java.util.Random

//1
class RastgeleSayilar {
    private val random = Random()
    fun olustur(altiSayi: Int): List<Int> {
        val sayilar = mutableListOf<Int>()
        for (i in 0 until altiSayi) {
            val sayi = random.nextInt(49) + 1
            if (!sayilar.contains(sayi)) {
                sayilar.add(sayi)
            }
        }
        return sayilar
    }
}

//2
class Topla {
    val string: String
    constructor(string: String) {
        this.string = string
    }
    fun rakamlariAl(): List<BigInteger> {
        return string.split("[^0-9]").map { it.toBigInteger() }
    }
    fun toplaminiAl(): BigInteger {
        return rakamlariAl().sumOf { it }
    }
}

//3
class Kisi(
    val ad: String,
    val soyad: String,
    val tel: String
)
fun kisilerDuzenle(kisiler: MutableList<Kisi>) {
    println("**Tüm Kayıtlar**")
    kisiler.forEach { println(it) }
}
fun kisiEkle(kisiler: MutableList<Kisi>) {
    println("**Yeni Kayıt Ekle**")
    val ad = readLine()
    val soyad = readLine()
    val tel = readLine()
    kisiler.add(Kisi(ad ?: "", soyad ?: "", tel ?: ""))
}
fun kisiSil(kisiler: MutableList<Kisi>) {
    println("**Kayıt Sil**")
    val id = readLine()?.toIntOrNull()
    if (id != null) {
        kisiler.removeAt(id - 1)
    }
}
fun kisiGuncelle(kisiler: MutableList<Kisi>) {
    println("**Kayıt Güncelle**")
    val id = readLine()?.toIntOrNull()
    if (id != null) {
        val kisi = kisiler[id - 1]

        val ad = readLine()?.trim() ?: ""
        val soyad = readLine()?.trim() ?: ""
        val tel = readLine()?.trim() ?: ""

        val yeniKisi = Kisi(ad, soyad, tel)
        kisiler[id - 1] = yeniKisi
    }
}
fun kisiAra(kisiler: MutableList<Kisi>) {
    println("**Ad veya Soyada Göre Arama**")
    val aranan = readLine()?.trim() ?: ""
    val kisilerListesi = kisiler.filter { it.ad.contains(aranan) || it.soyad.contains(aranan) }
    kisilerListesi.forEach { println(it) }
}
fun kisiTelAra(kisiler: MutableList<Kisi>) {
    println("**Telefon Numarasına Göre Arama**")
    val aranan = readLine()
    val kisilerListesi = kisiler.filter { it.tel == aranan }
    kisilerListesi.forEach { println(it) }
}


//4
class Liste(private val elemanlar: List<String>) {
    fun gez() {
        for (eleman in elemanlar) {
            println(eleman)
        }
    }
}

//5
class Birlesim {
    fun birlestir(set: Set<Int>, list: List<Int>): List<Int> {
        val birlesimKoleksiyonu = set.toMutableSet()
        birlesimKoleksiyonu.addAll(list)
        return birlesimKoleksiyonu.toList()
    }
}

//6
class ListeIslemleri {
    fun tekrarSay(liste: List<Int>, hedefDeger: Int): Int {
        return liste.count { it == hedefDeger }
    }
}

//7
class YasGruplandirici {
    private val yasAraliklari = listOf(
        18..24,
        25..34,
        35..44,
        45..54
    )
    fun grupla(yaslar: List<Int>): Map<String, List<Int>> {
        return yaslar.groupBy { yas ->
            yasAraliklari.find { it.contains(yas) }?.toString() ?: "Belirsiz"
        }
    }
}

//8
class PozitifSayiToplayici(private val say: List<Int>) {
    fun pozitifSayilariTopla(): Int {
        return say.filter { it > 0 }.sum()
    }
}

//9
class NullEtmeyenEkle<T> {
    fun nullEtmeyenleriEkle(liste: List<T>, yeniListe: MutableList<T>) {
        liste.forEach {
            if (it != null) {
                yeniListe.add(it)
            }
        }
    }
}

//10
class Metin {
    val metin: String
    constructor(metin: String) {
        this.metin = metin
    }
    fun uzunluguBul(): Int {
        return metin.length
    }
}

//11
class BuyuktenKucuge(private val liste: List<Int>) {
    fun siralaBuyuktenKucuge(): List<Int> {
        return liste.sortedDescending()
    }
}

//12
class SetOrtakElemanlar{
    fun <T> ortakElemanlariBul(set1: Set<T>, set2: Set<T>): Set<T> {
        val ortakElemanlar = mutableSetOf<T>()
        for (eleman in set1) {
            if (set2.contains(eleman)) {
                ortakElemanlar.add(eleman)
            }
        }
        return ortakElemanlar
    }
}

fun main(args: Array<String>) {
//1
    val rastgele = RastgeleSayilar()
    val sayilar = rastgele.olustur(6)
    println(sayilar)

//2
    val a = Topla("23456789876543234567890987654567890")
    val b = Topla("99999999999988888888882222222688981")
    val toplam = a.toplaminiAl() + b.toplaminiAl()
    println(toplam)


//3
    val kisiler = mutableListOf<Kisi>()
    while (true) {
        println("**Kişi Listesi**")
        println("1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        val secim = readLine()?.toIntOrNull()
        if (secim == null || secim !in 1..8) {
            println("Hatalı seçim!")
            continue
        }
        when (secim) {
            1 -> kisilerDuzenle(kisiler)
            2 -> kisiEkle(kisiler)
            3 -> kisiSil(kisiler)
            4 -> kisiGuncelle(kisiler)
            5 -> kisiler.clear()
            6 -> kisiAra(kisiler)
            7 -> kisiTelAra(kisiler)
            8 -> break
        }
    }

//4
    val liste = Liste(listOf("Kerem", "Murat", "Ali", "Hasan", "Burak"))
    liste.gez()

//5
    val set = setOf(1, 2, 3, 4, 5, 7)
    val listt = listOf(1, 2, 3, 4, 5, 6, 9, 12)
    val birlesim = Birlesim()
    val sonuc = birlesim.birlestir(set, listt)
    println(sonuc)

//6
    val listee = listOf(1, 2, 3, 4, 2, 1, 2, 5, 2, 6)
    val hedefDeger = 2
    val listeIslemleri = ListeIslemleri()
    val tekrarSayisi = listeIslemleri.tekrarSay(listee, hedefDeger)
    println("$hedefDeger değeri liste içinde $tekrarSayisi kez tekrarlanıyor.")


//7
    val yaslar = listOf(19, 20, 23, 27, 30, 35, 40, 45, 50, 60)
    val yasGruplanmis = YasGruplandirici().grupla(yaslar)
    println(yasGruplanmis)


//8
    val say = listOf(9, -8, 17, -21, 80, 15, -87, 122)
    val toplayici = PozitifSayiToplayici(say)
    val pozitifToplam = toplayici.pozitifSayilariTopla()
    println("Pozitif Sayıların Toplamı: $pozitifToplam")


//9
    val list = listOf(1, null, 3, 4, null)
    val yeniListe = mutableListOf<Int?>()
    val nullEtmeyenEkle = NullEtmeyenEkle<Int?>()
    nullEtmeyenEkle.nullEtmeyenleriEkle(list as List<Int?>, yeniListe)
    println(yeniListe)


//10
    val metinler = listOf(
        Metin("Merhaba kotlin"),
        Metin("Yarın İstanbul'a gideceğim"),
        Metin("Okulumu seviyorum"),
        Metin("Futbol en sevdiğim spordur")
    )
    val siralanmisMetinler = metinler.sortedBy { it.uzunluguBul() }
    val enKisaMetin = siralanmisMetinler.first()
    val enUzunMetin = siralanmisMetinler.last()
    println("En kısa metin: ${enKisaMetin.metin}")
    println("En uzun metin: ${enUzunMetin.metin}")


//11
    val rastgeleSayilar = List(10) { (0..100).random() }
    println("Rastgele Sayılar: $rastgeleSayilar")
    val buyuktenKucuge = BuyuktenKucuge(rastgeleSayilar)
    val siralanmisListe = buyuktenKucuge.siralaBuyuktenKucuge()
    println("Büyükten Küçüğe Sıralanmış Liste: $siralanmisListe")


//12
    val set1 = setOf(2, 6, 3, 4, 5)
    val set2 = setOf(5, 8, 4, 3, 9)
    val ortakElemanlar = SetOrtakElemanlar().ortakElemanlariBul(set1, set2)
    println(ortakElemanlar)
}
