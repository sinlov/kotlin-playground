package com.sinlov.kotlin.design.patterns.creation.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LazySingletonTest : FunSpec({
    lateinit var lazySingleton: LazySingleton
    beforeTest {
        lazySingleton = LazySingleton.get()
    }

    test("LazySingleton hashcode") {
        val now = LazySingleton.get()
        println("lazySingleton.hashCode = ${lazySingleton.hashCode()}")
        now.hashCode() shouldBe lazySingleton.hashCode()
    }

    test("LazySingleton method") {
        lazySingleton.objectName() shouldBe "LazySingleton"
    }
})
