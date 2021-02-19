package com.sinlov.kotlin.design.patterns.creation.prototype

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ProtoPersonTest : FunSpec({

    lateinit var person: ProtoPerson
    beforeTest {
        person = ProtoPerson("bob", 22)
    }

    test("01 doJob") {
        person.doJob() shouldBe "bob do job"
    }

    test("ProtoPerson") {
        val lee = person.copy("lee", 23)
        lee.doJob() shouldBe "lee do job"
    }
})
