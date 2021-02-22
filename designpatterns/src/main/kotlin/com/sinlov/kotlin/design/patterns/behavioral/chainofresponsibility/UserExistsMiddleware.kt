package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

class UserExistsMiddleware(private val server: Server, private val callBack: CallBack) : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (!server.hasEmail(email)) {
            callBack.onCall(false, CallBiz.UserExists, "This email is not registered!")
            return false
        }
        if (!server.isValidPassword(email, password)) {
            callBack.onCall(false, CallBiz.UserExists, "password error!")
            return false
        }
        return checkNext(email, password)
    }
}