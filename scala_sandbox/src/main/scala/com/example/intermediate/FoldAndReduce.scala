package com.example.intermediate

object FoldAndReduce extends App {

  val numbers = List(1, 2, 3, 4, 5)
  val sum = numbers.reduce(_ + _)
  println(sum)

  //This approach is more flexible than reduce because it allows specifying a starting point (in this
  //case, 0).
  val sumWithFold = numbers.fold(0)(_ + _)
  println(sumWithFold)

}
