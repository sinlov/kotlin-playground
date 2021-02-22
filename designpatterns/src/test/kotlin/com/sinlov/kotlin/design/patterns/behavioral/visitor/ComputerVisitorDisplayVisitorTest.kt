package com.sinlov.kotlin.design.patterns.behavioral.visitor

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ComputerVisitorDisplayVisitorTest : StringSpec({

    "visitor pattern test" {
        val computer = Computer()
//        println("computer.accept(ComputerVisitorDisplayVisitor()) = ${computer.accept(ComputerVisitorDisplayVisitor())}")
        computer.accept(ComputerVisitorDisplayVisitor()) shouldBe """displaying mouse...
displaying keyboard...
displaying monitor...
displaying computer...

        """.trimIndent()
    }
})
