package com.example

import com.example.basics.ControlStructures

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
    val cs = new ControlStructures()

    println(cs.result)
    println(cs.message)
    println(cs.douubled)
    println(cs.evenNumbers)
  }
}