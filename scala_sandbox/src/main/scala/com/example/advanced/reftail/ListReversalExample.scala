package com.example.advanced.reftail
import scala.annotation.tailrec

class ListReversalExample {

  object NonTailRecReverse extends App {

    def reverseList[A](lst: List[A]): List[A] = lst match {
      case Nil => Nil
      case head :: tail => reverseList(tail) :+ head // ❌ NOT tail-recursive
    }

    val original = List(1, 2, 3, 4, 5)
    println(reverseList(original)) // List(5, 4, 3, 2, 1)
  }


  object TailRecReverse extends App {

    def reverseListTailRec[A](lst: List[A]): List[A] = {
      @tailrec
      def helper(remaining: List[A], acc: List[A]): List[A] = remaining match {
        case Nil => acc
        case head :: tail => helper(tail, head :: acc) // ✅ tail call
      }

      helper(lst, Nil)
    }

    val original = List(1, 2, 3, 4, 5)
    println(reverseListTailRec(original)) // List(5, 4, 3, 2, 1)
  }

}
