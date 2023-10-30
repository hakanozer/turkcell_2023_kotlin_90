fun main(args: Array<String>) {
    val metinListesi = listOf(
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.  ",
        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature,",
        "Contrary",
        "There are many variations of passages of Lorem Ipsum available, but the"
    )
    val metinlerisirala = metinListesi.sortedBy { it.length }
    val kısametin = metinlerisirala.first()
    val uzunmetin = metinlerisirala.last()
    println("En kısa metin: $kısametin")
    println("En uzun metin: $uzunmetin")
}

