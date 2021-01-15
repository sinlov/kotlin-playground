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

    test("sum") {
        val sum = kotlinVariable.sum(100, 200)
        sum shouldBe 300
    }


})
