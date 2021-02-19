package com.sinlov.kotlin.design.patterns.creation.abstractfactory

import com.sinlov.kotlin.design.patterns.creation.Fruits

open class Apple : Fruits() {
    override fun eat(): String {
        return "eat Apple"
    }
}

class GiftApple : Apple() {
    override fun eat(): String {
        return "eat Gift Apple"
    }
}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Wikipedia Abstract_factory_pattern</a>
 */
abstract class AbstractFruitsFactory {

    abstract fun createSimpleFruits(): Fruits

    abstract fun createGiftPackFruit(): Fruits
}

class AppleFactory : AbstractFruitsFactory() {
    override fun createSimpleFruits(): Fruits {
        return Apple()
    }

    override fun createGiftPackFruit(): Fruits {
        return GiftApple()
    }

}