package com.example.advanced.reftail

object FunctionalComposition extends App {

  val add5:Int => Int = (x:Int) => x + 5
  val multiplyBy2:Int => Int = (x:Int) => x * 2

  val addThenMultiply = add5 andThen multiplyBy2
  val multiplyThenAdd = add5 compose multiplyBy2

  println(addThenMultiply(3))
  println(multiplyThenAdd(4))

}
