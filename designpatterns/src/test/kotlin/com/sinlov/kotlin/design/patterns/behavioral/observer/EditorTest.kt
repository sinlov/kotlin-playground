package com.sinlov.kotlin.design.patterns.behavioral.observer

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class EditorTest : StringSpec({
    "observer test" {
        val editor = Editor()
        val logListener = LogListener("text_log")
        editor.subscribe("other", logListener)
        editor.subscribe("open", logListener)
        editor.subscribe("save", EmailEventListener("admin@example.com"))
        editor.subscribe("close", logListener)

//        println("editor.open(\"test.txt\") = ${editor.open("test.txt")}")
        editor.open("test.txt") shouldBe "logType: text_log, event: open , content: test.txt"
//        println("editor.save() = ${editor.save()}")
        editor.unsubscribe("close", logListener)
        editor.unsubscribe("other", logListener)
        editor.other() shouldBe ""

        editor.save() shouldBe "email: admin@example.com, event: save content: test.txt"
//        println("editor.close() = ${editor.close()}")
        editor.close() shouldBe ""
    }

})
