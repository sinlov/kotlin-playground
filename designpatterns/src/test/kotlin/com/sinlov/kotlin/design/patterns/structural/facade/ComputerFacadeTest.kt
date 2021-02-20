package com.sinlov.kotlin.design.patterns.structural.facade

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ComputerFacadeTest : FunSpec({

    test("powerOnInfo") {
        val powerOnInfo = ComputerFacade("windows").powerOnInfo()
//        println("powerOnInfo = $powerOnInfo")
        powerOnInfo shouldBe """powerOnInfo:
            windows bios start
            windows cpu run
            windows mem loading
        """.trimIndent()
    }
})
