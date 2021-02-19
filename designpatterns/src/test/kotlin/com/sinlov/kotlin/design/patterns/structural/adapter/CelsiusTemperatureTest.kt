package com.sinlov.kotlin.design.patterns.structural.adapter

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CelsiusTemperatureTest : FunSpec({


    test("temperature") {
        val temperature = CelsiusTemperature(22.1)
        temperature.temperature shouldBe 22.1
        temperature.temperature = 32.1
        temperature.temperature shouldBe 32.1
    }
    test("formatTemperature") {
        val temperature = CelsiusTemperature(22.1)
        temperature.formatTemperature() shouldBe "22.10"
    }
})
