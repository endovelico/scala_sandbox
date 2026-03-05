package com.example.akka

import akka.actor.{Actor, ActorSystem, Props}
class DataProcessorActor extends Actor {
  def receive: Receive = {
    case data: String =>
      val processedData = data.toUpperCase
      sender() ! processedData
  }
}

object DataPipelineExample extends App {
  val system = ActorSystem("DataPipelineSystem")
  val processorActor = system.actorOf(Props[DataProcessorActor], "processorActor")
  // Send multiple data items concurrently
  processorActor ! "hello"
  processorActor ! "world"
  // Shutdown the systemsystem.terminate()
}