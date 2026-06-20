package com.example.design_patterns.structural

// Target interface
trait Printer {
  def print(text: String): Unit
}

// Adaptee
trait LegacyPrinter {
  def printLegacy(text: String): Unit =
    println(s"[LEGACY] $text")
}

// Class Adapter
class PrinterAdapter extends Printer with LegacyPrinter {

  override def print(text: String): Unit =
    printLegacy(text)

}

// Client
object Main extends App {
  val printer: Printer = new PrinterAdapter
  printer.print("Hello Adapter")
}
