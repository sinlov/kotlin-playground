package com.sinlov.kotlin.design.patterns.behavioral.observer

interface EventListener {
    fun update(event: String, content: String): String
}