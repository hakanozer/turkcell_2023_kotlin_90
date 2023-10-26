package Soru6

class Memur {
    val temelMaas=1000
    private val ekSaatUcreti = 0.3
    val Eksaat=2
    val Saatlikücreti=167

     fun hesaplaMaas(): Double {
         return temelMaas + (temelMaas +( ekSaatUcreti*(Eksaat*Saatlikücreti)))
    }


}