fun main(args: Array<String>) {
    val Veriler = listOf(7, null, "ali", 115, null, "steril", null)

    val Filitrenen = Filtrelielemanlar(Veriler)

    println("Null olmayan elemanlar: $Filitrenen")
}



fun Filtrelielemanlar(Verilerilistele: List<Any?>): List<Any> {
    return Verilerilistele.filterNotNull()
}