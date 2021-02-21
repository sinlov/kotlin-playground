package com.sinlov.kotlin.design.patterns.structural.proxy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ProxySDKTest : FunSpec({

    test("printSDKID") {
        val proxySDK = ProxySDK("12345678")
        proxySDK.printSDKID() shouldBe "12345678"
    }
})
