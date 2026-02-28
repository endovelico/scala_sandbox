package com.example.design_patterns.structural

class FacadePattern {

  class Amplifier {
    def on(): Unit = println("Amplifier on")
    def off(): Unit = println("Amplifier off")
    def setVolume(level: Int): Unit = println(s"Setting volume to $level")
  }

  class DVDPlayer {
    def on(): Unit = println("DVD Player on")
    def off(): Unit = println("DVD Player off")
    def play(movie: String): Unit = println(s"Playing $movie")
  }

  class Projector {
    def on(): Unit = println("Projector on")
    def off(): Unit = println("Projector off")
    def wideScreenMode(): Unit = println("Projector in widescreen mode")
  }

  class HomeTheaterFacade(
                           amp: Amplifier,
                           dvd: DVDPlayer,
                           projector: Projector
                         ) {
    def watchMovie(movie: String): Unit = {
      println("Get ready to watch a movie...")
      amp.on()
      amp.setVolume(5)
      dvd.on()
      dvd.play(movie)
      projector.on()
      projector.wideScreenMode()
    }

    def endMovie(): Unit = {
      println("Shutting movie theater down...")
      amp.off()
      dvd.off()
      projector.off()
    }
  }

  val amp = new Amplifier
  val dvd = new DVDPlayer
  val projector = new Projector

  val homeTheater = new HomeTheaterFacade(amp, dvd, projector)

  homeTheater.watchMovie("Inception")
  // Output:
  // Get ready to watch a movie...
  // Amplifier on
  // Setting volume to 5
  // DVD Player on
  // Playing Inception
  // Projector on
  // Projector in widescreen mode

  homeTheater.endMovie()
  // Output:
  // Shutting movie theater down...
  // Amplifier off
  // DVD Player off
  // Projector off
}
