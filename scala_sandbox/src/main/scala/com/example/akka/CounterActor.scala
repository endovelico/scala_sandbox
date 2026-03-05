package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}

class CounterActor extends Actor {

  var count = 0

  def receive: Receive = {
    case "increment" => count += 1
    case "get" => sender() ! count
  }

}

object AkkaExample extends App {

  val system = ActorSystem("CounterSystem")
  val counterActor = system.actorOf(Props[CounterActor], "conter")

  counterActor ! "increment"
  counterActor ! "increment"
  counterActor ! "get"
}
