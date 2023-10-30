fun main(args: Array<String>) {
    val birinci = setOf(1, 2, 3, 4, 5,11,55,978,125)
    val ikinci = setOf(1,9,8,55,11,3, 4, 5, 6, 7)

    val ortakElemanlar = birinci.intersect(ikinci)

    if (ortakElemanlar.isNotEmpty()) {
        println("Ortak Elemanlar: $ortakElemanlar")
    } else {
        println("Ortak eleman bulunamadı.")
    }
}