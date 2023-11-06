package com.works.odev.Odev5

/**
 * Polymorphism (Polimorfizm):
 * a. Polimorfizm yazılım geliştirmede ne anlama gelir ve neden önemlidir? Bir örnek ile açıklayınız.
 * b. Bir arayüz (interface) tanımlayın ve bu arayüzü uygulayan farklı sınıfları kullanarak polimorfik
 * bir örnek yaratın. Polimorfizmin avantajları hakkında görüşlerinizi paylaşınız.
 *
 */
fun main(args: Array<String>) {

    /*
    polimorfizm OOP'da programlama dilinin farklı tip verileri ve sınıfları farklı şekilde işleme yeteneğidir.
    örnek vermek gerekirse hesapla adında metod oluşturduk aynı metodu kullanarak sayının karesini , küpünü
    veye girilen değerin kendisine ,eklenmesini sağlayabilirirz.
     */

    val odemeYontemleri : Array<Odeme> = arrayOf(Kart(),Nakit())

    val odenecekMikar = 200.0

    for (odemeYontemi in odemeYontemleri){
        odemeYontemi.odemeYap(odenecekMikar)
    }


}