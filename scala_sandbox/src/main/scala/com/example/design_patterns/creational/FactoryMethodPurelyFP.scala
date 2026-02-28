package com.example.design_patterns.creational

private class FactoryMethodPurelyFP {

  val circleFactory: () => Shape = () => new Circle
  val rectangleFactory: () => Shape = () => new Rectangle

  val shapes = List(circleFactory(), rectangleFactory())
  shapes.foreach(_.draw())
}
