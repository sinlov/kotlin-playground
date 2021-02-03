package com.sinlov.kotlin.playground.dashboard

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

class KotlinVariableTest : FunSpec({

    lateinit var kotlinVariable: KotlinVariable

    beforeEach {
        kotlinVariable = KotlinVariable()
    }

    afterEach {
        println("kotlinVariable.hashCode: ${kotlinVariable.hashCode()}")
    }

    test("sum one") {
        val sum = kotlinVariable.sum(100, 200)
        sum shouldBe 300
    }

    test("sum two") {
        val sum = kotlinVariable.sum(200, 300)
        sum shouldBe 500
    }


})
