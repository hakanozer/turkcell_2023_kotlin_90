import Soru3Polimorfizm.ikinciinterface

class Soruüctrikiüc(val odaSayisi: Int, val bahceAlan: Double) : ikinciinterface {
    override fun fiyatHesapla(): Double {
        return odaSayisi * 1200 + bahceAlan * 1000
    }

    override fun tanit() {
        println("Villa - Oda Sayısı: $odaSayisi, Bahçe Alanı: $bahceAlan m²")
    }
}