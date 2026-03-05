package com.example.intermediate

object LivingWithoutBreakAndContinue extends App {

  def findIndexOf(array:Array[Int], target:Int):Int = {

    for(i <- 0 until array.length) {

      if (array(i) == target) {
        return i
      }
    }
    -1
  }

  // You can use a guard to avoid iteration
  for(i <- 0 until 10 ) {

    if(i % 2 == 0) {
      println(s"Skippint iteration $i")
    } else {
      println(s"Processing iteration $i")
    }
  }


}
