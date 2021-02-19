package com.sinlov.kotlin.design.patterns.creation.builder

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">Wikipedia Builder_pattern</a>
 */
class Mainboard private constructor(
    val cpu: String,
    val ram: String,
    val usbCount: Int,
    val gpu: String,
    val funCount: Int,
    val keyboard: String
) {
    private constructor(build: Builder) : this(
        build.cpu,
        build.ram,
        build.usbCount,
        build.gpu,
        build.funCount,
        build.keyboard
    )

    class Builder(val cpu: String, val ram: String) {
        var usbCount: Int = 0
            private set
        var gpu: String = ""
            private set
        var funCount: Int = 3
            private set
        var keyboard: String = ""
            private set

        fun setUsb(inputUsb: Int) = apply {
            this.usbCount = inputUsb
        }

        fun setGpu(inputGpu: String) = apply {
            this.gpu = inputGpu
        }

        fun setFunCount(funCount: Int) = apply {
            this.funCount = funCount
        }

        fun setKeyboard(keyboard: String) = apply {
            this.keyboard = keyboard
        }

        fun build() = Mainboard(this)
    }

    override fun toString(): String {
        return "Mainboard(cpu='$cpu', ram='$ram', usbCount=$usbCount, gpu='$gpu', funCount='$funCount', keyboard='$keyboard')"
    }
}