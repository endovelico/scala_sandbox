package com.example.design_patterns.structural

class CompositePattern {

  trait Graphic {
    def draw(): Unit
    def add(g: Graphic): Unit =
      throw new UnsupportedOperationException("Cannot add to leaf")
  }

  class Circle extends Graphic {
    override def draw(): Unit = println("Drawing a Circle")
  }

  class Square extends Graphic {
    override def draw(): Unit = println("Drawing a Square")
  }

  class CompositeGraphic extends Graphic {
    private var children: List[Graphic] = List()

    override def draw(): Unit = children.foreach(_.draw())

    override def add(g: Graphic): Unit = {
      children = children :+ g
    }

    val circle1 = new Circle
    val circle2 = new Circle
    val square1 = new Square

    val composite1 = new CompositeGraphic
    composite1.add(circle1)
    composite1.add(square1)

    val composite2 = new CompositeGraphic
    composite2.add(circle2)
    composite2.add(composite1)

    composite2.draw()
  }

}
