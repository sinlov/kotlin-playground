package com.sinlov.kotlin.design.patterns.creation.factorymethod

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FruitsFactoryTest : FunSpec({

    test("FruitsFactory eat()") {
        val apple = AppleFactory().createFruit()
        apple.eat() shouldBe "eat Apple"
        val pear = PearFactory().createFruit()
        pear.eat() shouldBe "eat Pear"
        val banana = BananaFactory().createFruit()
        banana.eat() shouldBe "eat Banana"
    }
})
