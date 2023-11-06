package com.works.kemalcetinkayaodev5
// Inheritance Sorusu
open class Ev(var pencereSayisi : Int){
    open fun kacParaEder(konutSayisi:Int):Int{
        var toplamTutar = konutSayisi * 1200000
        return toplamTutar
    }

}

class Saray(var kuleSayisi : Int,pencereSayisi1: Int):Ev(pencereSayisi1){ // veri girişinin  zorunlu hale gelmemesi için bu yapıyı kullandım.
    override fun kacParaEder(konutSayisi: Int): Int {
        return super.kacParaEder(konutSayisi)*5
    }
}

class Villa(var garajVarMi : Boolean, pencereSayisi2:Int):Ev(pencereSayisi2){
    override fun kacParaEder(konutSayisi: Int): Int {
        println("toplam pencere maliteyeti hesabı...")
        var toplamPencereMaliyeti = konutSayisi *pencereSayisi * 1200
        return toplamPencereMaliyeti
    }
}

// Abstract sorusu
abstract class AlanHesap{
    val pi = 3.14159
    abstract fun DaireA(yariCap:Double):Double
}

class Alani : AlanHesap(){
    override fun DaireA(yariCap: Double): Double {
        return pi*yariCap*yariCap
    }
}

interface IPolymorphism {
    val degisken : Int
    fun method1()
    fun method2():String
}
class A:IPolymorphism{
    override val degisken: Int = 12
    override fun method1() {
        println("classA is started")
    }

    override fun method2(): String {
        val x = "ClassA's method2  is started"
        return x
    }
}class B:IPolymorphism{
    override val degisken: Int = 14
    override fun method1() {
        println("classB is started")
    }

    override fun method2(): String {
        val x = "ClassB's method 2  is started"
        return x
    }
}

// Interface
interface IKullaniciGiris{
    fun userLogin(email : String , password :String) : Boolean
}
interface IKullaniciBilgileri{
    fun usermail(email: String):String
    fun userPassword(password: String):String
}
class User : IKullaniciGiris,IKullaniciBilgileri{
    override fun userLogin(email: String, password: String): Boolean {
        return true
    }

    override fun usermail(email: String): String {
        return "kemalcetinkaya32@gmail.com"
    }

    override fun userPassword(password: String): String {
        return "12345"
    }

}

// Hayvanlar alemine giriş...

open class Hayvan{
    init {
        println("Hayvan sınıfı çağrıldı...")
    }
    open fun sesCikar(){
        println("Ses yok ")
    }
    open fun tirnakSayisi(ayakSayisi:Int,parmakSayisi:Int):Int{
        return ayakSayisi * parmakSayisi
    }
}
class Ordek : Hayvan(){
    override fun sesCikar() {
        println("Vak Vak Vak")
    }

    override fun tirnakSayisi(ayakSayisi: Int, parmakSayisi: Int): Int {
        return super.tirnakSayisi(ayakSayisi, parmakSayisi)
    }
}
class Kedi : Hayvan(){
    override fun sesCikar() {
        println("Miyav Miyav")
    }

    override fun tirnakSayisi(ayakSayisi: Int, parmakSayisi: Int): Int {
        return super.tirnakSayisi(ayakSayisi, parmakSayisi)
    }
}


// abstract Interface birlite kullanımı
abstract class Addition(){
    abstract fun addition():Int
    fun multiply(x:Int,y:Int):Int{
        return x*y
    }
}
interface Interface1{
     fun sayHi(saySmt :String):String
}
class InterfaceAbstract():Interface1,Addition(){
    override fun addition() : Int {
        return 12+24
    }

    override fun sayHi(saySmt: String): String {
        return saySmt
    }

}
