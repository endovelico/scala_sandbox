package com.example.adt

// In product algebraic data types, we cannot enumerate all the possible values. There are
//usually too many to manually write them. We cannot provide a separate constructor for
//each separate value.

sealed case class RGB(red: Int, green: Int, blue: Int)
object RGBDemo {
  def main(args: Array[String]): Unit = {
    val magenta = RGB(255, 0, 255)
    System.out.println(s"Magenta in RGB is: $magenta")
  }
}