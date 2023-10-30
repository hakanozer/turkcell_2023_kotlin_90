fun main(args: Array<String>) {
    val Sayılar = listOf(3,5,8,7,9,8,74,7,21,54)

    val siraliSayilar = Buyuktenkucugesıralama(Sayılar)

    println("RastgeleSeçilenSayılar: $Sayılar")
    println("Sıralanan Sayılar: $siraliSayilar")
}
fun Buyuktenkucugesıralama(sayilar: List<Int>): List<Int> {
    return sayilar.sortedDescending()//BU İbare büyükten kuçuğe sıralamak yazdım.
}