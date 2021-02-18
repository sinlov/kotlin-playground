package com.sinlov.kotlin.design.patterns.creation.singleton

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