package com.sinlov.kotlin.design.patterns.structural.bridge

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Bridge_pattern">Wikipedia Bridge_pattern</a>
 */
interface IBridgeColor {
    fun colorName(): String
}

class Red : IBridgeColor {
    override fun colorName(): String = "red"
}

class Blue : IBridgeColor {
    override fun colorName(): String = "blue"
}

abstract class Shape(val color: IBridgeColor) {
    abstract fun graphic(): String
}

class Circle(color: IBridgeColor) : Shape(color) {
    override fun graphic(): String {
        return "Circle as color: ${color.colorName()}"
    }

}

class Square(color: IBridgeColor) : Shape(color) {
    override fun graphic(): String {
        return "Square as color: ${color.colorName()}"
    }
}