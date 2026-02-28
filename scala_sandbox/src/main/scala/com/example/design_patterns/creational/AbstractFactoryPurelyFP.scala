package com.example.design_patterns.creational

private class AbstractFactoryPurelyFP {

  trait Button {
    def paint(): Unit
  }

  trait Checkbox {
    def paint(): Unit
  }

  trait WidgetFactory {
    def createButton(): Button
    def createCheckbox(): Checkbox
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

  class LightFactory extends WidgetFactory {
    def createButton(): Button = new LightButton
    def createCheckbox(): Checkbox = new LightCheckbox
  }

  // Dark theme factory
  class DarkFactory extends WidgetFactory {
    def createButton(): Button = new DarkButton
    def createCheckbox(): Checkbox = new DarkCheckbox
  }

  object WidgetFactory {
    def light: WidgetFactory = new LightFactory
    def dark: WidgetFactory = new DarkFactory
  }


  val buttonFactory: () => Button = () => new LightButton
  val checkboxFactory: () => Checkbox = () => new LightCheckbox

  val button = buttonFactory()
  val checkbox = checkboxFactory()
  button.paint()
  checkbox.paint()

}
