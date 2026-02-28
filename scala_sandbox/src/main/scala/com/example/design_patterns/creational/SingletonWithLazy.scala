package com.example.design_patterns.creational

class SingletonWithLazy {

  class Logger private () {
    def log(message: String): Unit = println(s"[LOG] $message")
  }

  object Logger {
    lazy val instance: Logger = new Logger()
  }

  // Usage
  Logger.instance.log("Starting the app")

}
