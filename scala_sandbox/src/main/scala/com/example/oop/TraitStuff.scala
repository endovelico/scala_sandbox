package com.example.oop

object TraitStuff extends App {

  trait Animal {
    def sound(): String}
  trait Walker {
    def walk(): String = "Walking"
  }
  class Dog extends Animal with Walker {
    def sound(): String = "Bark"
  }
  val dog = new Dog
  println(dog.sound()) // Output: Bark
  println(dog.walk())// Output: Walking
}
