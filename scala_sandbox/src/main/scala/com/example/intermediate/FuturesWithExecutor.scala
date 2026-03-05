package com.example.intermediate

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureExample extends App {

  //Simulate a long running computation
  def longRunningTask (name:String):String = {
    Thread.sleep(2000)

    s"Task $name completed!"
  }

  // Create two functions for future execution
  val task1 = Future { longRunningTask("Task 1") }
  val task2 = Future { longRunningTask("Task 2") }

  // wait for the result of both tasks
  val result1 = Await.result(task1, 5.seconds)
  val result2 = Await.result(task2, 7.seconds)

  println(result1)
  println(result2)
}
