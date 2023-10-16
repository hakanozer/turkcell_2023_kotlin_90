import java.io.File
fun klasordearanan(klasor: File, arananKelime: String, bulunanDosyalar: ArrayList<DosyaBilgisi>) {
    val dosyalar = klasor.listFiles()
    if (dosyalar != null) {
        for (dosya in dosyalar) {
            if (dosya.isFile) {
                if (dosya.name.contains(arananKelime,  true)) {
                    val dosyaBilgisi = DosyaBilgisi(dosya.name, klasor.absolutePath, dosya.length())
                    bulunanDosyalar.add(dosyaBilgisi)
                }}
            else if (dosya.isDirectory) {
                klasordearanan(dosya, arananKelime, bulunanDosyalar)
            }}}}
fun main(args: Array<String>) {
    val scanner = java.util.Scanner(System.`in`)
    print("Aranacak kelimeyi girin: ")
    val arananKelime = scanner.nextLine()
    print("Klasör yolunu girin: ")
    val klasorYolu = scanner.nextLine()
    val klasor = File(klasorYolu)
    if (!klasor.exists() || !klasor.isDirectory) {
        println("Yol Veya Klasör Hatalı!!!")
        return
    }
    val varolandosylar = ArrayList<DosyaBilgisi>()
    klasordearanan(klasor, arananKelime, varolandosylar)
    if (varolandosylar.isEmpty()) {
        println("Kelime İçeren Dosyada Hata Var!!")
    } else {
        println("Arama  ${varolandosylar.size} dosya bulundu:")
        for (dosya in varolandosylar) {
            println("Dosya Adını Giriniz: ${dosya.ad}")
            println("Klasör Adı==: ${dosya.klasor}")
            println("Boyut bytes türünfen==: ${dosya.boyut} bytes")
        }}}
data class DosyaBilgisi(val ad: String, val klasor: String, val boyut: Long)