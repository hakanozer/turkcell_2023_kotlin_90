fun main(args: Array<String>) {
    print("3 Basamaklı Sayı Girin: ")
    val sayi = readLine()!!.toInt()

    if( sayi.toString().length == 3)
    {
        val basamaklar = sayi.toString().split("")

        val tersSayi = basamaklar.reversed().joinToString("")

        println("Ters sayı: $tersSayi")


    }else println("3 basamaklı girmediniz")



}