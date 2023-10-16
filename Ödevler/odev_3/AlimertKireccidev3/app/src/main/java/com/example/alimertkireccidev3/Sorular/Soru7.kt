import java.io.File
fun main(args: Array<String>) {
    val  Dosyanınuzantısı = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump.txt"
    val Dosyakaynagı = File(Dosyanınuzantısı)
    if (!Dosyakaynagı.exists()) {
        println("$Dosyanınuzantısı Yol Bulunamadı!!!!")
        return
    }
    val Icerikkaynagi = Dosyakaynagı.readText()
    val kelimeler = Icerikkaynagi.split(Regex("\\s+"))
    val Kelimeüzeriislemler = mutableMapOf<String, Int>()
    for (kelime in kelimeler) {
        val Yeridegistirilmis = kelime.replace(Regex("[^a-zA-Z]"), "")
        if (Yeridegistirilmis.isNotEmpty()) {
            Kelimeüzeriislemler[Yeridegistirilmis] = Kelimeüzeriislemler.getOrDefault(Yeridegistirilmis, 0) + 1
        }
    }
    val Encokgecenkelime = Kelimeüzeriislemler.maxBy { it.value }?.key
    val Encokgecenkelimesayisi = Kelimeüzeriislemler.maxBy { it.value }?.value
    val enuzunkelime = kelimeler.maxBy { it.length }
    val enkisakelime = kelimeler.minBy { it.length }
    println("Verilern Kelimerkin Tekrar sayıları:")
    for ((kelime, sayi) in Kelimeüzeriislemler) {
        println("$kelime: $sayi")
    }
    println("En çok Kullanılan kelime: $Encokgecenkelime, $Encokgecenkelimesayisi kez geçti.")
    println("En uzun kelime: $enuzunkelime, ${enuzunkelime.length} harf.")
    println("En kısa kelime: $enkisakelime, ${enkisakelime.length} harf.")
}
