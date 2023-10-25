package com.works.turkcell.vize1

import com.works.turkcell._15_inheritance.Base


fun main(args: Array<String>) {

    val memur = Memur ()
    val mudur = Mudur ()
    val genelMudur = GenelMudur()

    val calismaSaati = 100

    call(memur)
    call(mudur)
    call(genelMudur)

    fun call ( obj: Base){
        obj.call()

    }


}