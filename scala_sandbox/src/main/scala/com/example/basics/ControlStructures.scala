package com.example.basics

class ControlStructures {

  val x = 10

  if(x > 5) {
    println("x is greater than 5")
  } else {
    println("x is not greater than 5")
  }

  val result = if(x > 5) "x is greater than 5" else "x is not greater than 5"

  // Pattern Matching
  val day = "Wednesday"

  val message = day match {
    case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Weekday"
    case "Saturday" | "Sunday" => "Weekend"
    case _ => "Unknown"
  }

  // Loop with for comprehensions
  val numbers = List(1, 2, 3, 4, 5, 6)
  val douubled = for (n <- numbers) yield n * 2

  val evenNumbers = for (n <- numbers if n % 2 == 0) yield n

  // while loops
  var count = 0
  while(count < 5) {
    println(s"Count:$count")
    count +=1
  }

  // Control Struts and FP
  val squared = numbers.map(n => n * n)
  val evenSquared = squared.filter(n => n % 2 == 0)
  val sum = evenSquared.reduce((x, y) => x + y)
}
