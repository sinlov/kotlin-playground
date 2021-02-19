package com.sinlov.kotlin.design.patterns.creation.singleton

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Wikipedia Singleton_pattern</a>
 */
class LazySingleton private constructor() {
    companion object {
        private var instance: LazySingleton? = null
            get() {
                if (field == null) {
                    field = LazySingleton()
                }
                return field
            }

        fun get(): LazySingleton {
            return instance!!
        }
    }

    fun objectName(): String {
        return "LazySingleton"
    }
}