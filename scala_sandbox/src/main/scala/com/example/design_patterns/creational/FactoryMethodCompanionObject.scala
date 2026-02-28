package com.example.design_patterns.creational

private class FactoryMethodCompanionObject {

  trait Shape { def draw(): Unit }

  object Shape {
    def create(kind: String): Shape = kind match {
      case "circle" => new Circle
      case "rectangle" => new Rectangle
    }
  }

  class Circle extends Shape { def draw() = println("Drawing Circle") }
  class Rectangle extends Shape { def draw() = println("Drawing Rectangle") }

  // Usage
  val shape = Shape.create("circle")
  shape.draw()
}
