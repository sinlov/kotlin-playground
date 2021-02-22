package com.sinlov.kotlin.design.patterns.behavioral.iterator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class NameRepositoryTest : StringSpec({

    "Interpreter_pattern test" {
        val iterator = NameRepository().getIterator()

        while (iterator.hasNext()) {
            iterator.next() shouldBe startWith("name:")
        }
        iterator.next() shouldBe null
    }
})
