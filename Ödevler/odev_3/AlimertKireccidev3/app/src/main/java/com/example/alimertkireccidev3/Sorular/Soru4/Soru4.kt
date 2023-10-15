import java.io.File

fun main(args: Array<String>) {
    val dosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\dump.txt"

    // Dosyayı Burada Okuyacağız!!
    val kaynakDosya = File(dosyaYolu)

    if (!kaynakDosya.exists()) {
        println("$dosyaYolu bulunamadı.")
        return
    }

    val icerik = kaynakDosya.readText()

    // Satır Ve Kelime Sayısını Burada Hesapladım!!
    val satirSayisi = icerik.lines().size
    val kelimeSayisi = icerik.split(Regex("\\s+")).size

    // Harf sayısını ve sesli ,sessiz harf sayısını burada Hesapladım!!
    val harfSayisi = icerik.replace(Regex("[^a-zA-Z]"), "").length
    val sessizHarfSayisi = icerik.replace(Regex("[aeiouAEIOU]"), "").length
    val sesliHarfSayisi = harfSayisi - sessizHarfSayisi

    // Bilgileri konsola yazdırın
    println("Dosyadaki satır sayısı==.$satirSayisi")
    println("Dosyadaki Kelime Sayısı==.$kelimeSayisi")
    println("Dosyadaki harf sayısı== $harfSayisi")
    println("Sessiz harf sayısı== $sessizHarfSayisi")
    println("Sesli harf sayısı== $sesliHarfSayisi")
}

