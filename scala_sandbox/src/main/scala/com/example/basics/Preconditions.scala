package com.example.basics

import com.example.from_books.Rational

object PreconditionsExample extends App {

  val numero:Int = 0
  require(numero > 0, "Number must be positive larger than zero")
}