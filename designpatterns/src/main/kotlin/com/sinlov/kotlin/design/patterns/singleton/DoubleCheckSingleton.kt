package com.sinlov.kotlin.design.patterns.singleton

class DoubleCheckSingleton private constructor() {
    companion object {
        /**
         * https://www.kotlincn.net/docs/reference/delegated-properties.html
         *
         * and lazy @kotlin.internal.InlineOnly
         */
        val instance: DoubleCheckSingleton by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DoubleCheckSingleton()
        }
    }

    fun objectName(): String {
        return "DoubleCheckSingleton"
    }
}