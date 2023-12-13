package Soru3Polimorfizm

/**
 * Polimorfim Kelime Anlamı İle Çok Çeiştlilik ibaresi taşımaktadır.
 * OOP Konfigrasyonlarından birisidir.
 * -Kodun Daha esnek olması ve Genel Olması:Polimorfizm ,kodun daha genel ve esnek olması
 * olmasına yardımcı olur.Aynı arayüzü (Method Yada İşlevi )Kullanan farklı nesneleri
 * işleyebilirsiniz,bu da kodun daha az özelleştirilmiş ve daha yeniden kullanılabilir olmasını sağlar.
 * -Miras VE Soyutlama İle Çalışır:Polimorfizm miras ve soyutlama gibi diğer OOp kavramları ile
 * birlikte çalışır.Bu Sayede sınıf hiyerarşileri daha iyi yönetilir ve karmaşıklık azalır.
 * */

fun main(args: Array<String>) {
    val dikdörtgen =Soruüc(8.5,12.5)
    val Daire=daire(3.1)
    println("Dikdörtgen Alanı: ${hesaplama(dikdörtgen)}")
    println("Daire Alanı: ${hesaplama(Daire)}")
}