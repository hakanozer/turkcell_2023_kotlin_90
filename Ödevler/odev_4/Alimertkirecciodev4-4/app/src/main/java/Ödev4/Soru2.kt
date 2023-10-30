fun main() {
    val a = "23456789876543234567890987654567890"
    val b = "99999999999988888888882222222688981"

    val sum = addTwoNumbersAsLists(a, b)

    println("Toplam: $sum")
}

fun addTwoNumbersAsLists(a: String, b: String): String {
    val maxLength = maxOf(a.length, b.length)
    val result = MutableList(maxLength) { 0 }

    val reversedA = a.reversed()
    val reversedB = b.reversed()

    var carry = 0

    for (i in 0 until maxLength) {
        val digitA = if (i < reversedA.length) reversedA[i].toString().toInt() else 0
        val digitB = if (i < reversedB.length) reversedB[i].toString().toInt() else 0

        val total = digitA + digitB + carry
        result[i] = total % 10
        carry = total / 10
    }

    if (carry > 0) {
        result.add(carry)
    }

    return result.reversed().joinToString("")
}