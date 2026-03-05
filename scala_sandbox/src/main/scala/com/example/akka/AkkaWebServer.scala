package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}
class WebServerActor extends Actor {
  def receive: Receive = {
    case "request" =>
      println("Processing request...")
      // Simulate a delay
      Thread.sleep(1000)
      sender() ! "Request processed"
  }
}
object WebServerExample extends App {
  val system = ActorSystem("WebServerSystem")
  val webServerActor = system.actorOf(Props[WebServerActor], "webServerActor")
  // Simulate incoming requests
  for (i <- 1 to 5) {
    webServerActor ! "request"
  }
  // Shutdown the system after a delay
  Thread.sleep(3000)
  system.terminate()
} 
