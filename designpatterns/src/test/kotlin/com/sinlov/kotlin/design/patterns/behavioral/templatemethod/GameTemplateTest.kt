package com.sinlov.kotlin.design.patterns.behavioral.templatemethod

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameTemplateTest : StringSpec({

    "template method test" {
        Cricket().pay() shouldBe """cricket game initialized! start playing.
cricket game started! enjoy the game!
cricket game started! enjoy the game!

        """.trimIndent()
        Football.pay() shouldBe """football game initialized! start playing.
football game started! enjoy the game!
football game finished!

        """.trimIndent()
    }
})
