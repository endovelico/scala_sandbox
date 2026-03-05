package com.example.intermediate

object MapsStuff extends App {

  val studentGrades = Map("Alice" -> 85, "Bob" -> 92, "Charlie" -> 78)

  import scala.collection.mutable.Map
  val mutableGrades = Map("Alice" -> 85, "Bob" -> 92)
  mutableGrades("Charlie") = 78 // Adding an entry to the mutable map

  val aliceGrade = studentGrades("Alice") // 85
  val keys = studentGrades.keys // Set("Alice", "Bob", "Charlie")
  val values = studentGrades.values // Iterable(85, 92, 78)
  val hasBob = studentGrades.contains("Bob") // true

  val updatedGrades = studentGrades.map { case (key, value) => (key, value + 5) }
  println(updatedGrades) // Map(Alice -> 90, Bob -> 97, Charlie -> 83)

  val highGrades = studentGrades.filter { case (key, value) => value > 80 }
  println(highGrades) // Map(Alice -> 85, Bob -> 92)

  val moreGrades = Map("David" -> 88)
  val combinedGrades = studentGrades ++ moreGrades
  println(combinedGrades) // Map(Alice -> 85, Bob -> 92, Charlie -> 78, David -> 88)

  val capitalizedKeys = studentGrades.map { case (key, value) => (key.toUpperCase, value) }
  println(capitalizedKeys) // Map(ALICE -> 85, BOB -> 92, CHARLIE -> 78)

  val increasedGrades = studentGrades.map { case (key, value) => (key, value + 5) }
  println(increasedGrades) // Map(Alice -> 90, Bob -> 97, Charlie -> 83)
}
