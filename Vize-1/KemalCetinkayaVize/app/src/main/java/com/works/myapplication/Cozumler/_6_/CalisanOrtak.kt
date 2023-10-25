package com.works.myapplication.Cozumler._6_

open class CalisanOrtak(var normalMaas : Int,var ekSaatUcret : Int,) {

    fun toplamMaas(ekSaat:Int):Int{
        val toplamMaasi = normalMaas +ekSaat*ekSaatUcret
        return toplamMaasi
    }

}