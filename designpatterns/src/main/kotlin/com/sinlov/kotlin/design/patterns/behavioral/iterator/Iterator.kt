package com.sinlov.kotlin.design.patterns.behavioral.iterator

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Iterator_pattern">Wikipedia Iterator_pattern</a>
 */
interface Iterator {
    fun hasNext(): Boolean
    fun next(): Any?
}

interface Container {
    fun getIterator(): Iterator
}