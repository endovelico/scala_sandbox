package com.example.basics

class CollectionStuff {

  // Array Stuff
  val numbers = Array(1, 2, 3, 4, 5)
  val firstNumber = numbers(0)

  // modification of an element
  numbers(2) = 10

  // List Stuff
  val fruits = List("apple", "banana", "orange")
  val firstFruit = fruits.head
  val remainingFruits = fruits.tail


  // Set Stuff
  // In this example, we create a set of integers, which automatically removes duplicate values. Sets support adding and
  //removing elements efficiently.
  // Creating a set of integers
  val uniqueNumbers = Set(1, 2, 3, 4, 5, 5, 2)
  // Adding and removing elements
  val updatedNumbers = uniqueNumbers + 6
  val removedNumbers = uniqueNumbers - 3

  // Map Stuff
  // Creating a map of student names and their ages
  val ages = Map("Alice" -> 30, "Bob" -> 25, "Carol" -> 35)

  // Accessing values by key
  val aliceAge = ages("Alice")
  // Adding and updating key-value pairs
  val updatedAges = ages + ("David" -> 28)
  val updatedCarolAge = ages.updated("Carol", 36)

  // Using map to double each element
  val doubled = numbers.map(n => n * 2)
  // Using filter to select even numbers
  val evenNumbers = numbers.filter(n => n % 2 == 0)
  // Using reduce to calculate the sum
  val sum = numbers.reduce((x, y) => x + y)
}
