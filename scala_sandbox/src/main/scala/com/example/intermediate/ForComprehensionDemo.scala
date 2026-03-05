package com.example.intermediate

class ForComprehensionDemo extends App {

  for {
    elem <- List(1, 2, 3, 4, 5)
  } yield "T" + elem

  for {
    word <- List("Hello", "Scala")
    char <- word
  } yield char.isLower

  for {
    word <- List("Hello again", "Scala")
    char <- word if char.isUpper
  } yield char

}
