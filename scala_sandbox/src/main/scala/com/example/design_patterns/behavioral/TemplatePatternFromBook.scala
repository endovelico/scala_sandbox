package com.example.design_patterns.behavioral

/*import java.io.{ByteArrayInputStream, InputStreamReader}
import com.github.tototoshi.csv.CSVReader
import org.json4s.{DefaultFormats}
import org.json4s.jackson.JsonMethods

case class Person(name: String, age: Int, address: String)

abstract class DataFinder[T, Y] {

  def find(f: T => Option[Y]): Option[Y] =
    try {
      val data = readData()
      val parsed = parse(data)
      f(parsed)
    } finally {
      cleanup()
    }

  def readData(): Array[Byte]

  def parse(data: Array[Byte]): T

  def cleanup(): Unit
}

class JsonDataFinder extends DataFinder[List[Person], Person] {

  implicit val formats: DefaultFormats.type = DefaultFormats

  override def readData(): Array[Byte] = {
    val stream = this.getClass.getResourceAsStream("/people.json")
    Stream.continually(stream.read)
      .takeWhile(_ != -1)
      .map(_.toByte)
      .toArray
  }

  override def cleanup(): Unit =
    println("Reading json: nothing to do.")

  override def parse(data: Array[Byte]): List[Person] =
    JsonMethods.parse(new String(data, "UTF-8")).extract[List[Person]]
}

class CSVDataFinder extends DataFinder[List[Person], Person] {

  override def readData(): Array[Byte] = {
    val stream = this.getClass.getResourceAsStream("/people.csv")
    Stream.continually(stream.read)
      .takeWhile(_ != -1)
      .map(_.toByte)
      .toArray
  }

  override def cleanup(): Unit =
    println("Reading csv: nothing to do.")

  override def parse(data: Array[Byte]): List[Person] =
    CSVReader
      .open(new InputStreamReader(new ByteArrayInputStream(data)))
      .all()
      .map {
        case List(name, age, address) =>
          Person(name, age.toInt, address)
      }
}

object DataFinderExample {

  def main(args: Array[String]): Unit = {

    val jsonDataFinder: DataFinder[List[Person], Person] =
      new JsonDataFinder

    val csvDataFinder: DataFinder[List[Person], Person] =
      new CSVDataFinder

    println(
      s"Find a person with name Ivan in the json: ${jsonDataFinder.find(_.find(_.name == "Ivan"))}"
    )

    println(
      s"Find a person with name James in the json: ${jsonDataFinder.find(_.find(_.name == "James"))}"
    )

    println(
      s"Find a person with name Maria in the csv: ${csvDataFinder.find(_.find(_.name == "Maria"))}"
    )

    println(
      s"Find a person with name Alice in the csv: ${csvDataFinder.find(_.find(_.name == "Alice"))}"
    )
  }
}*/