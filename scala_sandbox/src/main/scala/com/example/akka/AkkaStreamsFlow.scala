package com.example.akka

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import akka.stream.scaladsl.{Source, Sink}

object ReactiveProgrammingExample extends App {

  implicit val system: ActorSystem = ActorSystem("ReactiveSystem")
  implicit val materializer: Materializer = ActorMaterializer()

  // Creating a simple source of numbers
  val numbersSource = Source(1 to 10)

  // Sink that prints out each number
  val printSink = Sink.foreach[Int](println)

  // Connecting source and sink using a flow
  numbersSource.to(printSink).run()

  // Terminating the actor system after the stream has completed
  system.terminate()
}
