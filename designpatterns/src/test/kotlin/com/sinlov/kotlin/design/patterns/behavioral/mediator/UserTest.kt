package com.sinlov.kotlin.design.patterns.behavioral.mediator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class UserTest : StringSpec({

    "mediator test" {
        val bob = User("bob")
        val lee = User("lee")
        bob.sendMessage("Hi, lee") shouldBe "user name: bob : Hi, lee"
        lee.sendMessage("Hi, bob") shouldBe "user name: lee : Hi, bob"

//        val chatRoom = ChatRoom()
//        chatRoom shouldNotBe null
    }
})
