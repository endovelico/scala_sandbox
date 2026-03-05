package com.example.oop

class Person(val name: String, val age: Int) {
  def greet(): String = s"Hello, my name is $name and I am $age years old."
}

object PersonSamples extends App {

  // Creating an instance
  val personInstance = new Person("Alice", 30)
  println(personInstance.greet()) // Output: Hello, my name is Alice and I am 30 years old.

  
}