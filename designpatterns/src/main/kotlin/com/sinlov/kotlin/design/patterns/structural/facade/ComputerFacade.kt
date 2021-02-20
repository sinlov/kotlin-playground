package com.sinlov.kotlin.design.patterns.structural.facade

object BIOS {
    fun start(name: String): String {
        return "$name bios start"
    }
}

object CPU {
    fun run(name: String): String {
        return "$name cpu run"
    }
}

object Memory {
    fun loadings(name: String): String {
        return "$name mem loading"
    }
}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">Wikipedia Facade_pattern</a>
 */
class ComputerFacade(private val name: String) {
    fun powerOnInfo(): String {
        return """powerOnInfo:
            ${BIOS.start(this.name)}
            ${CPU.run(this.name)}
            ${Memory.loadings(this.name)}
        """.trimIndent()
    }
}