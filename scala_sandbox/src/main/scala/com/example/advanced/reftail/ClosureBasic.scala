package com.example.advanced.reftail

trait ClosureBasic extends App {

  val multiplier = 2
  val multiply = (x:Int) => x * multiplier
  println(multiply(5))

  var counter = 0
  val increment = () => { counter += 1 }
  increment()
  increment()
  println(counter)

  def outerFunction():Int = {
    def innerfunction(x:Int):Int = x * 2
      innerfunction(5)
  }

  println(outerFunction())

}
