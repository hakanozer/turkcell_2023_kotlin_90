package com.davutkarakus.turkcellgelecegiyazanlarodev5

//Soru 4 a
//Soyutlama: Arayüzler, nesnelerin yapabileceği işleri metod imzalarıyla tanımlar fakat bu işlerin nasıl yapılacağını belirlemez. Bu sayede, hangi metodların var olduğu ve ne işe yaradığı bilinir ancak detaylar soyutlanır.
//Polimorfizm: Arayüzleri uygulayan sınıflar, arayüzde tanımlanan metotların kendi özel uygulamalarını yapmak zorundadır.Bu, farklı sınıfların aynı arayüzü farklı şekillerde uygulayabileceği anlamına gelir ve bu sayede kod polimorfik hale gelir.
//Modülerlik ve Esneklik: Arayüzler sayesinde, kodun farklı bölümleri arasındaki bağımlılık azalır ve kod daha modüler hale gelir. Bir modülün başka bir modülle nasıl iletişim kuracağını arayüz üzerinden belirleyerek, modüller arası bağlantıyı ve esnekliği artırır.
//Test Edilebilirlik: Arayüzler, özellikle birim testleri yazarken yararlıdır, çünkü gerçek nesnelerin yerine test çiftleri (mocks) veya sahteler (stubs) kullanarak test edilebilir.
//Kodun Yeniden Kullanılabilirliği: Arayüzler, ortak bir temel üzerinden çok sayıda sınıf oluşturmak için kullanılabilir, böylece kodun yeniden kullanılabilirliği artar.


interface OdemeYontemi {
    fun ode(miktar: Double)
}

class KrediKarti : OdemeYontemi {
    override fun ode(miktar: Double) {
        println("Kredi Karti ile $miktar odendi.")
    }
}

class PayPal : OdemeYontemi {
    override fun ode(miktar: Double) {
        println("PayPal ile $miktar odendi.")
    }
}

fun odemeYap(odemeYontemi: OdemeYontemi, miktar: Double) {
    odemeYontemi.ode(miktar)
}

//Soru 4 b
//Kotlin'de bir sınıf birden fazla arayüzü uygulayabilir. Bu durum, bir sınıfın birden fazla kaynaktan davranış ve özellik miras almasına olanak tanır ve dilin esnekliğini artırır. Çoklu arayüz uygulaması önemlidir, çünkü:
//Farklı amaçlara hizmet eden özelliklerin birleştirilmesine izin verir. Bir sınıfın aynı zamanda birden fazla genel davranışı veya protokolü takip etmesi gerektiğinde kullanışlıdır.
//Tek sorumluluk ilkesini destekler. Her arayüz, belirli bir işlevsellik veya davranış kümesini tanımlayabilir ve sınıflar bu işlevselliği gerektiği gibi birleştirerek çok daha modüler ve bakımı kolay kodlar yazılabilir.
//Esnek ve genişletilebilir kodların yazılmasını sağlar. Sınıflar, belirli bir arayüzün gerektirdiği metodları uygulayarak ve ardından başka bir arayüz ekleyerek yeni işlevler kazanabilir.

//Kod Ornegi
interface Surucu {
    fun sur()
}

interface Programci {
    fun kodYaz()
}

class CokYonluInsan : Surucu, Programci {
    override fun sur() {
        println("Araba suruyor.")
    }

    override fun kodYaz() {
        println("Kotlin ile kod yaziyor.")
    }
}