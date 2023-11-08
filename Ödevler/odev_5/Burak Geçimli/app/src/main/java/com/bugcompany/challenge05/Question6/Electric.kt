package com.bugcompany.challenge05.Question6

interface Electric {
    fun charge()
    val batteryLevel: Int
    fun showBatteryLevel() {
        println("Battery level is $batteryLevel%")
    }
    val isFullyCharged: Boolean get() = batteryLevel == 100
}
