fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3, 4, 2, 6, 2, 8, 2, 10,10,10,40,40)
    val Tekraredensayıgiriniz = 40//Buradaki Sayı Listede kaç tane tekrar eden sayıyı buldurur

    val Listedekikarar = tekRAR(numbers, Tekraredensayıgiriniz)

    println("Liste içinde $Tekraredensayıgiriniz, $Listedekikarar kez tekrarlandı.")

}
fun tekRAR(list: List<Int>, tekrar: Int): Int {
    var baslangic = 0
    for (element in list) {
        if (element == tekrar) {
            baslangic++
        }
    }
    return baslangic
}