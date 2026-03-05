package com.example.oop

object ExampleOfCompanionObject extends App {

  //Circle is a class that has a method area() to calculate the area of a circle.
  //The companion object Circle is defined with the same name as the class.
  //The apply() method in the companion object is a factory method that allows you to create
  //instances of Circle more concisely.
  //The describe() method is a simple utility method that provides a description of the class. 

  class Circle(val radius: Double) {
    def area(): Double = Math.PI * radius * radius
  }

  object Circle {
    def apply(radius: Double): Circle = new Circle(radius)
    def describe(): String = "This is a Circle class."
  }

}
