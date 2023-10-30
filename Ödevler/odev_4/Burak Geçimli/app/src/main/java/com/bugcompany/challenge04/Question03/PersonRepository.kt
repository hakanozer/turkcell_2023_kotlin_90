package com.bugcompany.challenge04.Question03

class PersonRepository {
    private val kisiler = ArrayList<Person>()

    fun tumKisileriGetir(): List<Person> {
        return kisiler
    }

    fun kisiEkle(person: Person) {
        kisiler.add(person)
        println("Yeni kayıt başarıyla eklendi")
    }

    fun kisiSil(id: Int) {
        if (kisiler.removeIf { it.id == id }) {
            println("Kayıt başarıyla silindi")
        } else {
            println("Böyle bir kayıt bulunamadı")
        }
    }

    fun kisiGuncelle(id: Int, kisi: Person) {
        val index = kisiler.indexOfFirst { it.id == id }
        if (index != -1) {
            kisiler[index] = kisi
            println("Kayıt başarıyla güncellendi")
        } else {
            println("Böyle bir kayıt bulunamadı")
        }
    }

    fun tumunuTemizle() {
        kisiler.clear()
        println("Liste başarıyla temizlendi")
    }

    fun kisiAra(arananKisi: String): List<Person> {
        return kisiler.filter { it.name.contains(arananKisi, true) || it.surname.contains(arananKisi, true) }
    }

    fun kisiAraTelefon(arananKisiTel: String): List<Person> {
        return kisiler.filter { it.phoneNumber.contains(arananKisiTel) }
    }
}