package Soru5

class Inheritance {
    fun isPrime(sayi: Int): Boolean {
    if (sayi <= 1)
    {
        return false
    }
    if (sayi == 2)
    {
        return true
    }
    if (sayi % 2 == 0)
    {
        return false
    }

    for (bolen in 3..Math.sqrt(sayi.toDouble()).toInt() step 2)
    {
        if (sayi % bolen == 0) return false
    }

    return true
}
}
