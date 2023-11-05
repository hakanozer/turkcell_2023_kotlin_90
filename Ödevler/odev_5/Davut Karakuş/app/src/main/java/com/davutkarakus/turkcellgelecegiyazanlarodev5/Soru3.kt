package com.davutkarakus.turkcellgelecegiyazanlarodev5

//Soru 3 a
//Polimorfizm, yazılım geliştirmede, nesnelerin farklı sınıfların örnekleri olmasına rağmen aynı arayüzü kullanarak farklı şekillerde davranmasını sağlayan bir özelliktir.
//Temelde, farklı tiplerin aynı arayüzü kullanmasına izin verir.
//Bu, özellikle nesne yönelimli programlamada, aynı metodun farklı sınıflar üzerinde farklı davranışlar sergilemesini sağlayarak kod yeniden kullanımını, esnekliği ve genişletilebilirliği artırır.
//Ornek :
//Diyelim ki bir Hayvan adında bir üst sınıfımız var ve bu sınıfta tüm hayvanların ortak özellikleri ve fonksiyonları bulunuyor.
//Ayrıca, her hayvanın konuşma şeklini temsil eden bir konuş fonksiyonumuz var.
//Kedi ve Köpek sınıfları Hayvan sınıfından türemiş durumda ve her biri konuş metodunu kendi versiyonlarıyla uygulayacak.


//Soru 3 b
interface MedyaDosyasi {
    fun oynat()
}

class Muzik : MedyaDosyasi {
    override fun oynat() {
        println("Muzik oynatiliyor.")
    }
}

class Video : MedyaDosyasi {
    override fun oynat() {
        println("Video oynatiliyor.")
    }
}

fun medyaOynat(medyaDosyasi: MedyaDosyasi) {
    medyaDosyasi.oynat()
}

//Bu örnekte, MedyaDosyasi arayüzü, tüm medya dosyalarının sahip olması gereken oynat metodunu tanımlar.
//Muzik ve Video sınıfları bu arayüzü farklı şekillerde uygular.
//medyaOynat fonksiyonu polimorfik olarak herhangi bir MedyaDosyasi nesnesini kabul eder ve üzerinde oynat metodunu çağırır.
// Bu çağrı sırasında nesnenin gerçek türüne bağlı olarak ilgili metod çalıştırılır.
//Polimorfizmin bu kullanımı, medya oynatıcı uygulamaların farklı medya türlerini genişletilebilir bir şekilde desteklemesini sağlar ve aynı zamanda, farklı medya türleri eklenirken mevcut kodda önemli değişiklikler yapmaya gerek kalmaz.
//Bu, bakımı ve gelişimi kolay, esnek bir sistem yaratmada yardımcı olur.