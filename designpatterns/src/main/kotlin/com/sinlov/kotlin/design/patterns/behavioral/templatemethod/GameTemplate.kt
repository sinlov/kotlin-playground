package com.sinlov.kotlin.design.patterns.behavioral.templatemethod

/**
 * for Class
 * @see <a href="https://en.wikipedia.org/wiki/Template_method_pattern">Wikipedia Template_method_pattern</a>
 */
abstract class GameTemplate {

    private val sb: StringBuilder by lazy {
        StringBuilder()
    }

    abstract fun initialize(): String

    abstract fun startPlay(): String

    abstract fun endPlay(): String

    fun pay(): String {
        sb.setLength(0)
        sb.append(initialize()).append("\n")
        sb.append(startPlay()).append("\n")
        sb.append(endPlay()).append("\n")
        return sb.toString()
    }
}

class Cricket: GameTemplate() {
    override fun initialize(): String {
        return "cricket game initialized! start playing."
    }

    override fun startPlay(): String {
        return "cricket game started! enjoy the game!"
    }

    override fun endPlay(): String {
        return "cricket game started! enjoy the game!"
    }

}

object Football:GameTemplate() {
    override fun initialize(): String {
        return "football game initialized! start playing."
    }

    override fun startPlay(): String {
        return "football game started! enjoy the game!"
    }

    override fun endPlay(): String {
        return "football game finished!"
    }

}