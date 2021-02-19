package com.sinlov.kotlin.design.patterns.structural.adapter

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * for Class or Object
 * @see <a href="https://en.wikipedia.org/wiki/Adapter_pattern">wiki Adapter_pattern</a>
 */
interface ITemperatureAdapter {
    var temperature: Double
    val temperatureFormat: DecimalFormat
        get() {
            val decimalFormat = DecimalFormat("######0.00")
            decimalFormat.roundingMode = RoundingMode.HALF_UP
            return decimalFormat
        }

    fun formatTemperature(): String
}

class CelsiusTemperature(override var temperature: Double) : ITemperatureAdapter {
    override fun formatTemperature(): String = temperatureFormat.format(temperature)
}

class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature) : ITemperatureAdapter {
    override var temperature: Double
        get() = convertCelsius2Fahrenheit(celsiusTemperature.temperature)
        set(temperatureFahrenheit) {
            celsiusTemperature.temperature = convertFahrenheit2Celsius(temperatureFahrenheit)
        }

    override fun formatTemperature(): String = temperatureFormat.format(temperature)

    private fun convertFahrenheit2Celsius(fahrenheitTemperature: Double): Double = (fahrenheitTemperature - 32) * 5 / 9

    private fun convertCelsius2Fahrenheit(celsiusTemperature: Double): Double = (celsiusTemperature * 9 / 5) + 32
}

