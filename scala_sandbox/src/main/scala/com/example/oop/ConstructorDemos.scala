package com.example.oop

object ConstructorDemos extends App {

  class Rectangle(val width: Int, val height: Int) {
    def this(size: Int) = this(size, size) // Auxiliary constructor for square
    def area(): Int = width * height
  }

  val rect = new Rectangle(4, 5)
  val square = new Rectangle(4) // Calls the auxiliary constructor

  println(rect.area())// Output: 20
  println(square.area()) // Output: 16
}
