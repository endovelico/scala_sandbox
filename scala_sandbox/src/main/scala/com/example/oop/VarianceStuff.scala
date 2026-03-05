package com.example.oop

import com.example.oop.OverridingMethods.Dog
import com.example.oop.OverridingTypes.Animal

class VarianceStuff extends App {

  class Box[+T](val value: T)

  val dogBox: Box[Dog] = new Box(new Dog)
  //val animalBox: Box[Animal] = dogBox //Valid because Box is covariant

  // Generic with Upper Bound
  class Printer[+T <: Animal](val value: T) {
    def print(): Unit = println(value)
  }

  // Generic with Lower Bound
  def printAnimals[T >: Dog](animals: List[T]): Unit = {
    animals.foreach(println)
  }
}
