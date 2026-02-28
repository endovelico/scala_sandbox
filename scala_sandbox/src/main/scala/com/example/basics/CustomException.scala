package com.example.basics

class CustomException {

  class MyCustomException(message: String) extends Exception(message)
  def customExceptionHandling(): Unit = {
    try {
      // Code that may throw a custom exception
      throw new MyCustomException("This is a custom exception")
    } catch {
      case e: MyCustomException => println(s"Custom exception caught: ${e.getMessage}")
    }
  }
}
