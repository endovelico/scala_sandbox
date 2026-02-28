package com.example.design_patterns.behavioral

class TemplatePattern {

  abstract class Game {
    // template method
    def play(): Unit = {
      initialize()
      startPlay()
      endPlay()
    }

    def initialize(): Unit
    def startPlay(): Unit
    def endPlay(): Unit
  }

  class Football extends Game {
    override def initialize(): Unit = println("Football Game Initialized! Start playing.")
    override def startPlay(): Unit = println("Football Game Started. Enjoy the game!")
    override def endPlay(): Unit = println("Football Game Finished!")
  }

  class Cricket extends Game {
    override def initialize(): Unit = println("Cricket Game Initialized! Ready to play.")
    override def startPlay(): Unit = println("Cricket Game Started. Enjoy the game!")
    override def endPlay(): Unit = println("Cricket Game Finished!")
  }

  val football = new Football
  football.play()
  // Output:
  // Football Game Initialized! Start playing.
  // Football Game Started. Enjoy the game!
  // Football Game Finished!

  val cricket = new Cricket
  cricket.play()
  // Output:
  // Cricket Game Initialized! Ready to play.
  // Cricket Game Started. Enjoy the game!
  // Cricket Game Finished!

}
