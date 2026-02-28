package com.example.basics

class ExceptionHandling {

  // Traditional EH
  try {
    val result = 10 / 0
  } catch {
    case e:ArithmeticException => println("Division by Zero")
  }

  // Safer EH
  import scala.util.Try
  val result = Try(10 / 0)

  result match {
    case scala.util.Success(value) => println(s"Result: $value")
    case scala.util.Failure(exception) => println(s"Error: ${exception.getMessage}")
  }

}
