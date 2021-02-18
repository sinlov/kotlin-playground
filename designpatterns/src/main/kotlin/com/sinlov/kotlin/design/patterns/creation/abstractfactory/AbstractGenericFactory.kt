package com.sinlov.kotlin.design.patterns.creation.abstractfactory

interface Computer {
    fun name(): String
}

/**
 * dell
 */
class Dell : Computer {
    override fun name() = "Dell"
}

/**
 * asus
 */
class Asus : Computer {
    override fun name() = "Asus"
}

/**
 * acer
 */
class Acer : Computer {
    override fun name() = "Acer"
}

class DellFactory : AbstractGenericFactory() {
    override fun product() = Dell()
}

class AsusFactory : AbstractGenericFactory() {
    override fun product() = Asus()
}

class AcerFactory : AbstractGenericFactory() {
    override fun product() = Acer()
}

abstract class AbstractGenericFactory {
    abstract fun product(): Computer

    companion object {
        inline operator fun <reified T : Computer> invoke(): AbstractGenericFactory =
            when (T::class) {
                Dell::class -> DellFactory()
                Asus::class -> AsusFactory()
                Acer::class -> AcerFactory()
                else -> throw IllegalArgumentException("unKnow Computer type: ${T::class.qualifiedName}")
            }
    }
}