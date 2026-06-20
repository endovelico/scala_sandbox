
object Main {

  def main(args: Array[String]): Unit = {

    val array = new Array[String](3)

    array(0) = "this"
    array(1) = "is"
    array(2) = "mutable"
    println(array)

    val another_list = List("this", "is", "immutable")
    println(another_list)

    val yet_another = scala.collection.immutable.List("This", "is", "Immutable")
    println(yet_another)

    val oldList = List(1, 2)
    val newList = 3 :: oldList

    val anotherNewList = oldList :+ 3
    print(anotherNewList)

    val nilList = "This" :: "is" :: "immutable" :: Nil
    print(nilList)

    val afterDelete = newList.filterNot(_ == 3)
    print(afterDelete)
  }
}