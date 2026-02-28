package com.example.basics

class Animal {
  def speak(): Unit = {
    println("Animal speaks")
  }
}

class Dog extends Animal {
  override def speak(): Unit = {
    println("Dog barks")
  }
}

class TryingItOut {
  val dog = new Dog()
  dog.speak() // Prints "Dog barks"
}