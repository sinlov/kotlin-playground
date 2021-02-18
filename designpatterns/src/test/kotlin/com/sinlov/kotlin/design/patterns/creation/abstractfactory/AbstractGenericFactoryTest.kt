package com.sinlov.kotlin.design.patterns.creation.abstractfactory

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class AbstractGenericFactoryTest : FunSpec({

    test("product") {
        val dell = AbstractGenericFactory<Dell>().product()
        dell.name() shouldBe "Dell"
        val asus = AbstractGenericFactory<Asus>().product()
        asus.name() shouldBe "Asus"
        val acer = AbstractGenericFactory<Acer>().product()
        acer.name() shouldBe "Acer"
        val err = shouldThrow<IllegalArgumentException> {
            AbstractGenericFactory<Computer>().product()
        }
//        println("err.message = ${err.message}")
        err.message should startWith("unKnow Computer type:")
    }
})
