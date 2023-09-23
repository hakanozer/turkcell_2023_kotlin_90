package com.example.sefasatilogluodev_1

class Ucgen {

    fun ucgenOl(kenar1:Int,kenar2: Int,kenar3: Int) {

        if (kenar1 + kenar2 >= kenar3 && kenar1 + kenar3 >= kenar2 && kenar2 + kenar3 >= kenar1) {
                println("Bu bir ucgendir.")
            }else {
                println("Bu bir ucgen degildir")
            }

        }

    }