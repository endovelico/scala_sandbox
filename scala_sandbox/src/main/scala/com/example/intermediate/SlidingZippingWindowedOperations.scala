package com.example.intermediate

object SlidingZippingWindowedOperations extends App {

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
  val slidingWindows = numbers.sliding(3).toList
  println(slidingWindows)

  val slidingWithStep = numbers.sliding(3, 2).toList
  println(slidingWithStep)

  val list1 = List(1, 2, 3)
  val list2 = List(4, 5, 6)
  val zipped = list1.zip(list2)
  println(zipped)

  // In this example, zipWithIndex creates a list of tuples where the first element is the original list
  //item, and the second element is the index of that item in the list.
  val zippedWithIndex = numbers.zipWithIndex
  println(zippedWithIndex)

  //grouped is another method that is similar to sliding but differs in that it groups the elements
  //without overlapping, creating distinct sublists. If you need to split a collection into non
  //overlapping chunks of a specified size, grouped is a great option. 
  val grouped = numbers.grouped(3).toList
  println(grouped)
}
