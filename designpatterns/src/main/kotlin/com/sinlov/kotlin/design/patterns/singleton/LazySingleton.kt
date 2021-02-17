package com.sinlov.kotlin.design.patterns.singleton

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