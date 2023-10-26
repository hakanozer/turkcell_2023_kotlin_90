package Soru4

class PrimeNumberOperations {
    fun isPrime(Say1: Int): Boolean {
        //Burada İlk olarak sayılar 1den Küçük olursa asal olmaz o kısmı eledik
        if (Say1 <= 1){
            return false
        }

        if (Say1==2)
        {//ek olarak 2 de asal sayılmaz!
      return false
        }
        if (Say1 <= 3) {//sayı 3
            return true//
        }
        if (Say1 % 2 == 0) {
            return false
        }
        if (Say1 % 3 == 0) {
            return false
        }
        var i = 5
        while (i * i <= Say1) {
            if (Say1 % i == 0 || Say1 % (i + 2) == 0) {
                return false
            }
            i += 6
        }

        return true
    }
    fun findPrimesInRange(n: Int): List<Int> {
        val primes = mutableListOf<Int>()

        for (i in 2..n) {
            if (isPrime(i)) {
                primes.add(i)
            }
        }

        return primes
    }
    fun getSumOfAllPrimes(n: Int): Int {
        val primes = findPrimesInRange(n)
        return primes.sum()
    }

}
