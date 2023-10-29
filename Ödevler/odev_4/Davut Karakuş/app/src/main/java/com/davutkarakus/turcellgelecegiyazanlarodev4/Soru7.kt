package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru7 {
    private fun yaslariGrupla(yasListesi: List<Int>): Map<String, List<Int>> {
        return yasListesi.groupBy {
            when (it) {
                in 0..17 -> "0-17"
                in 18..24 -> "18-24"
                in 25..34 -> "25-34"
                in 35..44 -> "35-44"
                in 45..54 -> "45-54"
                in 55..64 -> "55-64"
                else -> "65+"
            }
        }
    }
    fun gruplanmisYaslar() {
        val yaslar = listOf(15, 20, 23, 32, 40, 53, 60, 75, 10)
        val gruplanmisYaslar = yaslariGrupla(yaslar)
        println(gruplanmisYaslar)
    }
}