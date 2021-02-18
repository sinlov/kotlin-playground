package com.sinlov.kotlin.design.patterns.creation.factorymethod

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SimpleFruitsFactoryTest : FunSpec({
    lateinit var simpleFactory: SimpleFruitsFactory
    beforeTest {
        simpleFactory = SimpleFruitsFactory()
    }

    test("createFruit") {
        var fruit = simpleFactory.createFruit(SimpleFruitsFactory.APPLE)
        fruit?.eat() shouldBe "eat Apple"
        fruit = simpleFactory.createFruit(SimpleFruitsFactory.PEAR)
        fruit?.eat() shouldBe "eat Pear"
        fruit = simpleFactory.createFruit(SimpleFruitsFactory.BANANA)
        fruit?.eat() shouldBe "eat Banana"
    }
})
