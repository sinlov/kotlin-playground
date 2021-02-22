package com.sinlov.kotlin.design.patterns.behavioral.state

interface State {
    fun doAction(context: Context): String
}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/State_pattern">Wikipedia State_pattern</a>
 */
class Context(var state: State? = null) {
}

class StartState : State {
    override fun doAction(context: Context): String {
        context.state = this
        return "Player is in start state"
    }

    override fun toString(): String {
        return "start state"
    }
}

class StopState : State {
    override fun doAction(context: Context): String {
        context.state = this
        return "Player is in stop state"
    }

    override fun toString(): String {
        return "stop state"
    }
}