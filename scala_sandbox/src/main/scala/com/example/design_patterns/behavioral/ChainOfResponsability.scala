package com.example.design_patterns.behavioral

class ChainOfResponsability {

  trait Handler {
    protected var next: Option[Handler] = None

    def setNext(handler: Handler): Handler = {
      next = Some(handler)
      handler
    }

    def handle(request: String): Unit
  }

  class AuthHandler extends Handler {
    override def handle(request: String): Unit = {
      if (request.contains("auth")) {
        println("AuthHandler: processed request")
      } else {
        println("AuthHandler: passing request")
        next.foreach(_.handle(request))
      }
    }
  }

  class LoggingHandler extends Handler {
    override def handle(request: String): Unit = {
      println(s"LoggingHandler: logging request '$request'")
      next.foreach(_.handle(request))
    }
  }

  class DataHandler extends Handler {
    override def handle(request: String): Unit = {
      println(s"DataHandler: processing request '$request'")
    }
  }


  val auth = new AuthHandler
  val logger = new LoggingHandler
  val data = new DataHandler

  // Chain: auth -> logger -> data
  auth.setNext(logger).setNext(data)

  // Send requests
  auth.handle("auth: user login")
  // Output:
  // AuthHandler: processed request

  auth.handle("fetch data")
  // Output:
  // AuthHandler: passing request
  // LoggingHandler: logging request 'fetch data'
  // DataHandler: processing request 'fetch data'
}
