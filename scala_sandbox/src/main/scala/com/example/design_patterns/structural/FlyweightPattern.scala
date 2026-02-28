package com.example.design_patterns.structural

class FlyweightPattern {

  trait TreeType {
    def draw(x: Int, y: Int): Unit
  }

  case class ConcreteTreeType(name: String, color: String, texture: String) extends TreeType {
    override def draw(x: Int, y: Int): Unit = {
      println(s"Drawing $name tree of color $color at ($x, $y) with texture $texture")
    }
  }

  object TreeFactory {
    private var treeTypes: Map[String, ConcreteTreeType] = Map()

    def getTreeType(name: String, color: String, texture: String): ConcreteTreeType = {
      val key = s"$name-$color-$texture"
      treeTypes.getOrElse(key, {
        val treeType = ConcreteTreeType(name, color, texture)
        treeTypes += key -> treeType
        treeType
      })
    }
  }

  case class Tree(x: Int, y: Int, treeType: TreeType) {
    def draw(): Unit = treeType.draw(x, y)
  }

  object Forest {
    private var trees: List[Tree] = List()

    def plantTree(x: Int, y: Int, name: String, color: String, texture: String): Unit = {
      val treeType = TreeFactory.getTreeType(name, color, texture)
      trees = trees :+ Tree(x, y, treeType)
    }

    def drawForest(): Unit = trees.foreach(_.draw())
  }

  // Usage
  Forest.plantTree(10, 20, "Oak", "Green", "Rough")
  Forest.plantTree(15, 25, "Oak", "Green", "Rough") // reused tree type
  Forest.plantTree(30, 40, "Pine", "Dark Green", "Smooth")

  Forest.drawForest()
}
