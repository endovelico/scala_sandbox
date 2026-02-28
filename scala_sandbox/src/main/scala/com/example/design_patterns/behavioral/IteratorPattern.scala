package com.example.design_patterns.behavioral

class IteratorPattern {

  trait MyIterator[T] {
    def hasNext: Boolean
    def next(): T
  }

  class NumberCollection(numbers: Array[Int]) {
    def iterator: MyIterator[Int] = new MyIterator[Int] {
      private var index = 0

      override def hasNext: Boolean = index < numbers.length

      override def next(): Int = {
        if (!hasNext) throw new NoSuchElementException
        val value = numbers(index)
        index += 1
        value
      }
    }
  }

  val collection = new NumberCollection(Array(1, 2, 3, 4, 5))
  val iter = collection.iterator

  while (iter.hasNext) {
    println(iter.next())
  }

  // Output:
  // 1
  // 2
  // 3
  // 4
  // 5

}
