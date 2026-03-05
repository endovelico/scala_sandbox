package com.example.intermediate

object CollectOperator extends App {

  val numbers = List(1, 2, 3, 4, 5, 6)
  val doubledEvens = numbers.collect { case x if x % 2 == 0 => x * 2 }
  println(doubledEvens)

}
