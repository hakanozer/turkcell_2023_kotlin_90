package Soru3Polimorfizm

class Soruüc (val uzunluk:Double,val ganislik:Double):Sekil(){
override fun hesaplaAlan():Double{
    return uzunluk*ganislik
}
}
open class Sekil{
    open fun hesaplaAlan():Double{
        return 0.0
    }
}
class daire(val yarıcap:Double):Sekil(){
    override fun hesaplaAlan():Double{
        return Math.PI*yarıcap*yarıcap
    }
}
fun hesaplama (sekil: Sekil):Double{
    return sekil.hesaplaAlan()
}