package com.example.design_patterns.behavioral

trait State[T] {

  def press(context:T)
}

class Playing extends State[MediaPlayer] {

  override def press(context:MediaPlayer):Unit = {

    println("Pressing Pause")
    context.setState(new Paused())
  }
}

class Paused extends State[MediaPlayer] {

  override def press(context: MediaPlayer):Unit = {

    println("Pressing Play")
    context.setState("New Playing")
  }
}

case class MediaPlayer() {

  var state:State[MediaPlayer] = new Paused

  def pressPlayOrPauseButton(): Unit = {

    state.press(this)
  }

  def setState(paused: Paused): Unit = state
}

object MediaPlayerExample {
  def main(args: Array[String]): Unit = {
    val player = MediaPlayer()
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
    player.pressPlayOrPauseButton()
  }
}