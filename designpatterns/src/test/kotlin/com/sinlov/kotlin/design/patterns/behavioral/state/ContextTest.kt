package com.sinlov.kotlin.design.patterns.behavioral.state

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ContextTest : StringSpec({

    "state pattern test" {
        val ctx = Context()

        val startState = StartState()
        startState.doAction(ctx) shouldBe "Player is in start state"
        ctx.state.toString() shouldBe "start state"

        val stopState = StopState()
        stopState.doAction(ctx) shouldBe "Player is in stop state"
        ctx.state.toString() shouldBe "stop state"
    }
})
