package com.example.akka
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, SupervisorStrategy, Props}

import akka.actor.Actor

class FailingActor extends Actor {

  override def receive:Receive = {
    case "fail" => throw new RuntimeException("Failed!")
    case msg => println(s"Received: $msg")
  }

  override val supervisorStrategy:SupervisorStrategy = OneForOneStrategy() {
    case _: RuntimeException => SupervisorStrategy.Restart
  }
}

object SupervisionExample extends App {

  val system = ActorSystem("SupervisionSystem")
  val failiingActor = system.actorOf(Props[FailingActor], "failingActor")

  failiingActor ! "fail"
  failiingActor ! "continue"
}
