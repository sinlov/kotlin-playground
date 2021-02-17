package com.sinlov.kotlin.design.patterns.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class HungrySingletonTest : FunSpec({

    lateinit var hungrySingleton: HungrySingleton

    beforeTest {
        hungrySingleton = HungrySingleton
    }

    test("HungrySingleton hashCode test") {
        val nowSingleton = HungrySingleton
        nowSingleton shouldBe hungrySingleton
        println("nowSingleton.hashCode = ${nowSingleton.hashCode()}")
        nowSingleton.hashCode() shouldBe hungrySingleton.hashCode()
    }

    test("HungrySingleton objectName") {
        hungrySingleton.objectName() shouldBe "HungrySingleton"
    }
})
