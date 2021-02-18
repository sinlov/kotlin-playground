package com.sinlov.kotlin.design.patterns.creation.factorymethod

abstract class SimpleFruits {
    abstract fun eat(): String
}

class SimpleApple : SimpleFruits() {
    override fun eat(): String {
        return "eat Apple"
    }
}

class SimplePear : SimpleFruits() {
    override fun eat(): String {
        return "eat Pear"
    }
}

class SimpleBanana : SimpleFruits() {
    override fun eat(): String {
        return "eat Banana"
    }

}

class SimpleFruitsFactory {
    companion object {
        val APPLE = "Apple"
        val PEAR = "Pear"
        val BANANA = "Banana"
    }

    fun createFruit(fruitType: String): SimpleFruits? {
        when (fruitType) {
            APPLE ->
                return SimpleApple()
            PEAR ->
                return SimplePear()
            BANANA ->
                return SimpleBanana()
        }
        return null
    }
}