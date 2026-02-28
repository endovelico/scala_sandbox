package com.example.basics

class AccessModifiers {

  private val privateField = "Private Field"
  protected val protectedField = "Protected Field"
  val publicField = "Public Field"

}

class SubAccessModifiers extends AccessModifiers {
  def accessFields(): Unit = {
    //println(privateField) // Error: privateField is not accessible
    println(protectedField) // Accessible, as it's protected
    println(publicField) // Accessible, as it's public
  }
}