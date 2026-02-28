package com.example.intermediate

class ObjectedOriented {

  // Define a class Person
  class Person(firstName: String, lastName: String) {
    // Class fields (properties)
    val fullName: String = s"$firstName $lastName"
    // Class methods (behaviors)
    def greet(): Unit = {
      println(s"Hello, my name is $fullName")
    }
  }

  // Create an instance of the Person class
  val person1 = new Person("Alice", "Smith")
  // Accessing fields and methods

  println(person1.fullName) // Prints "Alice Smith"
  person1.greet() // Prints "Hello, my name is Alice Smith"
}
