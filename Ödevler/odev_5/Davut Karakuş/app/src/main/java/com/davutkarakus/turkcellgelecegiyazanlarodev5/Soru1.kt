package com.davutkarakus.turkcellgelecegiyazanlarodev5

// Soru 1 a
    // Yazılım geliştirmede "inheritance" (miras), bir sınıfın başka bir sınıftan özelliklerini ve metodlarını devralmasını sağlayan bir özelliktir.
    // Miras, kod tekrarını azaltmak, kod organizasyonunu iyileştirmek ve modülerlik sağlamak amacıyla kullanılır.
    //Bir sınıf, miras yoluyla başka bir sınıftan türetildiğinde, türetilen sınıf ("derived class" ya da "subclass" olarak adlandırılır) üst sınıfın ("base class" ya da "superclass") özelliklerine (değişkenler) ve metodlarına sahip olur.
    // Bu, türetilen sınıfa, mevcut işlevsellik üzerine yeni işlevsellikler eklemesine veya var olan işlevselliği değiştirmesine (override) olanak tanır.
    //Örnek:
    //Bir oyun yazılımında farklı türde karakterler olduğunu düşünelim. Tüm karakterlerin bazı ortak özellikleri vardır: ad, yaş ve enerji. Bu özellikler her karakter için geçerli olduğu için bir "Character" isimli bir üst sınıfta tanımlanabilir.
    // Savaşçı ve Büyücü gibi farklı karakter türleri ise bu "Character" sınıfından türeyebilir ve ek özellikler veya metodlar içerebilir.


// Soru 1 b
open class Arac(val marka: String, val model: String) {
    open fun calistir() {
        println("$marka $model calistiriliyor.")
    }
}

class Araba(marka: String, model: String, val kapasite: Int) : Arac(marka, model) {
    fun yukTasi(yukMiktari: Int) {
        if (yukMiktari <= kapasite) {
            println("$marka $model ile $yukMiktari kg yuk tasiniyor.")
        } else {
            println("Yuk kapasitesi asildi!")
        }
    }

    override fun calistir() {
        super.calistir()
        println("$marka $model isiniyor ve hazir oluyor.")
    }
}
