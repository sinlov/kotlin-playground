package com.sinlov.kotlin.design.patterns.structural.bridge

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ShapeTest : FunSpec({

    lateinit var blue: Blue
    lateinit var red: Red
    lateinit var picture: Shape
    beforeTest {
        blue = Blue()
        red = Red()
    }

    test("color") {
        var circle = Circle(blue)
        circle.color.colorName() shouldBe "blue"
        circle = Circle(red)
        circle.color.colorName() shouldBe "red"
    }
    test("graphic") {
        picture = Circle(blue)
        picture.graphic() shouldBe "Circle as color: blue"
        picture = Square(red)
        picture.graphic() shouldBe "Square as color: red"
    }
})
