package com.works.turkcell._14_oop

class UserModel {

    private var name: String = ""
    private var surname: String = ""

    fun getName() : String {
        return this.name
    }

    fun setName( name: String ) {
        if (name.length > 255) {
            this.name = ""
        }else {
            this.name = name
        }
    }

    fun getSurname() : String {
        return this.surname
    }

    fun setSurname( surname: String ) {
        this.surname = surname
    }




}