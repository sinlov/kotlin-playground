package com.sinlov.kotlin.design.patterns.structural.flyweight

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ForestTest : FunSpec({
    lateinit var forest: Forest
    beforeTest {
        forest = Forest()
    }

    test("paint") {
        forest.addTree(1, 1, "maple", "one")
        forest.addTree(3, 3, "birch", "one")
        forest.addTree(5, 5, "pine", "one")
        val paint = forest.paint("watercolour")
//        println("paint = $paint")
        paint shouldBe """draw tree -> name: maple, x: 1 y: 1, drawing style: watercolour, otherTreeData: one
draw tree -> name: birch, x: 3 y: 3, drawing style: watercolour, otherTreeData: one
draw tree -> name: pine, x: 5 y: 5, drawing style: watercolour, otherTreeData: one

""".trimIndent()
    }

    test("TreeFactory") {
        val treeType = TreeFactory.getTreeType("maple", "two")
//        println("treeType = ${treeType.draw(1,2, "watercolour")}")
        treeType.draw(1,2, "watercolour") shouldBe "draw tree -> name: maple, x: 1 y: 2, drawing style: watercolour, otherTreeData: one"
    }
})
