package com.example.advanced.reftail

object Currying extends App {

  def add(a:Int)(b:Int):Int = a + b

  val add5 = add(5)_
  println(add5(10))

  val add10 = add(10)_
  println(add10(20))

}
