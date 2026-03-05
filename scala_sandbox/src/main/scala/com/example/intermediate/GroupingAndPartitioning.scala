package com.example.intermediate

object GroupingAndPartitioning extends App {

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
  val groupedByEvenOdd = numbers.groupBy(num => if (num % 2 == 0) "Even" else "Odd")
  println(groupedByEvenOdd)

  val (greaterThanFive, lessThanOrEqualToFive) = numbers.partition(_ > 5)
  println(greaterThanFive)
  println(lessThanOrEqualToFive)

  case class Person(name: String, age: Int)
  val people = List(Person("Alice", 25), Person("Bob", 17), Person("Charlie", 30))
  val (adults, minors) = people.partition(_.age >= 18)
  println(adults)
  println(minors)
}
