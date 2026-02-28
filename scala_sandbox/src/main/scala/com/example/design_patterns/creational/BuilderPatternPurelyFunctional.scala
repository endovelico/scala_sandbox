package com.example.design_patterns.creational

class BuilderPatternPurelyFunctional {

  case class Car(make: String, model: String, year: Int, color: String)

  object CarBuilder {
    def build(
               make: String = "",
               model: String = "",
               year: Int = 0,
               color: String = "white"
             ): Car = Car(make, model, year, color)
  }

  // Usage
  val car = CarBuilder.build(
    make = "Tesla",
    model = "Model X",
    year = 2023,
    color = "Black"
  )
}