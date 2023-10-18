package com.works.turkcell._17_interface

interface IUser {

    fun userLogin(email: String, password: String) : Boolean
    fun rememberPassword(email: String) : String
    fun userName( uid: Int ) : String

}