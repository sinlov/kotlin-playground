package com.sinlov.kotlin.design.patterns.creation.builder

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ComputerTest : FunSpec({

    lateinit var computer: Computer
    beforeTest {
        computer = Computer.Builder()
            .setCpu("intel")
            .setRam("Samsung")
            .setDisplay("Dell")
            .setUsb(3)
            .setKeyboard("logitech")
            .build()
    }

    test("cpu") {
        computer.cpu shouldBe "intel"
    }

    test("ram") {
        computer.ram shouldBe "Samsung"
    }

    test("usbCount") {
        computer.usbCount shouldBe 3
    }

    test("keyboard") {
        computer.keyboard shouldBe "logitech"
    }

    test("display") {
        computer.display shouldBe "Dell"
    }

    test("toString") {
        computer.toString() shouldBe "Computer(cpu='intel', ram='Samsung', usbCount=3, keyboard='logitech', display='Dell')"
    }
})
