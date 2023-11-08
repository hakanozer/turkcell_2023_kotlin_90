package com.works.fifthassignment._3_polymorphism

//Metodların farklı sınıflardan farklı şekillerde override edilmesine olanak sağlar
//Polymorphism avantajlarından bir kaçını söyleyecek olursak okunabilirliği artırır yeniden kullanılması dolayısyla daha az kod yazmamıza olanak sağlar
interface HavaYolu {
    fun havaYolu()
}


class Otobus : HavaYolu {
    override fun havaYolu() {
        println("Ben bir karayolu aracıyım")
    }
}

class Tramvay : HavaYolu {
    override fun havaYolu() {
        println("Ben bir demiryolu aracıyım")
    }
}

