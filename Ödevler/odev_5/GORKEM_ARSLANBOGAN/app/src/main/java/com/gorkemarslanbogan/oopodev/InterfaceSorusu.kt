package com.gorkemarslanbogan.oopodev


//interfaceler bir veya birden fazla sınıfın interface içindeki metodları kullanabilmesine denir.
//sınıf arayüzle kalıtım edildiğinde ilgili fonksiyonun içini doldurmak zorundadır bunu tahahüt etmiştir.
//interfaceler daha temiz kod yazılması ve koda istenilen özelliklerin rahatça eklenip
//çıkarılabilmesine olanak sağlar daha dinamik bir kod ortaya çıkar
// ve çoklu kalıtımı destekler.
// çoklu interface kullanmka kodu esnek ve modüler ve bakımı kolay yapar.

interface IUserLogin {
    fun UserLogin(userName: String, password: String) : Boolean
    fun UserOut(userName: String) : Boolean
    fun forgetPassword(userName: String)
}
interface IUserInfo{
    fun getUserInfo()
    fun deleteUser(userName: String)
}

class InterfaceSorusu : IUserLogin, IUserInfo {
    val userEmail = "gorkemarslanbogan@gmail.com"
    val userPassword = "123456"
    override fun UserLogin(userName: String, password: String) : Boolean {

        if(userName.equals(userEmail) && password.equals(userPassword)) {
            println("Giriş Yapıldı..")
            return true
        }
        println("Giriş Başarısız..")
        return false
    }

    override fun UserOut(userName: String): Boolean  {
        if(userName.equals(userEmail)) {
            println("Çıkış Yapıldı..")
            return true
        }
        println("Çıkış Yapılamadı..")
        return false
    }

    override fun forgetPassword(userName: String) {
        if(userName.equals(userEmail)) {
            println("Şifre sıfırlandı yeni şifre '123456789'..")
        }else {
            println("Kullanıcı bulunamadı")
        }
    }

    override fun getUserInfo() {
        val list = listOf(userEmail, userPassword)
        println("Kullanıcı Bilgileri")
        list.forEach {
            println(it)
        }
    }

    override fun deleteUser(userName: String) {
        if(userName.equals(userEmail)) {
            println("Kullanıcı Silindi..")
        }else {
            println("Kullanıcı bulunamadı")
        }
    }

}