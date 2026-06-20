package com.example.design_patterns.structural

// Target interface
trait JsonLogger {
  def log(message: String): String
}

// Adaptee (existing incompatible class)
class XmlLogger {
  def logXml(message: String): String =
    s"<log>$message</log>"
}

// Object Adapter
class XmlToJsonLoggerAdapter(xmlLogger: XmlLogger) extends JsonLogger {

  def log(message: String): String = {
    val xml = xmlLogger.logXml(message)
    s"""{ "log": "$message" }"""
  }
}

// Client
object Main extends App {
  val xmlLogger = new XmlLogger
  val logger: JsonLogger = new XmlToJsonLoggerAdapter(xmlLogger)

  println(logger.log("Hello"))
}