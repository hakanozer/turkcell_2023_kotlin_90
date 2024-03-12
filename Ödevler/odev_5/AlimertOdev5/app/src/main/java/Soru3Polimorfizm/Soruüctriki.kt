package Soru3Polimorfizm

class Soruüctriki (val odasayisi:Int,val metrekare:Double):Soruücseciki{
    override fun fiyathesapla():Double{
        return odasayisi*1000+metrekare*500
    }
    override fun tanit(){
        println("Daire-oda sayısı :$odasayisi, Metrekare: $metrekare m²")
    }

}
