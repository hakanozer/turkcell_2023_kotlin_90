package com.works.homework5.Interface

/**
 * Belirli metotları ve davranışları uygulama zorunluluğu getirerek, sınıflar arasında belirli bir davranışın garanti edilmesini sağlar.
 * Arayüzler, bir nesnenin belirli bir türünü temsil etmesine olanak tanır ve bu türün ortak davranışlarını tanımlar.
 * Bu sayede, kodun daha soyut ve genelleştirilmiş olmasını sağlar.
 * Sınıflar birden fazla sınıfı miras alamazlar, ancak bir sınıf birden fazla arayüzü uygulayabilir.
 * Bu, sınıflar arasında çoklu mirası taklit etmek için kullanılabilir.
 */

//  Örnek olarak, bir "HareketEdebilir" arayüzü tanımlayalım.

interface HareketEdebilir {
    fun hareketEt(hiz: Int)
}

// Bu arayüzü uygulayan bir "Araba" sınıfımız olsun.

class Araba : HareketEdebilir {
    override fun hareketEt(hiz: Int) {
        println("Araba $hiz km/s hızla hareket ediyor.")
    }
}

// Bu kodda, "Araba" sınıfı, "HareketEdebilir" arayüzünü kullanarak ve "hareketEt" metodunu içeriyor.
// Bu sayede araba sınıfı hareket yeteneğine sahip bir nesne olarak kabul edilmiş oluyor.