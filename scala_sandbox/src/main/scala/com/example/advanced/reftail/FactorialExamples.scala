package com.example.advanced.reftail
import scala.annotation.tailrec

class FactorialExamples {

  object FactorialExample extends App {

    @tailrec
    def factorial(n: Int, acc: BigInt = 1): BigInt = {
      if (n <= 1) acc
      else factorial(n - 1, n * acc)  // recursive call is last → tail call
    }

    println(factorial(5)) // 120


  // commented @tailrec because this will triger compiler errors
  // @tailrec
  def factorialBad(n: Int): BigInt = {
    if (n <= 1) 1
    else n * factorialBad(n - 1)  // ❌ NOT tail-recursive
  }

  }

}
