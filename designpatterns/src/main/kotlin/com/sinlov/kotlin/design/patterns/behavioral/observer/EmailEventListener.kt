package com.sinlov.kotlin.design.patterns.behavioral.observer

class EmailEventListener(private val email: String) : EventListener {
    override fun update(event: String, content: String): String {
        return "email: $email, event: $event content: $content"
    }

}