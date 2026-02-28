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

  // Defining and using functions
  def greet(name:String):String = { s"Hello, $name"}

  // Function Invocation
  val message = greet("Alice")

  // Function Parameters
  def addition(x:Int, y:Int):Int = {
    x + y
  }

  // Function with default parameters
  def greet(name:String, greeting:String = "Hello"):String = { s"$greeting, $name" }

  val message2 = greet("Lamar")
  val message3 = greet(name="Lamar", greeting="Howdy")

  // Anon functions
  val addOne = (x:Int) => x + 1

  // Lambda with map
  val yetAnotherNumbers = List(1, 2, 3, 4, 5)
  val yetIncrementedNumbers = yetAnotherNumbers.map(addOne)

  // Higher Order Functions
  def operateOnNumbers(x:Int, y:Int, operation:(Int, Int) => Int):Int = {
    operation(x, y)
  }

  val highOrderResult = operateOnNumbers(5, 3, (a, b) => a * b)
}
