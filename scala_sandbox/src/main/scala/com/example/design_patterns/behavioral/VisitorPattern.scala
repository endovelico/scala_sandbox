package com.example.design_patterns.behavioral

class VisitorPattern {

  trait Visitor {
    def visit(book: Book): Unit
    def visit(fruit: Fruit): Unit
  }

  trait Item {
    def accept(visitor: Visitor): Unit
  }

  class Book(val title: String, val price: Double) extends Item {
    override def accept(visitor: Visitor): Unit = visitor.visit(this)
  }

  class Fruit(val name: String, val weight: Double, val pricePerKg: Double) extends Item {
    override def accept(visitor: Visitor): Unit = visitor.visit(this)
  }

  class PriceCalculator extends Visitor {
    private var total: Double = 0.0

    override def visit(book: Book): Unit = {
      total += book.price
    }

    override def visit(fruit: Fruit): Unit = {
      total += fruit.weight * fruit.pricePerKg
    }

    def getTotal: Double = total
  }
  val items: List[Item] = List(
    new Book("Scala Design Patterns", 40.0),
    new Fruit("Apple", 2.0, 3.0),
    new Fruit("Banana", 1.5, 2.5)
  )

  val calculator = new PriceCalculator

  items.foreach(_.accept(calculator))

  println(s"Total price: ${calculator.getTotal}")

}
