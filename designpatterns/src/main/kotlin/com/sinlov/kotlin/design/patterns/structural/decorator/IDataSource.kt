package com.sinlov.kotlin.design.patterns.structural.decorator

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Decorator_pattern">Wikipedia Decorator_pattern</a>
 */
interface IDataSource {
    fun pushData(data: String)
    fun popData(): String
    fun printData(): String
}