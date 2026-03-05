package com.example.intermediate

object FutureOnCompleteOnError extends App {

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.util.{Failure, Success}

  val future: Future[Int] = Future {
    if (math.random() < 0.5) throw new RuntimeException("Something went wrong!")
    42
  }
  future.onComplete {
    case Success(value) => println(s"Success: $value")
    case Failure(exception) => println(s"Failure: ${exception.getMessage}")
  }

  val futureWithError: Future[Int] = Future {
    throw new RuntimeException("Calculation failed")
  }
  val recoveredFuture: Future[Int] = futureWithError.recover {
    case e: RuntimeException => 100  // Fallback value
  }
  recoveredFuture.onComplete {
    case Success(value) => println(s"Recovered value: $value")case Failure(exception) => println(s"Error: $exception")
  }

  val futureWithError2: Future[Int] = Future {
    throw new IllegalArgumentException("Invalid argument")
  }
  val recoveredFutureWith: Future[Int] = futureWithError2.recoverWith {
    case e: IllegalArgumentException => Future.successful(200)  // Return a new Future
  }
  recoveredFutureWith.onComplete {
    case Success(value) => println(s"Recovered value: $value")
    case Failure(exception) => println(s"Error: $exception")
  }

  val primaryFuture: Future[Int] = Future {
    throw new Exception("Primary Future failed")
  }
  val fallbackFuture: Future[Int] = Future {
    42  // Fallback value
  }
  val resultFuture: Future[Int] = primaryFuture.fallbackTo(fallbackFuture)
  resultFuture.onComplete {
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => println(s"Error: $exception")
  }

  val futures: List[Future[Int]] = List(
    Future { throw new Exception("Failure in first future") },
    Future { 10 },
    Future { 20 }
  )
  val handledFutures: List[Future[Int]] = futures.map(_.recover {
    case _: Exception => 0  // Recover with a default value
  })
  Future.sequence(handledFutures).onComplete {
    case Success(results) => println(s"Results: $results")
    case Failure(exception) => println(s"Error: $exception")
  }

}
