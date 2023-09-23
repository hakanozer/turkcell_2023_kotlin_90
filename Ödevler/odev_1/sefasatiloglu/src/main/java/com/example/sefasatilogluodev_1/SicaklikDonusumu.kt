package com.example.sefasatilogluodev_1

class SicaklikDonusumu {

    fun donusturF(fahrt:Double) : Double {
        val fahrenhiet = (fahrt*1.8) + 32
        return fahrenhiet
    }
    fun donusturC(derece:Double) : Double {
        val drc = (derece-32) / 1.8
        return drc
    }
}