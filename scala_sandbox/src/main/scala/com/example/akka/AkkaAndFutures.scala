package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class AsyncActor extends Actor {

  def receive: Receive = {
    case "start" =>
      val resultFuture = Future {
        //Simulate Long Computation
        Thread.sleep(1000)
        "Result from Future"
      }

      resultFuture.foreach(result => sender() ! result)
  }
}

object FutureWithAkkaExample extends App {

  val system = ActorSystem("FutureWithAkkaSystem")
  val asyncActor = system.actorOf(Props[AsyncActor], "asyncActor")

  asyncActor ! "start"

  // Shutdown System after sult is received
  system.terminate()
}