package com.example.basics

class MultipleCatchBlocks {

  // Multiple catch
  try {
    // Code that may throw an exception
    val result = 10/0
  } catch {
    case e: ArithmeticException => println("Division by zero")
    case ex: IllegalArgumentException => println("Invalid argument")
    case _: Exception => println("An error occurred")
  }

  // Testing Finally Block
  try {
    // Code that may throw an exception
    val result = 10 / 0
  } catch {
    case e: ArithmeticException => println("Division by zero")
  } finally {
    // Cleanup code
    println("Cleaning up resources")
  }

}

