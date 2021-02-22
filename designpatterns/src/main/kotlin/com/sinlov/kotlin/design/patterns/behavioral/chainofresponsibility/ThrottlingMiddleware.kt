package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

/**
 * Throttling Middleware check email by request max count at each minute
 * @constructor requestPerMinute max request at each minute
 * @constructor callBack callBack
 */
class ThrottlingMiddleware(private var requestPerMinute: Int, private val callBack: CallBack) : Middleware() {

    private val minuteTime: Int = 60_000

    private var request: Int = 0
    private var currentTime: Long = System.currentTimeMillis()


    override fun check(email: String, password: String): Boolean {
        if (System.currentTimeMillis() > currentTime + minuteTime) {
            request = 0
            currentTime = System.currentTimeMillis()
        }
        request++
        if (request > requestPerMinute) {
            callBack.onCall(false, CallBiz.Throttling, "Request limit exceeded!")
//            Thread.currentThread().interrupt()
            return false
        }
        return checkNext(email, password)
    }
}