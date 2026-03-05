package com.example.intermediate

object FlatMapDemo extends App {

  val words = List("apple", "banana", "cherry")
  val chars = words.flatMap(word => word.toList)
  println(chars)

  val options = List(Some(1), None, Some(2), Some(3))
  val flattened = options.flatMap(x => x)
  println(flattened)

  val map = Map("a" -> List(1, 2), "b" -> List(3, 4), "c" -> List(5))
  val flattenedMap = map.flatMap { case (key, values) => values.map(v => (key, v)) }
  println(flattenedMap)
}
