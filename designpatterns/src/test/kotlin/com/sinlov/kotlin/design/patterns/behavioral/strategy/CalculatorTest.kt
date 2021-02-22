package com.sinlov.kotlin.design.patterns.behavioral.strategy

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "strategy pattern test" {
        var calculator = Calculator(OperationAdd())
        calculator.execStrategy(1, 2) shouldBe 3

        calculator = Calculator(OperationSubtract())
        calculator.execStrategy(3, 2) shouldBe 1

        calculator = Calculator(OperationMultiply())
        calculator.execStrategy(3, 2) shouldBe 6
    }

})
