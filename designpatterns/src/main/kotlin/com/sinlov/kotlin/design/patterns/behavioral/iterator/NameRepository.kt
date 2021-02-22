package com.sinlov.kotlin.design.patterns.behavioral.iterator

class NameRepository : Container {

    private val names = arrayListOf("bob", "lee", "marry")

    override fun getIterator(): Iterator {
        return NameIterator()
    }

    private inner class NameIterator : Iterator {

        private var index = 0

        override fun hasNext(): Boolean {
            return index < names.size
        }

        override fun next(): Any? {
            return if (this.hasNext()) {
                "name: ${names[index++]}"
            } else {
                null
            }
        }

    }
}