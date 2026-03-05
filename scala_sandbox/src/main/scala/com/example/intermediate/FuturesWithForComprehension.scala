package com.example.intermediate

object FuturesWithForComprehension extends App {

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global

  val future1: Future[Int] = Future {
    Thread.sleep(1000)
    10
  }

  val future2: Future[Int] = Future {
    Thread.sleep(500)
    20
  }

  val combined: Future[Int] = for {
    result1 <- future1
    result2 <- future2
  } yield result1 + result2

  combined.onComplete {
    case scala.util.Success(value) => println(s"Combined result: $value")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }

}
