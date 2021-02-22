package com.sinlov.kotlin.design.patterns.behavioral.command

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OrdersCommandProcessorTest : StringSpec({
    "OrdersCommandProcessor test"{
        val processor = OrdersCommandProcessor()
        forAll(
            row(10L),
            row(11L)
        ) { a ->
            val addOrder = AddOrder(a)
            addOrder.id shouldBe a
            processor.addQueue(addOrder)
            val payOrder = PayOrder(a)
            processor.addQueue(payOrder)
            payOrder.id shouldBe a
        }
        processor.processCommands()
        println("OrdersCommandProcessor().totalProcessPrint() = ${processor.totalProcessPrint()}")
        processor.totalProcessPrint() shouldBe """add order: 10
pay order: 10
add order: 11
pay order: 11

""".trimIndent()
    }
})
