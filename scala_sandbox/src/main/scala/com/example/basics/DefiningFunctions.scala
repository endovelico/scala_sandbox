package com.example.basics

class DefiningFunctions {

  val numbers = List(1, 2, 3, 4, 5)

  // Defining a function
  def add(x:Int, y:Int):Int = { x + y}

  // Using the function
  val sum = add(5, 3)

  // anon functions
  val increment = (x:Int) => x + 1

  // Using the lambda with Map
  val incrementedNumbers = numbers.map(increment)

  // Creating a list
  val fruits = List("apple", "banana", "orange")

  // Accessing elements by index
  val seconndFruit = fruits(1)

  // Creating a map
  val ages = Map("Alice" -> 30, "Bob" -> 25, "Carol" -> 35)

  // Acessing values by key
  val aliceAge = ages("Alice")
}
