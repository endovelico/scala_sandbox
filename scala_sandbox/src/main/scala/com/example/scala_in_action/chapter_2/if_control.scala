object Main {

  def main(args: Array[String]): Unit = {
    val aList = List(1, 2, 3, 4, 5)
    val bList = List(1, 2, 3, 4, 5)

    val files = new java.io.File(".").listFiles

    for (file <- files) {

      val filename = file.getName
      if (filename.endsWith(".scala")) println(file)
    }

    val result = for {a <- aList; b <- bList} yield a + b

    for(r <- result) println(r)
  }
}