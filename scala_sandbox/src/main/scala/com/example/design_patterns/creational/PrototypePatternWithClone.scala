package com.example.design_patterns.creational

class PrototypePatternWithClone {

  class Person(var name: String, var age: Int) extends Cloneable {
    override def clone(): Person = {
      super.clone().asInstanceOf[Person]
    }
  }

  // Usage
  val original = new Person("Alice", 30)
  val copy = original.clone()
  copy.name = "Bob"

  println(original.name) // Alice
  println(copy.name)     // Bob

}
