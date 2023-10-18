package com.works.turkcell._17_interface

class User : IUser, IProfile {

    override fun userLogin(email: String, password: String): Boolean {
        return true
    }

    override fun rememberPassword(email: String): String {
        return "12345"
    }

    override fun userName(uid: Int): String {
        return "Ahmet Bilirler"
    }

    override fun userProfileImagePath(uid: Int): String {
        return "ali_02.jpg"
    }
}