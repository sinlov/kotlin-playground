package com.sinlov.kotlin.design.patterns.creation.builder

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">Wikipedia Builder_pattern</a>
 */
class Computer private constructor(
    val cpu: String,
    val ram: String,
    val usbCount: Int,
    val keyboard: String,
    val display: String
) {

    private constructor(builder: Builder) : this(
        builder.cpu,
        builder.ram,
        builder.usbCount,
        builder.keyboard,
        builder.display
    )

    class Builder {
        var cpu: String = ""
            private set
        var ram: String = ""
            private set
        var usbCount: Int = 0
            private set
        var keyboard: String = ""
            private set
        var display: String = ""
            private set

        fun setCpu(inputCpu: String) = apply {
            this.cpu = inputCpu
        }

        fun setRam(inputRam: String) = apply {
            this.ram = inputRam
        }

        fun setUsb(inputUsb: Int) = apply {
            this.usbCount = inputUsb
        }

        fun setKeyboard(inputKeyboard: String) = apply {
            this.keyboard = inputKeyboard
        }

        fun setDisplay(inputDisplay: String) = apply {
            this.display = inputDisplay
        }

        fun build() = Computer(this)
    }

    override fun toString(): String {
        return "Computer(cpu='$cpu', ram='$ram', usbCount=$usbCount, keyboard='$keyboard', display='$display')"
    }

}