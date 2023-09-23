fun main(args: Array<String>) {
    print("Kaç sayı girmek istiyorsunuz? ")
    val n = readLine()!!.toInt()

    val sayilar = Array(n) { 0 }
    for (i in 0 until n) {
        print("$i+1. sayı: ")
        val sayi = readLine()!!.toInt()
        sayilar[i] = sayi
    }

    println("Sayı girişi tamamlandı.")
    println("Sayılar: $sayilar")
    println("En büyük sayı: ${sayilar.maxOrNull()}")
    println("En küçük sayı: ${sayilar.minOrNull()}")
    println("Ortalama sayı: ${sayilar.average()}")
}