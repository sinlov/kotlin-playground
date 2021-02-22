package com.sinlov.kotlin.design.patterns.behavioral.mediator

class ChatRoom private constructor() {
    companion object {
        fun showMessage(user: User, message: String): String {
            return "user name: ${user.name} : $message"
        }
    }
}