package com.sinlov.kotlin.design.patterns.behavioral.strategy

interface Strategy {
    fun doOperation(one: Int, two: Int): Int
}

class OperationAdd : Strategy {
    override fun doOperation(one: Int, two: Int): Int {
        return one + two
    }

}

class OperationSubtract : Strategy {
    override fun doOperation(one: Int, two: Int): Int {
        return one - two
    }

}

class OperationMultiply : Strategy {
    override fun doOperation(one: Int, two: Int): Int {
        return one * two
    }

}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Wikipedia Strategy_pattern</a>
 */
class Calculator(private val strategy: Strategy) {
    fun execStrategy(one: Int, two: Int): Int {
        return strategy.doOperation(one, two)
    }
}