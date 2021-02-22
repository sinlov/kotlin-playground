package com.sinlov.kotlin.design.patterns.behavioral.observer

class LogListener(private val logType: String) : EventListener {
    override fun update(event: String, content: String): String {
        return "logType: $logType, event: $event , content: $content"
    }
}