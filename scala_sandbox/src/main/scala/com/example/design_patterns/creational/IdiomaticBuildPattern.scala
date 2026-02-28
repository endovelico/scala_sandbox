package com.example.design_patterns.creational

class IdiomaticBuildPattern {

  case class Car(make: String = "", model: String = "", year: Int = 0, color: String = "white") {
    def withMake(make: String): Car = copy(make = make)
    def withModel(model: String): Car = copy(model = model)
    def withYear(year: Int): Car = copy(year = year)
    def withColor(color: String): Car = copy(color = color)
  }

  // Usage
  val car = Car()
    .withMake("Tesla")
    .withModel("Model 3")
    .withYear(2023)
    .withColor("Blue")

}
