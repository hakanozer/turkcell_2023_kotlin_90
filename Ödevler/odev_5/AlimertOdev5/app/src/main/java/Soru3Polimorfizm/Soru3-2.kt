package Soru3Polimorfizm

import Soruüctrikiüc
/*-Kodun Daha Okunabilir ve Anlaşılabilir Olması:
 Polimorfizm, kodun daha okunabilir ve anlaşılabilir olmasına yardımcı olur.
 -Daha Az Kod Tekrarı:
  Polimorfizm, aynı işlevi paylaşan nesneler arasında kod tekrarını önler
  -Daha Esnek ve Genel Kodlar:
  Polimorfizm, daha genel ve esnek kodlar oluşturmanıza olanak tanır.
  -Soyutlama ve Arayüzlerle Birlikte Çalışır: Polimorfizm,
   soyutlama ve arayüzler gibi diğer OOP kavramları ile birlikte çalışır.
   -Modülerlik ve Sürdürülebilirlik: Polimorfizm, yazılımın modüler bir şekilde oluşturulmasını sağlar.
   Sınıfların belirli bir arayüzü uygulayarak birbiriyle iletişim kurmasına yardımcı olur
    ve bu, sürdürülebilirliği artırır.
* */
fun main(args: Array<String>) {
    val daire = Soruüctriki(3, 120.0)
    val villa = Soruüctrikiüc(4, 500.0)

    println("Daire Fiyatı: ${daire.fiyathesapla()} TL")
    daire.tanit()

    println("Villa Fiyatı: ${villa.fiyatHesapla()} TL")
    villa.tanit()
}