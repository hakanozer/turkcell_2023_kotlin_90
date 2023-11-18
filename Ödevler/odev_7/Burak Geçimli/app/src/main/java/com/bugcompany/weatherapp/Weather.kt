package com.bugcompany.weatherapp

data class Weather(
    val region: String,
    val period: String,
    val city: String,
    val maxTemp: String,
    val minTemp: String,
    val status: String
)
