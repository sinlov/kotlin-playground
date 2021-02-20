package com.sinlov.kotlin.design.patterns.structural.composite

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class UserComponentTest : FunSpec({

    lateinit var marry: MemberUser
    lateinit var lee: EmployeeUser
    lateinit var bob: ReportUser
    beforeTest {
        marry = MemberUser("marry", 30)
        lee = EmployeeUser("lee", 24)
        bob = ReportUser("bob")
    }

    test("getName") {
        marry.getName() shouldBe "marry"
        lee.getName() shouldBe "lee"
        val err = shouldThrowExactly<UnsupportedOperationException> {
            bob.getName()
        }
        err.message shouldBe startWith("unsupported operation")
    }

    test("getAge") {
        marry.getAge() shouldBe 30
        lee.getAge() shouldBe 24
        val err = shouldThrowExactly<UnsupportedOperationException> {
            bob.getAge()
        }
        err.message shouldBe startWith("unsupported operation")
    }

    test("report") {
        val err = shouldThrowExactly<UnsupportedOperationException> {
            marry.report()
        }
        err.message shouldBe startWith("unsupported operation")
        lee.report() shouldBe "employee lee report!"
    }

    test("getReportUser") {
        bob.getReportUser() shouldBe "bob"
    }
})
