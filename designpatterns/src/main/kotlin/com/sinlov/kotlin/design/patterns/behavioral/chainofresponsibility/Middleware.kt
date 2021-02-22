package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

enum class CallBiz {
    Throttling,
    Login,
    UserExists,
    CheckRole,
}

interface CallBack {
    fun onCall(success: Boolean, code: CallBiz, message: String)
}

abstract class Middleware() {
    private var next: Middleware? = null

    fun linkWith(next: Middleware): Middleware {
        this.next = next
        return next
    }

    abstract fun check(email: String, password: String): Boolean

    /**
     * check next, even though next is null, will return true
     */
    protected fun checkNext(email: String, password: String): Boolean {
        return next?.check(email, password) ?: true
    }
}