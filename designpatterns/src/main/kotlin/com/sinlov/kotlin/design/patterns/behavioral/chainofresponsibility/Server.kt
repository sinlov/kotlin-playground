package com.sinlov.kotlin.design.patterns.behavioral.chainofresponsibility

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern">Wikipedia Chain-of-responsibility_pattern</a>
 */
class Server(private val callBack: CallBack) {
    private val users: MutableMap<String, String?> = HashMap()
    private var middleware: Middleware? = null

    /**
     * set middleware
     */
    fun setMiddleware(middleware: Middleware?) {
        this.middleware = middleware
    }

    /**
     * login
     */
    fun logIn(email: String?, password: String?): Boolean {
        if (middleware!!.check(email!!, password!!)) {
            callBack.onCall(true, CallBiz.Login,"Authorization have been successful!")
            return true
        }
        return false
    }

    /**
     * sign in
     */
    fun signIn(email: String, password: String?) {
        users[email] = password
    }

    /**
     * some user-email has email
     */
    fun hasEmail(email: String): Boolean {
        return users.containsKey(email)
    }

    /**
     * user-email password valid
     */
    fun isValidPassword(email: String?, password: String): Boolean {
        return users[email] == password
    }
}