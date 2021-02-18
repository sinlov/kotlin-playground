package com.sinlov.kotlin.design.patterns.creation.abstractfactory

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AppleFactoryTest : FunSpec({

    test("AbstractFruitsFactory eat") {
        val simpleFruits = AppleFactory().createSimpleFruits()
        simpleFruits.eat() shouldBe "eat Apple"
        val giftFruits = AppleFactory().createGiftPackFruit()
        giftFruits.eat() shouldBe "eat Gift Apple"
    }
})
