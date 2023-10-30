fun main(args: Array<String>) {
    val isim = setOf("Ali", "Veli", "Selim", "Ekber", "Saadet")
    val Sebze = listOf("turp", "acur", "salatalık", "biber")
    val liste1 = mutableListOf<String>()
    isim.forEach { element ->
        if (!liste1.contains(element)) {
            liste1.add(element)
        }
    }
    Sebze.forEach { element ->
        liste1.add(element)
    }
    println("Şimdi Birleşmi Hal: $liste1")
}