package com.sinlov.kotlin.foundation.nullsafe

class NullSafeType {
    val a: String = "abc" // can not null
    //a = null will error

    var b: String? = "abc" // can null

    fun c(): String? {
        return null
    }

    fun d(): String? {
        return null
    }

    fun e():String? {
        return null
    }

    val f: String? = null

    val gList: List<Int?> = listOf(1, 2, null, 4)
}