package com.example.advanced.reftail

object FunctionCompositionWithCurry extends App {

  def multiply(a:Int)(b:Int):Int = a * b
  def add(a:Int)(b:Int):Int = a + b

  val multiplyBy2 = multiply(2)_
  val add5 = add(5)_

  val combined = multiplyBy2 andThen add5

  println(combined(3))
}
