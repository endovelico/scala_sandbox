package com.example.oop

object AuxiliaryConstructors extends App {

  //The primary constructor takes two parameters: name and age, and initializes the Person object.
  //The first auxiliary constructor takes only name as a parameter and sets the age to a default
  //value of 30.
  //The second auxiliary constructor takes no parameters and sets both name and age to default
  //values.

  class Person(val name: String, val age: Int) {

    println(s"Person created: $name, $age years old")

    // Auxiliary constructor with a single argument
    def this(name: String) = {
      this(name, 30)// Default age set to 30
      println(s"Auxiliary constructor: $name, default age 30")
    }

    // Auxiliary constructor with no arguments
    def this() = {
      this("Unknown", 30)// Default name and age
      println("Auxiliary constructor: Unknown, default age 30")
    }}

  //The first object person1 is created using the primary constructor with both name and age
  //parameters.
  //The second object person2 uses the first auxiliary constructor, where only the name is provided,
  //and the age defaults to 30.
  //The third object person3 uses the second auxiliary constructor, where both name and age are
  //set to default values.
  //Creating Objects Using Auxiliary Constructors
  val person1 = new Person("Alice", 25) // Uses primary constructor
  val person2 = new Person("Bob")// Uses auxiliary constructor with a default age
  val person3 = new Person()// Uses auxiliary constructor with default name and age
}
