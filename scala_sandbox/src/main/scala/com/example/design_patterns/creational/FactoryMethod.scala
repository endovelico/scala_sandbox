package com.example.design_patterns.creational

private trait Shape {
  def draw():Unit
}

private class Circle extends Shape {
  def draw(): Unit = println("Drawing a Circle")
}

private class Rectangle extends Shape {
  def draw(): Unit = println("Drawing a Rectangle")
}

private trait ShapeFactory {
  def createShape():Shape
}

private class CircleFactory extends ShapeFactory {
  def createShape(): Shape = new Circle
}

private class RectangleFactory extends ShapeFactory {
  def createShape(): Shape = new Rectangle
}

private object Main extends App {
  val factories: List[ShapeFactory] = List(new CircleFactory, new RectangleFactory)

  factories.foreach { factory =>
    val shape = factory.createShape()
    shape.draw()
  }
}