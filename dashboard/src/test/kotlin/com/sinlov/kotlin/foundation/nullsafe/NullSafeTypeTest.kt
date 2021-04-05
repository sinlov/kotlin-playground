package com.sinlov.kotlin.foundation.nullsafe

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.startWith

class NullSafeTypeTest : StringSpec({
    lateinit var nullSafeType: NullSafeType
    beforeTest {
        nullSafeType = NullSafeType()
    }

    "a can not null" {
        nullSafeType.a shouldNotBe null
    }

    "b null safe => ?" {
        nullSafeType.b = null
        nullSafeType.b shouldBe null
    }

    "c let null safe => .let{}" {
        nullSafeType.c() shouldBe null
        nullSafeType.c()?.let {
            if (it.isNotBlank()) {
                it.capitalize()
            }
        } shouldBe null
    }

    "d assert null => !!" {
        val tmp: String? = nullSafeType.d()
        val exception = shouldThrow<NullPointerException> {
            tmp!!.count() shouldBe 0
        }
//        println("exception.cause = ${exception.cause}")
        exception.message shouldBe null
    }

    "e elvis operator => :?" {
        val exception = shouldThrow<IllegalArgumentException> {
            nullSafeType.e() ?: throw IllegalArgumentException("nullSafeType e is null")
        }
        exception.message should startWith("nullSafeType e is null")
    }

    "f safe cast => as?" {
        @Suppress("CAST_NEVER_SUCCEEDS")
        val tmp: Int? = nullSafeType.f as? Int
        tmp shouldBe null
    }

    "g safe nullable list => filterNotNull()" {
        val intList: List<Int> = nullSafeType.gList.filterNotNull()
        intList shouldNotBe null
        intList.count() shouldBe 3
    }
})
