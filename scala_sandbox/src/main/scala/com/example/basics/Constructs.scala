package com.example.basics

class Constructs {

  // Var declaration
  val age:Int = 30

  val name:String = "Alice"

  var score:Double = 95.5

  var isStudent:Boolean = true

  // Type Inference
  val pi = 3.14159

  val message = "Hello World"

  // Type Conversions
  val x:Int = 10

  val y:Double = x //Automatic type conversion from Int to Double

  val z:Int = y.toInt // Explicit casting

  class Person(firstName: String, lastName: String) {
    val fullName: String = s"$firstName $lastName"
    def greet(): Unit = {
      println(s"Hello, my name is $fullName")
    }
    // Auxiliary constructor
    def this (fullName: String) {
      this (fullName.split(" ")(0), fullName.split(" ")(1))
    }
  }
}
