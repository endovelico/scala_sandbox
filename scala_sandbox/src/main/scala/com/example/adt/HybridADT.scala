package com.example.adt

//Hybrid algebraic data types represent a combination of the sum and product ones we
//described previously. This means that we can have specific value constructors, but these
//value constructors also provide parameters in order to wrap other types.

sealed abstract trait Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(height: Double, width: Double) extends Shape
