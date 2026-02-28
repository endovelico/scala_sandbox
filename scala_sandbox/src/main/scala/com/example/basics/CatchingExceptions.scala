package com.example.basics

class CatchingExceptions {

  try {
    // Code that may throw an exception
    val result = 10 / 0
  } catch {
    case e: ArithmeticException => println("Division by zero")
    case ex: Exception => println(s"An error occurred: ${ex.getMessage}")
  }
}
