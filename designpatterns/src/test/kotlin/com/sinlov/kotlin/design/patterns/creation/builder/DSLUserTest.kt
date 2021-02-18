package com.sinlov.kotlin.design.patterns.creation.builder

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.UUID

class DSLUserTest : FunSpec({
    lateinit var uid: String
    lateinit var user: DSLUser
    beforeTest {
        uid = UUID.randomUUID().toString()
        user = buildDSLUser {
            id = uid
            username = "bob"
            password = "bob-like"
        }
    }

    test("01 id") {
        user.id shouldBe uid
    }

    test("02 name") {
        user.username shouldBe "bob"
    }

    test("03 password") {
        user.password shouldBe "bob-like"
    }

    test("04 modifyDSLUser") {
        modifyDSLUser(user) {
            username = "bob"
            password = "bob-change"
        }
        user.username shouldBe "bob"
        user.password shouldBe "bob-change"
    }
})
