package com.example.advanced.reftail.appending_operators

class AppendingOperatorExamples {

  class consExamples {

    val lst = List(1,2,3)
    lst match {
      case h :: t => println(h) // 1
        println(t) // List(2, 3)
      case Nil => println("empty")
    }
  }


  class appendExample {

    val numbers = List(1, 2, 3)
    println("Original list: " + numbers)

    // Append 4 to the end of the list
    val newNumbers = numbers :+ 4

    println("After appending 4: " + newNumbers)
  }

}
