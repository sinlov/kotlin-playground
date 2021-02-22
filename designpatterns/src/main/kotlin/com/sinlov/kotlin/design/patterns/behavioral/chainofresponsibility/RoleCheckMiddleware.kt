package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

/**
 * role check, will callback admin info when user name is admin@example.com
 */
class RoleCheckMiddleware(private var callBack: CallBack) : Middleware() {
    override fun check(email: String, password: String): Boolean {
        if (email == "admin@example.com") {
            callBack.onCall(true, CallBiz.CheckRole,"hello, admin!")
            return true
        }
        callBack.onCall(true, CallBiz.CheckRole,"hello, user!")
        return checkNext(email, password)
    }
}