package com.sinlov.kotlin.design.patterns.structural.decorator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DataSourceDecoratorTest : FunSpec({

    lateinit var targetStr: String
    lateinit var bob: EncryptedDecorator
    lateinit var lee: CompressionDecorator
    lateinit var marry: CompressionDecorator

    beforeTest {
//        targetStr = """Bob, 100, 1234;
//            lee, 120, 5678;
//        marry, 130, 6151;""".trimIndent()
        targetStr = "want to say"
        bob = EncryptedDecorator(
            UserDataSource("Bob")
        )
        lee = CompressionDecorator(
            UserDataSource("lee")
        )
        marry = CompressionDecorator(
            UserDataSource("marry")
        )
        marry.setCompLevel(9)
    }

    test("01 pushData") {
        bob.pushData(targetStr)
//        println("bob.popData() = ${bob.printData()}")
        bob.printData() shouldBe "user: Bob , content: eGJvdSF1cCF0Yno="
        lee.pushData(targetStr)
        lee.getCompLevel() shouldBe 6
//        println("lee.popData() = ${lee.printData()}")
        lee.printData() shouldBe "user: lee , content: eJwrT8wrUSjJVyhOrAQAGUcEKw=="
        marry.pushData(targetStr)
        marry.getCompLevel() shouldBe 9
//        println("marry.popData() = ${marry.printData()}")
        marry.printData() shouldBe "user: marry , content: eNorT8wrUSjJVyhOrAQAGUcEKw=="
    }

    test("02 popData") {
        bob.pushData(targetStr)
        lee.pushData(targetStr)
        marry.pushData(targetStr)
        bob.popData() shouldBe targetStr
        lee.popData() shouldBe targetStr
        marry.popData() shouldBe targetStr
    }

    test("03 other") {
        val dataSource = UserDataSource("mine")
        val compressionDecorator = CompressionDecorator(
            dataSource
        )
        compressionDecorator.setCompLevel(10)
        compressionDecorator.getCompLevel() shouldBe 9
        compressionDecorator.setCompLevel(-1)
        compressionDecorator.getCompLevel() shouldBe 1

        DataSourceDecorator(dataSource).printData() shouldBe "user: mine , content: "

        compressionDecorator.pushData("")
        println("compressionDecorator.popData() = ${compressionDecorator.popData()}")
        compressionDecorator.popData() shouldBe ""
        compressionDecorator.printData() shouldBe "user: mine , content: "
        val encryptedDecorator = EncryptedDecorator(
            dataSource
        )
        encryptedDecorator.pushData("")
        println("encryptedDecorator.popData() = ${encryptedDecorator.popData()}")
        encryptedDecorator.popData() shouldBe ""
        encryptedDecorator.printData() shouldBe "user: mine , content: "
    }
})
