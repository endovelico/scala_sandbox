package com.example.intermediate

object TryAndOption extends App {

  // Safe Try - Option
  def safeParseInt(str: String): Option[Int] =
    try {
      Some(str.toInt)
    } catch {
      case _: NumberFormatException => None
    }

  def processStrings(strings: List[String]): List[Option[Int]] =
    strings.map(safeParseInt)

  val input = List("10", "20", "invalid", "30")

  val result = processStrings(input)

  println(result)
  // Output: List(Some(10), Some(20), None, Some(30))

  import scala.util.{Try, Success, Failure}
  def readData(filePath: String): Try[String] =
    Try(scala.io.Source.fromFile(filePath).mkString)
  def parseData(data: String): Option[Int] =
    try {
      Some(data.toInt)
    } catch {
      case _: NumberFormatException => None
    }
  def processData(filePath: String): Try[Option[Int]] =
    for {
      content <- readData(filePath)
      parsed <- Try(parseData(content))
    } yield parsed

  def processDataWithDefault(filePath: String): Int = {
    processData(filePath) match {
      case Success(Some(value)) => value
      case Success(None) => 0 // Default value for missing data
      case Failure(_) => 0 // Default value for error
    }
  }


}
