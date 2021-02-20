package com.sinlov.kotlin.design.patterns.structural.decorator

class UserDataSource(private var username: String) : IDataSource {
    private val dataBuffer: StringBuilder by lazy {
        StringBuilder()
    }

    override fun pushData(data: String) {
        dataBuffer.append(data)
    }

    override fun popData(): String {
        return dataBuffer.toString()
    }

    override fun printData(): String {
        return "user: $username , content: $dataBuffer"
    }

}