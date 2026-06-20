package com.example.design_patterns.pimp_my_library

object StringPimp extends App {
  implicit class RichString(val s: String) extends AnyVal {
    def shout: String = s.toUpperCase + "!!!"
  }

  val excited = "hello".shout  // "HELLO!!!"
}
