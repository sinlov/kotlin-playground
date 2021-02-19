package com.sinlov.kotlin.design.patterns.creation.factorymethod

import com.sinlov.kotlin.design.patterns.creation.Fruits

/**
 * for Class
 * @see <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Wikipedia Factory_method_pattern</a>
 */
abstract class FruitsFactory {
    abstract fun createFruit(): Fruits
}

class AppleFactory : FruitsFactory() {
    override fun createFruit(): Fruits {
        return Apple()
    }
}

class PearFactory : FruitsFactory() {
    override fun createFruit(): Fruits {
        return Pear()
    }
}

class BananaFactory : FruitsFactory() {
    override fun createFruit(): Fruits {
        return Banana()
    }
}
