package Ödev4

fun main(args: Array<String>) {
    val sayi = listOf(1, -2, 3, -4, 5, 6, -7, 8, 9, -10)
    val poztifsum = pozitifsay(sayi)
    println("Listedeki pozitif sayıların toplamı: $poztifsum")
}
fun pozitifsay(sayi: List<Int>): Int {
    var sum = 0
    for (sayi in sayi) {
        if (sayi > 0) {
            sum += sayi
        }
    }
    return sum
}