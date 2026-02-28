package com.example.design_patterns.structural

class AdapterPatternWithImplicitConversion {

  class OldPrinter {
    def printText(text: String): Unit = println(s"Old Printer: $text")
  }

  trait Printer {
    def print(content: String): Unit
  }

  class PrinterAdapter(oldPrinter: OldPrinter) extends Printer {
    override def print(content: String): Unit = oldPrinter.printText(content)
  }

  object AdapterImplicits {
    implicit def oldPrinterToPrinter(oldPrinter: OldPrinter): Printer =
      new PrinterAdapter(oldPrinter)
  }

  // Usage
  import AdapterImplicits._

  val oldPrinter = new OldPrinter()
  val printer: Printer = oldPrinter // Automatically adapted

  printer.print("Hello with implicit!") // Old Printer: Hello with implicit!
}
