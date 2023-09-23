fun main(args: Array<String>) {
    print("N değerini girin: ")
    val n = readLine()!!.toInt()

    val toplam = (n * (n + 1)) / 2

    println("1'den $n'e kadar olan sayıların toplamı: $toplam")
}