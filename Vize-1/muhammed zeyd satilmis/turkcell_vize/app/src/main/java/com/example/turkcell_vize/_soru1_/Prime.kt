package com.example.turkcell_vize._soru1_

//Soru 4 & 5
class Prime {

    fun isPrime(inp: Int): Boolean {
        var result = false // Varsayılan değer olarak false

        if (inp <= 1) {
            result = false
        } else if (inp <= 3) {
            result = true
        } else if (inp % 2 == 0 || inp % 3 == 0) {
            result = false
        } else {
            var i = 5
            while (i * i <= inp) {
                if (inp % i == 0 || inp % (i + 2) == 0) {
                    result = false
                    break
                }
                i += 6
            }
            result = true // En son işlem sonucu true ise true olarak ayarla
        }

        return result
    }

    fun getSumOfAllPrimes(inp: Int): Int {
        var sum = 0

        for (i in 2..inp) {
            if (isPrime(i)) {
                sum += i
            }
        }
        println("Asal mı: ${isPrime(inp)}")
        println(sum)
        return sum
    }

}

