package com.example.basics

object OptionConstruct extends App {

  val wallet = Map("USD" -> 10, "EURO"-> 2)
  val maybeSomeEuros = wallet.get("EUR")
  val maybeSomePounds: Option[Int] = None

  val nums:List[Option[Int]] = List(Some(1), None, Some(2), Some(3), None)
  val result = nums
    .flatMap(_.toList)
    .map(_ * 2);
  println(result)
}
