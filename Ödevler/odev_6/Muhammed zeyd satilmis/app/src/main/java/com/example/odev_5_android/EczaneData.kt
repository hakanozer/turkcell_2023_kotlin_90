package com.example.odev_5_android

class EczaneData {
    val eczaneMap = EczaneResult().gaziAntepEczaneList()
    val eczaneList = mutableListOf<String>()

    fun eczaneConvertToList(): List<String> {
        try {
            eczaneMap.forEach {
                var ilce = it.key.replace("YAZDIR", "")
                ilce = ilce.trim()
                val adres = it.value.joinToString(System.lineSeparator())
                eczaneList.add(ilce)
                eczaneList.add(adres)
            }
        } catch (ex: Exception) {
            println("Exception: $ex")
        }

        return eczaneList

    }
}
