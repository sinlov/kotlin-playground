package com.sinlov.kotlin.design.patterns.creation.builder

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Builder_pattern">Wikipedia Builder_pattern</a>
 */
data class DSLUser(
    var id: String = "",
    var username: String = "mine",
    var password: String = ""
)

fun buildDSLUser(buildAction: DSLUser.() -> Unit) = DSLUser().apply(buildAction)

fun modifyDSLUser(user: DSLUser, modifyAction: DSLUser.() -> Unit) = user.apply(modifyAction)