package com.sinlov.kotlin.design.patterns.creation.factorymethod

import com.sinlov.kotlin.design.patterns.creation.Fruits

class Apple : Fruits() {
    override fun eat(): String {
        return "eat Apple"
    }
}

class Pear : Fruits() {
    override fun eat(): String {
        return "eat Pear"
    }
}

class Banana : Fruits() {
    override fun eat(): String {
        return "eat Banana"
    }

}

/**
 * for Class
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Wikipedia Factory_method_pattern</a>
 */
class SimpleFruitsFactory {
    companion object {
        const val APPLE = "Apple"
        const val PEAR = "Pear"
        const val BANANA = "Banana"
    }

    fun createFruit(fruitType: String): Fruits? {
        when (fruitType) {
            APPLE ->
                return Apple()
            PEAR ->
                return Pear()
            BANANA ->
                return Banana()
        }
        return null
    }
}