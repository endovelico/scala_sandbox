package com.example.design_patterns.structural

class Logger {
  def log(message: String, severity: String): Unit = {
    System.out.println(s"${severity.toUpperCase}: $message")
  }
}

trait Log {
  def info(message: String)
  def debug(message: String)
  def warning(message: String)
  def error(message: String)
}

class AppLogger extends Logger with Log {
  override def info(message: String): Unit = log(message, "info")
  override def warning(message: String): Unit = log(message, "warning")
  override def error(message: String): Unit = log(message, "error")
  override def debug(message: String): Unit = log(message, "debug")
}

object AdapterExample {
  def main(args: Array[String]): Unit = {
    val logger = new AppLogger
    logger.info("This is an info message.")
    logger.debug("Debug something here.")
    logger.error("Show an error message.")
    logger.warning("About to finish.")
    logger.info("Bye!")
  }
}
