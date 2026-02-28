package com.example.design_patterns.structural

class DecoratorPattern {

  trait Coffee {
    def cost(): Double
    def description(): String
  }

  class SimpleCoffee extends Coffee {
    override def cost(): Double = 5.0
    override def description(): String = "Simple Coffee"
  }

  abstract class CoffeeDecorator(coffee: Coffee) extends Coffee {
    override def cost(): Double = coffee.cost()
    override def description(): String = coffee.description()
  }

  class MilkDecorator(coffee: Coffee) extends CoffeeDecorator(coffee) {
    override def cost(): Double = super.cost() + 2.0
    override def description(): String = super.description() + ", Milk"
  }

  class SugarDecorator(coffee: Coffee) extends CoffeeDecorator(coffee) {
    override def cost(): Double = super.cost() + 1.0
    override def description(): String = super.description() + ", Sugar"
  }

  val simple = new SimpleCoffee
  println(simple.description() + " costs " + simple.cost())
  // Simple Coffee costs 5.0

  val milkCoffee = new MilkDecorator(simple)
  println(milkCoffee.description() + " costs " + milkCoffee.cost())
  // Simple Coffee, Milk costs 7.0

  val sugarMilkCoffee = new SugarDecorator(milkCoffee)
  println(sugarMilkCoffee.description() + " costs " + sugarMilkCoffee.cost())
  // Simple Coffee, Milk, Sugar costs 8.0
}
