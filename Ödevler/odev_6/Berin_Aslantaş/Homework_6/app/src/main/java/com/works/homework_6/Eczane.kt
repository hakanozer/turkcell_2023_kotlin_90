package com.works.homework_6

data class Eczane (val locationName: String?, val eczaneInfo: String?) {
    fun isValid(): Boolean {
        return !locationName.isNullOrBlank() && !eczaneInfo.isNullOrBlank()
    }
}
