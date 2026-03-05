package com.example.intermediate

object TuplesStuff extends App {

  val personTuple: (String, Int, Boolean) = ("Alice", 30, true)

  // Accessing tupple elements
  val name = personTuple._1// "Alice"
  val age = personTuple._2// 30
  val isStudent = personTuple._3 // true
}
