package com.sinlov.kotlin.design.patterns.structural.adapter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FahrenheitTemperatureTest : FunSpec({

    test("temperature") {
        val temperature = FahrenheitTemperature(CelsiusTemperature(34.12))
        temperature.temperature shouldBe 93.416
        temperature.temperature = 100.12
        temperature.temperature shouldBe 100.12
        temperature.celsiusTemperature.formatTemperature() shouldBe "37.84"
        temperature.celsiusTemperature = CelsiusTemperature(35.13)
//        println("temperature.temperature = ${temperature.formatTemperature()}")
        temperature.formatTemperature() shouldBe "95.23"
    }

    test("formatTemperature") {
        val temperature = FahrenheitTemperature(CelsiusTemperature(34.12))
        temperature.formatTemperature() shouldBe "93.42"
    }
})
