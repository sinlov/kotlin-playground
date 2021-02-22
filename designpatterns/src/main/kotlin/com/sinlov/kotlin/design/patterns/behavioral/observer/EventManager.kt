package com.sinlov.kotlin.design.patterns.behavioral.observer

class EventManager(vararg operator: String) {

    private val listeners by lazy {
        val values = mutableMapOf<String, MutableList<EventListener>>()
        operator.forEach {
            values[it] = arrayListOf()
        }
        values
    }

    private val sb by lazy {
        StringBuffer()
    }

    fun subscribe(eventType: String, listener: EventListener) {
        listeners[eventType]?.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        listeners[eventType]?.remove(listener)
    }

    fun notify(eventType: String, content: String): String {
        sb.setLength(0)
        listeners[eventType]?.forEach {
            sb.append(it.update(eventType, content))
        }
        return sb.toString()
    }
}