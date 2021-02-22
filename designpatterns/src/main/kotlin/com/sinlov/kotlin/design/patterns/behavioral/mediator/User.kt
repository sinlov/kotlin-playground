package com.sinlov.kotlin.design.patterns.behavioral.mediator

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Mediator_pattern">Wikipedia Mediator_pattern</a>
 */
class User(val name: String) {
    fun sendMessage(message: String): String {
        return ChatRoom.showMessage(this, message)
    }
}