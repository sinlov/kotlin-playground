package com.sinlov.kotlin.design.patterns.creation.prototype

data class ProtoPerson(val name: String, val age: Int) {
    fun doJob(): String {
        return "$name do job"
    }
}
