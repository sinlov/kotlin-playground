package com.sinlov.kotlin.foundation.string

class StringOperator {

    fun splitSomeString(str: String, regex: Regex): List<String> {
        return str.split(regex)
    }
}