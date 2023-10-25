package Soru6

class GenelMüdür  {
    val temelMaas=5000
    val Saatlikücreti=167
    val Eksaat=1
    private val ekSaatUcreti = 0.8

     fun hesaplaMaas(): Double {
        return temelMaas + (temelMaas +( ekSaatUcreti*(Eksaat*Saatlikücreti)))
    }
}