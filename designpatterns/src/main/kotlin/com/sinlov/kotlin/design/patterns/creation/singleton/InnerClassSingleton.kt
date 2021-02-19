package com.sinlov.kotlin.design.patterns.creation.singleton

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Wikipedia Singleton_pattern</a>
 */
class InnerClassSingleton private constructor() {
    companion object {
        val instance = Holder.holder
    }

    private object Holder {
        val holder = InnerClassSingleton()
    }

    fun objectName(): String {
        return "InnerClassSingleton"
    }
}