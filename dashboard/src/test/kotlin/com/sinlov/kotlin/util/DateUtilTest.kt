package com.sinlov.kotlin.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class DateUtilTest : StringSpec({

    "nowDateStr" {
        val nowDateStr = DateUtil.nowDateStr()
//        println("nowDateStr = $nowDateStr")
        nowDateStr shouldNotBe null
        DateUtil.nowDateStr("yyyy-MM-dd") shouldBe nowDateStr
    }

})
