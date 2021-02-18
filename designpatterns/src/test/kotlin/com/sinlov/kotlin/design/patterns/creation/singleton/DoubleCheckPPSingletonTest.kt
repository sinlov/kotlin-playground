package com.sinlov.kotlin.design.patterns.creation.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DoubleCheckPPSingletonTest : FunSpec({

    lateinit var doubleCheckPPSingleton: DoubleCheckPPSingleton
    beforeTest {
        doubleCheckPPSingleton = DoubleCheckPPSingleton.getInstance(1)
    }

    test("DoubleCheckPPSingletonTest hashcode") {
        val now = DoubleCheckPPSingleton.getInstance(1)
        now.hashCode() shouldBe doubleCheckPPSingleton.hashCode()
    }

    test("DoubleCheckPPSingleton getProperty()") {
        val instance = DoubleCheckPPSingleton.getInstance(1)
        instance.getProperty() shouldBe 1
        DoubleCheckPPSingleton.getInstance(2).getProperty() shouldBe 1
    }
})
