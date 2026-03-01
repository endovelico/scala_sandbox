package com.example.cats
//import cats.implicits._

class CombiningOptionValues {

  object WithoutCatsOption {

    def combine(a: Option[Int], b: Option[Int]): Option[Int] =
      for {
        x <- a
        y <- b
      } yield x + y

    def main(args: Array[String]): Unit = {
      println(combine(Some(2), Some(3))) // Some(5)
      println(combine(Some(2), None))    // None
    }
  }

  /*object WithCatsOption {

    def combine(a: Option[Int], b: Option[Int]): Option[Int] =
      (a, b).mapN(_ + _)

    def main(args: Array[String]): Unit = {
      println(combine(Some(2), Some(3))) // Some(5)
      println(combine(Some(2), None))    // None
    }
  }*/

}
