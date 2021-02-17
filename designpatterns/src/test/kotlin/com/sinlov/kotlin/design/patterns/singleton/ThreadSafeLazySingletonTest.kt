package com.sinlov.kotlin.design.patterns.singleton

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ThreadSafeLazySingletonTest : FunSpec({

    test("Thread get LazySingletonTest") {
        var tssHash = 0
        for (i in 1..100) {
            val runnable = Runnable {
                val now = ThreadSafeLazySingleton.get()
                if (tssHash == 0) {
                    tssHash = now.hashCode()
                }
                now.hashCode() shouldBe tssHash
            }
            Thread(runnable).start()
        }
    }

    test("ThreadSafeLazySingleton method") {
        ThreadSafeLazySingleton.get().objectName() shouldBe "ThreadSafeLazySingleton"
    }

})
