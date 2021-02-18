package com.sinlov.kotlin.design.patterns.creation.singleton

class ThreadSafeLazySingleton private constructor() {
    companion object {
        private var instance: ThreadSafeLazySingleton? = null
            get() {
                if (field == null) {
                    field = ThreadSafeLazySingleton()
                }
                return field
            }

        @Synchronized
        fun get(): ThreadSafeLazySingleton {
            return instance!!
        }
    }

    fun objectName(): String {
        return "ThreadSafeLazySingleton"
    }
}