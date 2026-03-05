package com.example.basics

object UsingFolds extends App {

  val numbers = List(1, 2, 3, 4, 5)
  val sum = numbers.fold(0)((acc, x) => acc + x)
 println(sum);

}
