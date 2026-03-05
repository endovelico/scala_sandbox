package com.example.intermediate

import com.example.intermediate.FuturesWithForComprehension.{future1, future2}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FuturesWithFlatMap extends App {

  val future3: Future[Int] = Future {
    Thread.sleep(500)
    30
  }
  val combinedFuture: Future[Int] = future1.flatMap { result1 =>
    future3.map { result2 =>
      result1 + result2
    }

  }
  combinedFuture.onComplete {
    case scala.util.Success(value) => println(s"Combined future result: $value")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }

 // Zip + Future
  val future4: Future[Int] = Future {
    Thread.sleep(500)
    40
  }
  val zippedFuture: Future[(Int, Int)] = future2.zip(future4)
  zippedFuture.onComplete {
    case scala.util.Success((result1, result2)) => println(s"Zipped results: $result1, $result2")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }

  // Using recover and recoverWith to Handle Errors
  val failedFuture: Future[Int] = Future {
    throw new RuntimeException("Something went wrong")
  }
  val recoveredFuture: Future[Int] = failedFuture.recover {
    case _: RuntimeException => 100
  }
  recoveredFuture.onComplete {
    case scala.util.Success(value) => println(s"Recovered result: $value")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }
}
