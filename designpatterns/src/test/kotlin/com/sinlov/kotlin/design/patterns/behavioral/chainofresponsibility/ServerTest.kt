package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

import io.kotest.assertions.timing.continually
import io.kotest.assertions.until.fixed
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@ExperimentalTime
class ServerTest : ShouldSpec({
}) {
    init {
        should("chain of responsibility") {
            val adminUserName: String by lazy { "admin@example.com" }
            val adminUserPass: String by lazy { "admin_pass" }
            val userUserName: String by lazy { "user@example.com" }
            val userUserPass: String by lazy { "user_pass" }
            val server = Server(object : CallBack {
                override fun onCall(success: Boolean, code: CallBiz, message: String) {
                    println("success = $success, code = $code, message = $message")
                }
            })
            server.signIn(adminUserName, adminUserPass)
            server.signIn(userUserName, userUserPass)

            val throttlingMiddleware = ThrottlingMiddleware(6, object : CallBack {
                override fun onCall(success: Boolean, code: CallBiz, message: String) {
                    println("success = $success, code = $code, message = $message")
                    code shouldBe CallBiz.Throttling
                }
            }).also {
                it.linkWith(UserExistsMiddleware(server, object : CallBack {
                    override fun onCall(success: Boolean, code: CallBiz, message: String) {
                        println("success = $success, code = $code, message = $message")
                        code shouldBe CallBiz.UserExists
                    }
                })).linkWith(RoleCheckMiddleware(object : CallBack {
                    override fun onCall(success: Boolean, code: CallBiz, message: String) {
                        println("success = $success, code = $code, message = $message")
                        code shouldBe CallBiz.CheckRole
                    }
                }))
            }
            server.setMiddleware(throttlingMiddleware)
            var cnt = 0
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(adminUserName, adminUserPass)
                println("- $cnt user: $adminUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe true
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(userUserName, userUserPass)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe true
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(userUserName, adminUserPass)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe false
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(userUserName, userUserPass)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe true
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn("userName@example.com", userUserName)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe false
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(userUserName, userUserName)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe false
            }
            continually(1.seconds, 1.seconds.fixed()) {
                cnt++
                val res = server.logIn(userUserName, userUserName)
                println("- $cnt user: $userUserName , res: = $res at: ${System.currentTimeMillis()}")
                res shouldBe false
            }
        }
    }
}
