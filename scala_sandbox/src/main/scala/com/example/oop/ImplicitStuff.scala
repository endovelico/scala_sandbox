package com.example.oop

object ImplicitStuff extends App {

  // Implicit class to add a method to String
  implicit class StringOps(s: String) {
    def isPalindrome: Boolean = s == s.reverse
  }

  implicit class IntOps(n: Int) {
    def square: Int = n * n
  }

  //implicit def stringToInt(s: String): Int = s.toInt

  val result = "madam".isPalindrome // true
  println(result)

  val squaredValue = 5.square // 25
  println(squaredValue)

  val number = "123" + 456 // Automatically converts "123" to an Int
  println(number) // Output: 579


}
