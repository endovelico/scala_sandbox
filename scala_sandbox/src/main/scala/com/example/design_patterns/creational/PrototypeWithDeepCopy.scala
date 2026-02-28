package com.example.design_patterns.creational

class PrototypeWithDeepCopy {

  case class Address(city: String)
  case class Employee(name: String, address: Address)

  val original = Employee("Alice", Address("New York"))

  // Deep copy
  val copy = original.copy(address = original.address.copy())

  //copy.address.city = "San Francisco"

  println(original.address.city) // New York
  println(copy.address.city)     // San Francisco
}
