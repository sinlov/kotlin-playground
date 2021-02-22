package com.sinlov.kotlin.design.patterns.behavioral.observer

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Observer_pattern">Wikipedia Observer_pattern</a>
 */
class Editor {
    private val events = EventManager("open", "save", "close")
    private var file: String? = null

    fun subscribe(eventType: String, listener: EventListener) {
        events.subscribe(eventType, listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        events.unsubscribe(eventType, listener)
    }

    fun open(file: String): String {
        this.file = file
        return events.notify("open", file)
    }

    fun save(): String {
        return events.notify("save", file!!)
    }

    fun close(): String {
        return events.notify("close", file!!)
    }

    fun other(): String {
        return events.notify("other", file!!)
    }
}