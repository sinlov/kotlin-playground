package com.sinlov.kotlin.design.patterns.behavioral.iterator

/**
 * for Class
 * @see <a href="https://en.wikipedia.org/wiki/Interpreter_pattern">Wikipedia Interpreter_pattern</a>
 */
interface Iterator {
    fun hasNext(): Boolean
    fun next(): Any?
}

interface Container {
    fun getIterator(): Iterator
}