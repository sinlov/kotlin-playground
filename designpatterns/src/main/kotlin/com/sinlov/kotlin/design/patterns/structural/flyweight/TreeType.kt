package com.sinlov.kotlin.design.patterns.structural.flyweight

class TreeType(private val name: String, private val otherTreeData: String) {
    fun draw(x: Int, y: Int, drawingStyle: String): String {
        return "draw tree -> name: $name, x: $x y: $y, drawing style: $drawingStyle, otherTreeData: $otherTreeData"
    }
}

class Tree(private var x: Int, private var y: Int, private val treeType: TreeType) {
    fun draw(drawingStyle: String):String {
        return treeType.draw(x, y, drawingStyle)
    }
}

class TreeFactory private constructor() {
    companion object {
        private val treeTypes = mutableMapOf<String, TreeType>()

        fun getTreeType(name: String, otherTreeData: String): TreeType {
            var treeType = this.treeTypes[name]
            if (treeType == null) {
                treeType = TreeType(name, otherTreeData)
                this.treeTypes[name] = treeType
            }
            return treeType
        }
    }
}

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Flyweight_pattern">Wikipedia Flyweight_pattern</a>
 */
class Forest(private val trees: MutableList<Tree> = mutableListOf()) {
    fun addTree(x: Int, y: Int, name: String, otherTreeData: String) {
        val treeType = TreeFactory.getTreeType(name, otherTreeData)
        val tree = Tree(x, y, treeType)
        trees.add(tree)
    }

    fun paint(drawingStyle: String): String {
        val sb = StringBuilder()
        this.trees.forEach {
            sb.append(it.draw(drawingStyle)).append("\n")
        }
        return sb.toString()
    }
}