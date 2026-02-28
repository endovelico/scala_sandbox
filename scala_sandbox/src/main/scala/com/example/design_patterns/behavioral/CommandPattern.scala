package com.example.design_patterns.behavioral

class CommandPattern {

  trait Command {
    def execute(): Unit
  }

  class Light {
    def on(): Unit = println("Light is ON")
    def off(): Unit = println("Light is OFF")
  }

  class TurnOnLightCommand(light: Light) extends Command {
    override def execute(): Unit = light.on()
  }

  class TurnOffLightCommand(light: Light) extends Command {
    override def execute(): Unit = light.off()
  }

  class RemoteControl {
    private var command: Option[Command] = None

    def setCommand(cmd: Command): Unit = command = Some(cmd)
    def pressButton(): Unit = command.foreach(_.execute())
  }

  val light = new Light
  val turnOn = new TurnOnLightCommand(light)
  val turnOff = new TurnOffLightCommand(light)

  val remote = new RemoteControl

  remote.setCommand(turnOn)
  remote.pressButton()
  // Output: Light is ON

  remote.setCommand(turnOff)
  remote.pressButton()
  // Output: Light is OFF

}
