package com.sinlov.kotlin.foundation.string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class StringOperatorTest : StringSpec({

    lateinit var stringOperator: StringOperator

    beforeTest {
        stringOperator = StringOperator()
    }

    "subString IntRange" {
        val tmp = "Rob's friend"
        val index = tmp.indexOf('\'')
        index shouldBe 3
        tmp.substring(0, index) shouldBe "Rob"
        // until not covered limit
        tmp.substring(0 until index) shouldBe "Rob"
    }

    "split" {
        val names = "jack,jacky,jason"
        val data = names.split(',')
        data.size shouldBe 3
        // kotlin has destruction
        val (origin, dest, proxy) = names.split(',')
        origin shouldBe "jack"
        dest shouldBe "jacky"
        proxy shouldBe "jason"

        val list = stringOperator.splitSomeString(names, Regex(","))
        list.size shouldBe 3
    }

    "replace" {
        val tmp = "The people's this."
        val changed = tmp.replace(Regex("[aeiou]")) {
            when (it.value) {
                "a" -> "8"
                "e" -> "6"
                "i" -> "9"
                "o" -> "1"
                "u" -> "2"
                else -> it.value
            }
        }
        changed shouldBe "Th6 p61pl6's th9s."
    }

    "string compare" {
        val str1 = "Json"
        val str2 = "Json"
        (str1 == str2) shouldBe true
        (str1 === str2) shouldBe true
        val str3 = String("Json".toByteArray(Charsets.UTF_8))
        (str1 == str3) shouldBe true
        (str1 === str3) shouldBe false
        val str4 = "json".capitalize()
        (str1 === str4) shouldBe false
    }

    "forEach" {
        "The people's this.".forEach {
            it shouldNotBe ""
        }
    }
})
