package com.example.design_patterns.structural

class AdapterPatternWithComposition {

  class OldPrinter {
    def printText(text: String): Unit = println(s"Old Printer: $text")
  }

  trait Printer {
    def print(content: String): Unit
  }

  class PrinterAdapter(oldPrinter: OldPrinter) extends Printer {
    override def print(content: String): Unit = oldPrinter.printText(content)
  }

  // Usage
  val oldPrinter = new OldPrinter()
  val printer: Printer = new PrinterAdapter(oldPrinter)

  printer.print("Hello Scala!") // Output: Old Printer: Hello Scala!

}
