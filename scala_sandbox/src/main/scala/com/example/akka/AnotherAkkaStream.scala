package com.example.akka

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import akka.stream.scaladsl.{Source, Flow, Sink}

object AkkaStreamsExample extends App {

  implicit val system: ActorSystem = ActorSystem("AkkaStreams")
  implicit val materializer: Materializer = ActorMaterializer()

  // Step 1: Create a Source that emits a sequence of numbers
  val source = Source(1 to 5)

  // Step 2: Define a Flow that squares each number
  val flow = Flow[Int].map(x => x * x)

  // Step 3: Define a Sink that prints each result
  val sink = Sink.foreach[Int](println)

  // Step 4: Connect the Source, Flow, and Sink to form a stream
  source.via(flow).to(sink).run()

  // Step 5: Terminate the ActorSystem after stream completion
  system.terminate()
}
