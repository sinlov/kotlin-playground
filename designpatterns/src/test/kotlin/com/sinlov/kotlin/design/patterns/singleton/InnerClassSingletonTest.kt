package com.sinlov.kotlin.design.patterns.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InnerClassSingletonTest : FunSpec({

    lateinit var innerClassSingleton: InnerClassSingleton
    beforeTest {
        innerClassSingleton = InnerClassSingleton.instance
    }

    test("InnerClassSingletonTest hashcode") {
        val now = InnerClassSingleton.instance
        now.hashCode() shouldBe innerClassSingleton.hashCode()
    }

    test("InnerClassSingleton method"){
        InnerClassSingleton.instance.objectName() shouldBe "InnerClassSingleton"
    }

})
