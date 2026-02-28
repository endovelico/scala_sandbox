package com.example.basics

class SyntaxStuff {

  val age:Int = 30;
  val name:String = "Lamar Jackson"

  // type inference
  val pi = 3.14159
  val isStudent = true

  val numbers = List(1, 2, 3, 4, 5)

  // use if else
  val result = if(numbers.contains(3)) "Found 3" else "Not found 3"

  // Using pattern matching
  val message = numbers match {
    case Nil => "Empty List"
    case 1 :: _ => "Starts with 1"
    case _ => "Something else"
  }

  // Looping using high order functions
  val doubled = numbers.map(_ * 2)
}
