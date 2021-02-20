package com.sinlov.kotlin.design.patterns.structural.composite

import java.lang.IllegalArgumentException

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Composite_pattern">Wikipedia Composite_pattern</a>
 */
abstract class UserComponent {
    open fun getName(): String {
        throw UnsupportedOperationException("unsupported operation getName()")
    }

    open fun getAge(): Int {
        throw UnsupportedOperationException("unsupported operation getAge()")
    }

    open fun report(): String {
        throw UnsupportedOperationException("unsupported operation report()")
    }
}

class ReportUser(private var report: String) : UserComponent() {
    fun getReportUser(): String {
        return this.report
    }
}

class MemberUser(private val name: String, private val age: Int) : UserComponent() {
    override fun getName(): String {
        return this.name
    }

    override fun getAge(): Int {
        return this.age
    }
}

class EmployeeUser(private val name: String, private val age: Int) : UserComponent() {
    override fun getName(): String {
        return this.name
    }

    override fun getAge(): Int {
        return this.age
    }

    override fun report(): String {
        return "employee ${this.name} report!"
    }
}