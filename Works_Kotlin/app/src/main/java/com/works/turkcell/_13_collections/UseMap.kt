package com.works.turkcell._13_collections

fun main(args: Array<String>) {

    // arrayof
    val arr = arrayOf("Ali", "Bilmem", "ali@mail.com")
    println(arr)

    // Map immutable
    val map = mapOf<String, Any>("name" to "Ali", "surname" to "Bilmem", "age" to 23 )
    println(map)

    // Map mutable
    val note = Note()
    note.name = "Serkan"
    val bilirimx = "Bilirim"
    val mp = mutableMapOf<String, Any>()
    mp.put("name", "Kemal")
    mp.put("surname", bilirimx)
    mp.put("age", 23)
    mp.put("email", "kemal@mail.com")
    mp.put("email", "kemal1@mail.com")
    mp.put("status", true)
    mp.put("note", note)

    // size
    println( mp.size )

    val itemName = mp.get("name")
    println(itemName)

    // replace
    mp.replace("email", "kemal20@mail.com")

    // mp.clear()

    // all keys
    val keys = mp.keys
    for ( key in keys ) {
        println("$key -  ${mp.get(key)}")
    }

    // all Vals
    val vals = mp.values
    for ( item in vals ) {
        println(item)
    }

    println("==============================")
    // loop
    mp.forEach { k, v ->
        println("$k - $v")
    }

    // key control
    val emailStatus = mp.containsKey("email")
    println(emailStatus)

    val bilirim = "Bilirim"
    val surnameValStatus = mp.containsValue(bilirim)
    println(surnameValStatus)
    println("==============================")
    val note1 = Note()
    note1.name = "Kemal"
    val hash1 = note.hashCode()
    val hash2 = note1.hashCode()
    println(hash1)
    println(hash2)
    println({note1.hashCode()})
    val noteStatus = mp.containsValue(note)
    println("Note Status : $noteStatus")

    val newMap =  mp.filter {
       // it -> it.value.toString().contains("a")
        it -> it.value !is Note && it.value !is Int && it.value.toString().contains("a")
    }
    println(newMap)
    println(mp)

}