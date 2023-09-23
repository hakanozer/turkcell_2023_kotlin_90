fun main(args: Array<String>) {
    print("3 Basamaklı Sayı Girin: ")
    val sayi = readLine()!!.toInt()

    if( sayi.toString().length == 3)
    {
        val yuzBasamagi = sayi / 100
        val onBasamagi = sayi % 100 / 10
        val birBasamagi = sayi % 10
        val toplam = yuzBasamagi + onBasamagi + birBasamagi
        println("Sayının basamaklarının toplamı: $toplam")


    }else println("3 basamaklı girmediniz")



}