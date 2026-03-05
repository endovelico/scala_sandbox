package com.example.oop

object GenericsDemo extends App {

  class Box[T](val value: T) {
    def getValue: T = value
  }

  def swap[T](a: T, b: T): (T, T) = (b, a)
  val swappedInts = swap(1, 2)// (2, 1)
  val swappedStrings = swap("a", "b") // ("b", "a")

  val intBox = new Box(42) // Box[Int]
  val stringBox = new Box("Scala") // Box[String]
}
