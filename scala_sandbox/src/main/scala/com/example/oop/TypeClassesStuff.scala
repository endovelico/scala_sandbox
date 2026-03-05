package com.example.oop

object TypeClassesStuff {

  // 1. Define the type class
  trait Show[T] {
    def show(value: T): String
  }

  // 2. Implement type class for Int
  implicit val intShow: Show[Int] = new Show[Int] {
    def show(value: Int): String = value.toString
  }

  // 3. Implement type class for String
  implicit val stringShow: Show[String] = new Show[String] {
    def show(value: String): String = s""""$value""""
  }

  // 4. Generic function that works for any T with a Show[T] instance
  def printShow[T](x: T)(implicit sh: Show[T]): Unit = {
    println(sh.show(x))
  }

  // Usage
  printShow(42)       // Output: 42
  printShow("Hello")  // Output: "Hello"

  // ------ Lets now do a Type Class for Equality
  trait Equal[A] {
    def equal(a1: A, a2: A): Boolean
  }

  // Instance for Int
  implicit object EqualInt extends Equal[Int] {
    def equal(a1: Int, a2: Int): Boolean = a1 == a2
  }
  // Instance for String
  implicit object EqualString extends Equal[String] {
    def equal(a1: String, a2: String): Boolean = a1 == a2
  }



}
