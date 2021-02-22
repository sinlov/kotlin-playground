package com.sinlov.kotlin.design.patterns.behavioral.visitor

interface ComputerPart {
    fun accept(computerPartVisitor: ComputerPartVisitor): String
}

interface ComputerPartVisitor {
    fun visit(computer: Computer): String

    fun visit(mouse: Mouse): String

    fun visit(keyboard: Keyboard): String

    fun visit(monitor: Monitor): String
}

class Computer : ComputerPart {

    private val sb: StringBuffer by lazy {
        StringBuffer()
    }
    private val parts = arrayListOf<ComputerPart>(Mouse(), Keyboard(), Monitor())

    override fun accept(computerPartVisitor: ComputerPartVisitor): String {
        sb.setLength(0)
        parts.forEach {
            sb.append(it.accept(computerPartVisitor)).append("\n")
        }
        sb.append(computerPartVisitor.visit(this)).append("\n")
        return sb.toString()
    }

}

class Mouse : ComputerPart {

    override fun accept(computerPartVisitor: ComputerPartVisitor): String {
        return computerPartVisitor.visit(this)
    }

}

class Keyboard : ComputerPart {

    override fun accept(computerPartVisitor: ComputerPartVisitor): String {
        return computerPartVisitor.visit(this)
    }

}

class Monitor : ComputerPart {

    override fun accept(computerPartVisitor: ComputerPartVisitor): String {
        return computerPartVisitor.visit(this)
    }

}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Wikipedia Visitor_pattern</a>
 */
class ComputerVisitorDisplayVisitor : ComputerPartVisitor {
    override fun visit(computer: Computer): String {
        return "displaying computer..."
    }

    override fun visit(mouse: Mouse): String {
        return "displaying mouse..."
    }

    override fun visit(keyboard: Keyboard): String {
        return "displaying keyboard..."
    }

    override fun visit(monitor: Monitor): String {
        return "displaying monitor..."
    }

}