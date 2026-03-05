package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}

class PrinterActor extends Actor {

  def receive: Receive = {
    case msg:String => println("Received: $msg")
  }

}

object AkkaConcurrencyExample extends App {

  val system = ActorSystem("PrinterSystem")

  val printer1 = system.actorOf(Props[PrinterActor], "printer1")
  val printer2 = system.actorOf(Props[PrinterActor], "printer2")

  printer1 ! "Hellow"
  printer2 ! "Ola"
}
