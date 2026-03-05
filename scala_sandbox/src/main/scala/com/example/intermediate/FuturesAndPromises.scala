package com.example.intermediate

import scala.util.{Failure, Success}

object FuturesAndPromises extends App {

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  val future: Future[Int] = Future {
    // Simulating a long-running task
    Thread.sleep(2000)
    42
  }

  future.onComplete {
    case Success(result) => println(s"Future completed successfully with result: $result")
    case Failure(exception) => println(s"Future failed with exception: $exception")
  }

  val futureMapped: Future[Int] = future.map(result => result * 2) // futureMapped: Future[Int]

  import scala.concurrent.Promise
  val promise = Promise[Int]()
  val futureFromPromise = promise.future

  promise.success(42) // Completing the promise with a value
  // Alternatively, you can complete with an error:
  // promise.failure(new Exception("Something went wrong"))

  val promise0 = Promise[Int]()
  val future0 = promise.future
  // Simulate asynchronous computation and complete the promise later
  new Thread {
    override def run(): Unit = {
      Thread.sleep(2000)
      promise0.success(100)// Complete the promise after a delay
    }
  }.start()
  // Do something with the future
  future0.onComplete {
    case Success(result) => println(s"Future completed with result: $result")
    case Failure(exception) => println(s"Future failed with exception: $exception")
  }
}
