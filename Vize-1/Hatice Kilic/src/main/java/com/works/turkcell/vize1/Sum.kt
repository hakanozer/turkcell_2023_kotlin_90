package com.works.turkcell.vize1


class Sum {

    fun nSum():Int {
        var i = 1
        var sumnum = 0
        val n = 3

        var isBreak = false
        for (i in 1..n){
            var num = n * (n + 1)
            var sumnum = num / 2
            println("1`den N`ye kadar sayilarin toplami: $sumnum")
            if (i == num){
                isBreak = true
                break
            }
            return sumnum

        }
        return sumnum
    }
}