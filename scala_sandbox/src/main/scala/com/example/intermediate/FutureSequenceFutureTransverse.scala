package com.example.intermediate

import com.example.intermediate.FuturesWithFlatMap.future3
import com.example.intermediate.FuturesWithForComprehension.{future1, future2}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FutureSequenceFutureTransverse extends App {

  // Future sequence
  val futureList: List[Future[Int]] = List(future1, future2, future3)
  val sequenceResult: Future[List[Int]] = Future.sequence(futureList)
  sequenceResult.onComplete {
    case scala.util.Success(results) => println(s"Results: $results")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }

  //Future Transverse
  val numbers = List(1, 2, 3)
  val futureNumbers: Future[List[Int]] = Future.traverse(numbers)(num => Future(num * 2))
  futureNumbers.onComplete {
    case scala.util.Success(results) => println(s"Multiplied results: $results")
    case scala.util.Failure(exception) => println(s"Error: $exception")
  }

}
