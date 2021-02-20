package com.sinlov.kotlin.design.patterns.structural.decorator

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.Base64
import java.util.zip.Deflater
import java.util.zip.DeflaterOutputStream
import java.util.zip.InflaterInputStream

open class DataSourceDecorator(private val wrapper: IDataSource) : IDataSource {
    override fun pushData(data: String) {
        this.wrapper.pushData(data)
    }

    override fun popData(): String {
        return this.wrapper.popData()
    }

    override fun printData(): String {
        return this.wrapper.printData()
    }
}

class EncryptedDecorator(private val dataSource: IDataSource) : DataSourceDecorator(dataSource) {
    override fun pushData(data: String) {
        super.pushData(encode(data))
    }

    override fun popData(): String {
        return decode(super.popData())
    }

    override fun printData(): String {
        return dataSource.printData()
    }

    private fun encode(data: String): String {
        val result = data.toByteArray()

        val oneByte = 1.toByte()
        for (i in result.indices) {
            result[i] = (oneByte + result[i]).toByte()
        }

        return Base64.getEncoder().encodeToString(result)
    }

    private fun decode(data: String): String {
        val result: ByteArray = Base64.getDecoder().decode(data)

        val oneByte = 1.toByte()
        for (i in result.indices) {
            result[i] = (result[i] - oneByte).toByte()
        }
        return String(result)
    }
}

class CompressionDecorator(private val dataSource: IDataSource) : DataSourceDecorator(dataSource) {

    override fun pushData(data: String) {
        super.pushData(compress(data))
    }

    override fun popData(): String {
        return decompress(super.popData())
    }

    override fun printData(): String {
        return dataSource.printData()
    }

    private var compLevel = 6

    fun getCompLevel(): Int = compLevel
    fun setCompLevel(level: Int) {
        var targetLevel = level
        if (targetLevel > 9) {
            targetLevel = 9
        }
        if (targetLevel < 1) {
            targetLevel = 1
        }
        this.compLevel = targetLevel
    }

    private val bufferSize = 512

    private fun compress(stringData: String): String {
        if (stringData.isEmpty()) {
            return ""
        }
        val data = stringData.toByteArray()
        val bout = ByteArrayOutputStream(bufferSize)
        val dos = DeflaterOutputStream(bout, Deflater(compLevel))
        dos.write(data)
        dos.close()
        bout.close()
        return Base64.getEncoder().encodeToString(bout.toByteArray())
    }

    private fun decompress(stringData: String): String {
        if (stringData.isEmpty()) {
            return ""
        }
        val data = Base64.getDecoder().decode(stringData)
        val `in`: InputStream = ByteArrayInputStream(data)
        val iin = InflaterInputStream(`in`)
        val bout = ByteArrayOutputStream(bufferSize)
        var b: Int
        while (iin.read().also { b = it } != -1) {
            bout.write(b)
        }
        `in`.close()
        iin.close()
        bout.close()
        return String(bout.toByteArray())
    }
}