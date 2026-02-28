package com.example.design_patterns.creational

private class ClassicBuildPattern {

  class Car private (
                      val make: String,
                      val model: String,
                      val year: Int,
                      val color: String
                    )

  object Car {
    class Builder {
      private var make: String = _
      private var model: String = _
      private var year: Int = 0
      private var color: String = "white"

      def setMake(make: String): Builder = { this.make = make; this }
      def setModel(model: String): Builder = { this.model = model; this }
      def setYear(year: Int): Builder = { this.year = year; this }
      def setColor(color: String): Builder = { this.color = color; this }

      def build(): Car = new Car(make, model, year, color)
    }
  }

  // Usage
  val car = new Car.Builder()
    .setMake("Tesla")
    .setModel("Model S")
    .setYear(2023)
    .setColor("Red")
    .build()
}
