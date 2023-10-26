package Soru6

open class Personel {
    val temelMaas=1000
    private val ekSaatUcreti = 0.6
    val Saatlikücreti=167
    val Eksaat=5
    open fun hesaplaMaas(): Double {
        return temelMaas + (temelMaas +( ekSaatUcreti*(Eksaat*Saatlikücreti)))
}}