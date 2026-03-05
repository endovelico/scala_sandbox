package com.example.intermediate

object PatternMatching extends App {

  case class Person(name: String, age: Int)

  case class Address(city: String, country: String)

  val person = Person("Alice", 25)
  person match {
    case Person(name, age) => println(s"Name: $name, Age: $age")
    case _ => println("Unknown person")
  }

  /*val person2 = Person("John", Address("London", "UK"))
  person2 match {
    case Person(name, Address(city, country)) =>
      println(s"Name: $name, City: $city, Country: $country")
    case _ => println("Unknown person")
  }*/

  person match {
    case Person(name, age) if age >= 18 =>
      println(s"$name is an adult, Age: $age")
    case Person(name, age) if age < 18 =>
      println(s"$name is a minor, Age: $age")
    case _ => println("Unknown person")
  }

  val person3 = Person("Bob", 30)

  person3 match {
    case Person(name, age) if age >= 18 =>
      println(s"$name is an adult, Age: $age")
    case Person(name, age) if age < 18 =>
      println(s"$name is a minor, Age: $age")
    case _ => println("Unknown person")
  }

  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
  val shape: Shape = Rectangle(10, 20)
  shape match {
    case Circle(radius) => println(s"Circle with radius: $radius")
    case Rectangle(width, height) => println(s"Rectangle with width $width and height $height")
    case _ => println("Unknown shape")
  }
}

