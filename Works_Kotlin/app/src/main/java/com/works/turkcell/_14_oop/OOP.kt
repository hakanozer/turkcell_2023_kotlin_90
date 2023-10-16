package com.works.turkcell._14_oop

fun main(args: Array<String>) {

    // actionObj -> Nesne, Object
    // Sınıf içindeki yetenekleri kullanmak için oluşturulurlar.

    // Action() -> Kurucu Methodtur, Constructor
    // Nesneyi "actionObj" kurar.
    // Sınıf içindeki yeteneklerin (Method hariç) bellekte kullanıma hazır hale gelmesini sağlar.

    val actionObj = Action("Kaan")
    println(actionObj.hashCode())
    println( actionObj.name )

    var obj1:Any = actionObj
    //val obj2:Int = actionObj
    val obj2:Int = 100
    obj1 = obj2


    actionObj.fnc1()
    actionObj.fnc2()

    // Tekil - Kurucu method
    val profile = Profile(100, "Ali Kemmal")
    profile.fnc1()

    val userModel = UserModel()
    userModel.setName("Mehmet")
    userModel.getName()

}