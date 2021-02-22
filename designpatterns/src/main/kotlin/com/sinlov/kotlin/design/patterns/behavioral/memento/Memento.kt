package com.sinlov.kotlin.design.patterns.behavioral.memento

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Memento_pattern">Wikipedia Memento_pattern</a>
 */
class Memento(val state: String)

class Originator {
    lateinit var state: String
    fun saveState2Memento(): Memento {
        return Memento(state)
    }

    fun getStateFromMemento(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
    private val mementoList = arrayListOf<Memento>()

    fun add(memento: Memento) {
        mementoList.add(memento)
    }

    fun get(index: Int): Memento {
        return mementoList[index]
    }
}