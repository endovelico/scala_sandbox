package com.example.design_patterns.creational

class AbstractFactory {

  trait Button {
    def paint(): Unit
  }

  trait Checkbox {
    def paint(): Unit
  }

  // Light theme products
  class LightButton extends Button {
    def paint(): Unit = println("Painting a Light Button")
  }

  class LightCheckbox extends Checkbox {
    def paint(): Unit = println("Painting a Light Checkbox")
  }

  // Dark theme products
  class DarkButton extends Button {
    def paint(): Unit = println("Painting a Dark Button")
  }

  class DarkCheckbox extends Checkbox {
    def paint(): Unit = println("Painting a Dark Checkbox")
  }

  trait WidgetFactory {
    def createButton(): Button
    def createCheckbox(): Checkbox
  }

  // Light theme factory
  class LightFactory extends WidgetFactory {
    def createButton(): Button = new LightButton
    def createCheckbox(): Checkbox = new LightCheckbox
  }

  // Dark theme factory
  class DarkFactory extends WidgetFactory {
    def createButton(): Button = new DarkButton
    def createCheckbox(): Checkbox = new DarkCheckbox
  }

  object Client extends App {
    def render(factory: WidgetFactory): Unit = {
      val button = factory.createButton()
      val checkbox = factory.createCheckbox()
      button.paint()
      checkbox.paint()
    }

    println("Using Light Theme:")
    render(new LightFactory)

    println("\nUsing Dark Theme:")
    render(new DarkFactory)
  }
}
