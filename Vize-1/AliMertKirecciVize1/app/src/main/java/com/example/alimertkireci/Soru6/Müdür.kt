package Soru6

class Müdür  {
    val temelMaas=3000
      private val ekSaatUcreti = 0.6
    val Saatlikücreti=167
    val Eksaat=10
      fun hesaplaMaas(): Double {
          return temelMaas + (temelMaas +( ekSaatUcreti*(Eksaat*Saatlikücreti)))
    }
}