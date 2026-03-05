package com.example.intermediate

object SealedStuff extends App {

  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape



}
