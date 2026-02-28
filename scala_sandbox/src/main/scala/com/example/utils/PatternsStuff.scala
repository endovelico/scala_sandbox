package com.example.utils

class PatternsStuff {

  // Using regex wth R strings
  val numPattern = "[0-9]+".r;
  val address:String = "123 Address Street Main"
  val match1 = numPattern.findFirstIn(address)

  // Using Regex with imports
  import scala.util.matching.Regex
  val numPatternTwo = new Regex("[0-9]+]")
  val addressTwo:String = "Some Other address 1123"
  val match2 = numPatternTwo.findFirstIn(addressTwo)

}
