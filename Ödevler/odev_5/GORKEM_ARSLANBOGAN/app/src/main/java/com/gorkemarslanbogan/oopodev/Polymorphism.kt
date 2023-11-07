package com.gorkemarslanbogan.oopodev

//Polymorphism çok biçimlilik anlamına gelir aynı isimdeki metodun farklı işleri yapmasına polymorphism denir.
//base class'ta oluşturulan metodun derived class'ta farklı bir işi yapmasına çok biçimlilik denir.
// poliymorfizm kod tekrarını önleyen önemli bir yöntemdir. modüler bir yapı sunar kodun bakımı geliştirilme
//süreçleri daha rahat ve daha kısa sürede yönetilmesine olanak verir..
//kodların test edilebilmesi daha kolay olur.

private interface IFilm {
    fun watchMovie()
}

open class Film : IFilm {
    override fun watchMovie() {
        println("İnsanlar boş zamanlarını değerlendirmek için film izlerler.")
    }
}

class KorkuFilmi(val yas: Int) : Film() {
    override fun watchMovie() {
        if(yas < 18) {
            println("Çocukların korku filmi izleme uygun değildir..")
        }else {
            println("Korku Filmi izleyebilirsiniz..")
        }
    }
}


class CizgiFilm() : Film(){
    override fun watchMovie() {
        println("Çocuklar genellikle çizgi film izlerler")
    }
}

fun main() {
    val korkuFilmi = KorkuFilmi(21)
    val korkuFilmi2 = KorkuFilmi(12)
    val cizgiFilm = CizgiFilm()
    val filmler: List<Film> = listOf(korkuFilmi, cizgiFilm, korkuFilmi2)
    for (film in filmler) {
        film.watchMovie()
    }
}