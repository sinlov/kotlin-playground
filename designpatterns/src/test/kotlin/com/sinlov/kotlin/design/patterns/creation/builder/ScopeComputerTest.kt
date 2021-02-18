package com.sinlov.kotlin.design.patterns.creation.builder

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ScopeComputerTest : FunSpec({

    lateinit var computer: ScopeComputer
    beforeTest {
        computer = ScopeComputer.build {
            setCpu("intel")
            setRam("Samsung")
            setDisplay("Dell")
            setUsb(3)
            setKeyboard("logitech")
        }
    }

    test("toString") {
        computer.toString() shouldBe "Computer(cpu='intel', ram='Samsung', usbCount=3, keyboard='logitech', display='Dell')"
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

    test("default usbCount") {
        val now = ScopeComputer.build {
            setCpu("intel")
            setRam("Samsung")
            setDisplay("Dell")
            setKeyboard("logitech")
        }
        now.usbCount shouldBe 0
    }
})
