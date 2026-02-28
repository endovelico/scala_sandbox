package com.example.design_patterns.behavioral

class MediatorPattern {

  trait Mediator {
    def notify(sender: Colleague, event: String): Unit
  }

  abstract class Colleague(protected val mediator: Mediator) {
    def send(event: String): Unit = mediator.notify(this, event)
    def receive(event: String): Unit
  }

  class Button(mediator: Mediator) extends Colleague(mediator) {
    override def receive(event: String): Unit =
      println(s"Button received event: $event")
  }

  class TextBox(mediator: Mediator) extends Colleague(mediator) {
    override def receive(event: String): Unit =
      println(s"TextBox received event: $event")
  }

  class DialogMediator extends Mediator {
    private var button: Option[Button] = None
    private var textBox: Option[TextBox] = None

    def registerButton(b: Button): Unit = button = Some(b)
    def registerTextBox(t: TextBox): Unit = textBox = Some(t)

    override def notify(sender: Colleague, event: String): Unit = sender match {
      case `button`.get => textBox.foreach(_.receive(s"Button triggered: $event"))
      case `textBox`.get => button.foreach(_.receive(s"TextBox triggered: $event"))
      case _ => println("Unknown sender")
    }
  }

  val mediator = new DialogMediator
  val button = new Button(mediator)
  val textBox = new TextBox(mediator)

  mediator.registerButton(button)
  mediator.registerTextBox(textBox)

  button.send("Click")
  // Output: TextBox received event: Button triggered: Click

  textBox.send("TextChanged")
  // Output: Button received event: TextBox triggered: TextChanged
}
