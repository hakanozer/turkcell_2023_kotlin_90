package Soru4

fun main(args: Array<String>) {

    var actionObj=PrimeNumberOperations()

    val n = 10
    val primes = actionObj.findPrimesInRange(n)
    val primeSum = actionObj.getSumOfAllPrimes(n)




    println("1'den $n'Girilen Sayılardan asal olanlar=: $primes")
    println("1'den $n'Girilen Sayılardan Asal Olanların toplamı:= $primeSum")

}