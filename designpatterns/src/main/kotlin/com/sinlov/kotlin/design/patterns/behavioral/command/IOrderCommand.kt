package com.sinlov.kotlin.design.patterns.behavioral.command

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Command_pattern">Wikipedia Command_pattern</a>
 */
interface IOrderCommand {
    fun execute(): String
}