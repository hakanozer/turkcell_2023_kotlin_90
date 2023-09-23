
fun main(args: Array<String>) {
    println("Üçgen Sorgusuna Hoşgeldiniz")
    println("3 adet kenar uzunluğu giriniz.")

    print("1. Kenar: ")
    val kenar1 = readLine()!!.toInt()

    print("2. Kenar: ")
    val kenar2 = readLine()!!.toInt()

    print("3. Kenar: ")
    val kenar3 = readLine()!!.toInt()

    val sonuc = if (isTriangle(kenar1, kenar2, kenar3)) {
        "Sonuç: Üçgen oluşturulabilir."
    } else {
        "Sonuç : Üçgen oluşturulamaz."
    }

    println(sonuc)
}

fun isTriangle(kenar1: Int, kenar2: Int, kenar3: Int): Boolean {
    return (kenar1 + kenar2 > kenar3) &&
            (kenar1 + kenar3 > kenar2) &&
            (kenar2 + kenar3 > kenar1)
}
