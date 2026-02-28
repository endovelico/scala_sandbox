package com.example.design_patterns.creational

class PrototypePatternWithCaseClasses {
  case class Person(name: String, age: Int)

  // Prototype
  val alice = Person("Alice", 30)

  // Clone with modification
  val bob = alice.copy(name = "Bob")

  println(alice) // Person(Alice,30)
  println(bob)   // Person(Bob,30)
}
