
fun main(args: Array<String>) {
    println("Büyük Küçük Sorgusuna Hoşgeldiniz")
    println("2 adet sayı gireceksiniz.")

    print("1. Sayı: ")
    val sayi1 = readLine()!!.toInt()

    print("2. Sayı: ")
    val sayi2 = readLine()!!.toInt()

    val buyukSayi = if (sayi1 > sayi2) sayi1 else sayi2
    val kucukSayi = if (sayi1 < sayi2) sayi1 else sayi2

    val sonuc = if (buyukSayi != kucukSayi) {
        "Büyük sayı: $buyukSayi\nKüçük sayı: $kucukSayi"
    } else {
        "Sayılar eşittir."
    }

    println(sonuc)
}