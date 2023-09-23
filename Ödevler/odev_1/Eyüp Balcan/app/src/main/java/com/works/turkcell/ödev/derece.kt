
fun main(args: Array<String>) {
    println("Menu:")
    println("1 - F -> C")
    println("2 - C -> F")
    println("Seçim: ")

    val secim = readLine()!!

    when (secim) {
        "1" -> {
            println("Derece giriniz :")
            val f = readLine()!!.toFloat()

            val c = (f - 32) * 5 / 9

            println("$f F = $c C")
        }
        "2" -> {
            println("Derece giriniz :")

            val c = readLine()!!.toFloat()

            val f = c * 9 / 5 + 32

            println("$c C = $f F")
        }
        else -> {
            println("Yanlış menü seçimi 1 veya 2 numaralarını tuşlayınız.")
        }
    }
}
