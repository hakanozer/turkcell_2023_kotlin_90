import java.io.File

fun main() {
    print("Aranacak kelimeyi girin: ")
    val aranacakKelime = readLine()

    if (aranacakKelime != null) {
        print("Klasör yolunu girin: ")
        val klasorYolu = readLine()

        if (klasorYolu != null) {
            val klasor = File(klasorYolu)
            if (klasor.exists() && klasor.isDirectory) {
                val sonuc = araDosyalari(klasor, aranacakKelime)
                if (sonuc.isNotEmpty()) {
                    for (dosya in sonuc) {
                        println("Dosya Adı: ${dosya.name}")
                        println("Klasör: ${dosya.parentFile}")
                        println("Boyut: ${formatlayarakBoyutuGoster(dosya.length())}\n")
                    }
                    println("Toplam ${sonuc.size} dosya bulundu.")
                } else {
                    println("Hiç dosya bulunamadı.")
                }
            } else {
                println("Belirtilen klasör bulunamadı veya geçersiz.")
            }
        } else {
            println("Klasör yolu girilmedi.")
        }
    } else {
        println("Aranacak kelime girilmedi.")
    }
}

fun araDosyalari(klasor: File, kelime: String): List<File> {
    val sonuc = mutableListOf<File>()

    if (klasor.isDirectory) {
        val dosyalar = klasor.listFiles()
        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isFile) {
                    if (dosya.name.contains(kelime, ignoreCase = true)) {
                        sonuc.add(dosya)
                    }
                } else if (dosya.isDirectory) {
                    sonuc.addAll(araDosyalari(dosya, kelime))
                }
            }
        }
    }
    return sonuc
}

fun formatlayarakBoyutuGoster(byte: Long): String {
    val kilobyte = 1024
    val megabyte = kilobyte * 1024
    val gigabyte = megabyte * 1024
    val terabyte = gigabyte * 1024

    return when {
        byte < kilobyte -> "$byte B"
        byte < megabyte -> "%.2f KB".format(byte.toDouble() / kilobyte)
        byte < gigabyte -> "%.2f MB".format(byte.toDouble() / megabyte)
        byte < terabyte -> "%.2f GB".format(byte.toDouble() / gigabyte)
        else -> "%.2f TB".format(byte.toDouble() / terabyte)
    }
}