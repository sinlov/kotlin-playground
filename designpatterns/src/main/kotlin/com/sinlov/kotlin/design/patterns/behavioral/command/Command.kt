package com.sinlov.kotlin.design.patterns.behavioral.command

class AddOrder(val id: Long) : IOrderCommand {
    override fun execute(): String {
        return "add order: ${this.id}"
    }
}

class PayOrder(val id: Long) : IOrderCommand {
    override fun execute(): String {
        return "pay order: ${this.id}"
    }
}

class OrdersCommandProcessor {

    private val sb: StringBuilder by lazy {
        StringBuilder()
    }

    private val queue = mutableListOf<IOrderCommand>()

    fun addQueue(command: IOrderCommand): OrdersCommandProcessor = apply {
        queue.add(command)
    }

    fun processCommands(): OrdersCommandProcessor = apply {
        queue.forEach {
            sb.append(it.execute()).append("\n")
        }
        queue.clear()
    }

    fun totalProcessPrint(): String {
        return sb.toString()
    }
}