package com.sinlov.kotlin.foundation.exception

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class SelfDefExceptionTest : StringSpec({

    "cache exception" {
        val num: Int? = null
        try {
            num!!.plus(1)
        } catch (e: Exception) {
//          println("e.message = ${e.message}")
            e.message shouldBe null
        }
    }

    "self define exception" {
        val num: Int? = null
        val exception = shouldThrow<SelfDefException> {
            num ?: throw SelfDefException("null is num")
        }
//        println("exception.message = ${exception.message}")
        exception.message should startWith("null is")
    }
})
