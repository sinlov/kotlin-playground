package com.sinlov.kotlin.foundation.number

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberOperatorTest : StringSpec({

    lateinit var numberOperator: NumberOperator
    beforeTest {
        numberOperator = NumberOperator()
    }

    "max number" {
        numberOperator.byte shouldBe Byte.MAX_VALUE
        numberOperator.short shouldBe Short.MAX_VALUE
        numberOperator.int shouldBe Int.MAX_VALUE
        numberOperator.long shouldBe Long.MAX_VALUE
        numberOperator.float shouldBe Float.MAX_VALUE
        numberOperator.double shouldBe Double.MAX_VALUE
    }

    "safe convert" {
        shouldThrow<NumberFormatException> { "1.23".toInt() }
        val numberSafe: Int? = "1.23".toIntOrNull()
        numberSafe shouldBe null
    }

})
