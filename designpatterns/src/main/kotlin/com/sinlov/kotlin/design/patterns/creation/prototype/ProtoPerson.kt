package com.sinlov.kotlin.design.patterns.creation.prototype

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Prototype_pattern">Wikipedia Prototype_pattern</a>
 */
data class ProtoPerson(val name: String, val age: Int) {
    fun doJob(): String {
        return "$name do job"
    }
}
