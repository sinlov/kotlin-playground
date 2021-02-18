package com.sinlov.kotlin.design.patterns.creation.builder

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MainboardTest : FunSpec({

    lateinit var mainboard: Mainboard
    beforeTest {
        mainboard = Mainboard.Builder("intel", "Samsung")
            .setGpu("Nvidia")
            .setUsb(6)
            .setKeyboard("logitech")
            .build()
    }

    test("toString") {
        mainboard.toString() shouldBe "Mainboard(cpu='intel', ram='Samsung', usbCount=6, gpu='Nvidia', funCount='3', keyboard='logitech')"
    }

    test("cpu") {
        mainboard.cpu shouldBe "intel"
    }

    test("ram") {
        mainboard.ram shouldBe "Samsung"
    }

    test("usbCount") {
        mainboard.usbCount shouldBe 6
    }

    test("gpu") {
        mainboard.gpu shouldBe "Nvidia"
    }

    test("funCount") {
        mainboard.funCount shouldBe 3
    }

    test("keyboard") {
        mainboard.keyboard shouldBe "logitech"
    }

    test("change funCount") {
        val other = Mainboard.Builder("intel", "Samsung")
            .setFunCount(6)
            .build()
        other.funCount shouldBe 6
    }
})
