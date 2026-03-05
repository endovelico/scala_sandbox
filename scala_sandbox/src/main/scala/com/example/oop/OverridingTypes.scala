package com.example.oop

object OverridingTypes {

  class Animal {
    def sound(): String = "Generic animal sound"
  }
  class Dog extends Animal {
    override def sound(): String = "Bark"
  }
  class Cat extends Animal {
    override def sound(): String = "Meow"
  }
  val dog = new Dog
  val cat = new Cat
  println(dog.sound()) // Output: Bark
  println(cat.sound()) // Output: Meow
}
