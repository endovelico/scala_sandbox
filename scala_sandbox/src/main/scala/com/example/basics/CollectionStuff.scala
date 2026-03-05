package com.example.basics

object CollectionStuff extends App {

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

  val users = List("Alice", "Charlie", "Bob", "Eve")
  val result = users
    .filter(name => name.length > 4)
    .map(name => name.toUpperCase)
    .distinct;

  println(result);

  val scores = List(List(10, 20, 30), List(15, 25, 35), List(20, 30, 40))
  val totalScores = scores
    .map(studentScores => studentScores.reduce((a, b) => a + b));

  println(totalScores)

  case class Employee(name:String, age:Int, projects:List[String])

  val employees = List(
    Employee("Alice", 35, List("Project A", "Project B")),
    Employee("Bob", 28, List("Project C", "Project A")),
    Employee("Charlie", 40, List("Project D, Project A"))
  )

  val employee_result = employees.filter(_.age > 30).flatMap(_.projects).map(_.toUpperCase()).distinct;

  println(employee_result)

}
