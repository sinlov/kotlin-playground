package com.sinlov.kotlin.design.patterns.structural.proxy

interface ISdk {
    fun printSDKID(): String
}

class RealSDK(sdkID: String) : ISdk {

    private lateinit var saveSDKID: String

    init {
        this.initSDK(sdkID)
    }

    fun initSDK(sdkID: String) {
        this.saveSDKID = sdkID
    }

    override fun printSDKID(): String {
        return this.saveSDKID
    }

}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Proxy_pattern">Wikipedia Proxy_pattern</a>
 */
class ProxySDK(sdkID: String) : ISdk {

    private val realSDK: RealSDK by lazy {
        RealSDK(sdkID)
    }

    override fun printSDKID(): String {
        return realSDK.printSDKID()
    }

}