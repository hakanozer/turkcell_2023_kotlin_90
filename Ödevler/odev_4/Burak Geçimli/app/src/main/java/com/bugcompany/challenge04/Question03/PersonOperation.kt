package com.bugcompany.challenge04.Question03


class PersonOperation {
    private val repository = PersonRepository()

    fun menu() {
        while (true) {
            val menu = """
    ------------------------------------------------------   
    1 - Tüm Kayıtları Göster
    2 - Yeni Kayıt Ekle
    3 - Kayıt Sil
    4 - Kayıt Güncelle
    5 - Tümünü Temizle
    6 - Kayıt Ara (Ad veya Soyada Göre)
    7 - Kayıt Ara (Telefon Numarasına Göre)
    8 - Çıkış
    -------------------------------------------------------
""".trimMargin()
            println(menu)

            val secim = try {
                readLine()!!.toInt()
            } catch (e: Exception) {
                -1
            }

            when (secim) {
                1 -> println(repository.tumKisileriGetir())
                2 -> {
                    print("Ad: ")
                    val ad = readLine()!!
                    print("Soyad: ")
                    val soyad = readLine()!!
                    print("Tel: ")
                    val tel = readLine()!!
                    val sonId = repository.tumKisileriGetir().lastOrNull()?.id ?: 0

                    repository.kisiEkle(Person(sonId + 1, ad, soyad, tel))
                }

                3 -> {
                    print("Silmek istediğiniz kaydın id'sini giriniz: ")
                    val id = readLine()!!.toInt()

                    repository.kisiSil(id)
                }

                4 -> {
                    print("Güncellemek istediğiniz kaydın id'sini giriniz: ")
                    val id = readLine()!!.toInt()
                    print("Yeni Ad: ")
                    val ad = readLine()!!
                    print("Yeni Soyad: ")
                    val soyad = readLine()!!
                    print("Yeni Tel: ")
                    val tel = readLine()!!

                    repository.kisiGuncelle(id, Person(id, ad, soyad, tel))
                }

                5 -> repository.tumunuTemizle()
                6 -> {
                    print("Aramak istediğiniz ad veya soyad bilgisini giriniz: ")
                    val aranan = readLine()!!

                    println(repository.kisiAra(aranan))
                }

                7 -> {
                    print("Aramak istediğiniz telefon numarasını giriniz: ")
                    val aranan = readLine()!!

                    println(repository.kisiAraTelefon(aranan))
                }

                8 -> break
                else -> println("Hatalı seçim!")
            }
        }
    }
}