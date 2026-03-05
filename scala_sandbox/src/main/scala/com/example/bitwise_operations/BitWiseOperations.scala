package com.example.bitwise_operations

object BitWiseOperations extends App {

  // Masks
  val READ    = 1 << 0   // 0001
  val WRITE   = 1 << 1   // 0010
  val EXECUTE = 1 << 2   // 0100
  val ADMIN   = 1 << 3   // 1000

  val x = 60 // 0011 1100
  val y = 13 // 0000 1101

  println(x & y) // 0000 1100
  println(x | y) // 0011 1101
  println(x ^ y) // 0011 0001
  println(~x) // -61
  println(x << 2) // 1111 0000
  println(x >> 2) // 11111


}

class Flags {

  val LOGGING  = 1 << 0
  val CACHING  = 1 << 1
  val SECURITY = 1 << 2

  def enable(flags: Int, feature: Int) =
    flags | feature

  def disable(flags: Int, feature: Int) =
    flags & ~feature

  def isEnabled(flags: Int, feature: Int) =
    (flags & feature) != 0
}

object FlagsApp extends App {

  val flags = new Flags

  var config = 0

  config = flags.enable(config, flags.LOGGING)
  config = flags.enable(config, flags.CACHING)

  println(flags.isEnabled(config, flags.LOGGING))
}