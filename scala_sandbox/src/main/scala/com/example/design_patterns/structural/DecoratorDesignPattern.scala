package com.example.design_patterns.structural

package com.example.design_patterns.structural

import java.io._
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.zip.GZIPOutputStream

import scala.collection.JavaConverters._

trait InputReader {
  def readLines(): LazyList[String]
}

class AdvancedInputReader(reader: BufferedReader) extends InputReader {
  override def readLines(): LazyList[String] =
    reader.lines().iterator().asScala.to(LazyList)
}

abstract class InputReaderDecorator(inputReader: InputReader) extends InputReader {
  override def readLines(): LazyList[String] =
    inputReader.readLines()
}

class CapitalizedInputReader(inputReader: InputReader)
  extends InputReaderDecorator(inputReader) {

  override def readLines(): LazyList[String] =
    super.readLines().map(_.toUpperCase)
}

class CompressingInputReader(inputReader: InputReader)
  extends InputReaderDecorator(inputReader) {

  override def readLines(): LazyList[String] =
    super.readLines().map { line =>

      val text = line.getBytes(StandardCharsets.UTF_8)
      println(s"Length before compression: ${text.length}")

      val output = new ByteArrayOutputStream()
      val compressor = new GZIPOutputStream(output)

      try {
        compressor.write(text)
      } finally {
        compressor.close()
      }

      val compressed = output.toByteArray
      println(s"Length after compression: ${compressed.length}")

      new String(compressed, StandardCharsets.UTF_8)
    }
}

class Base64EncoderInputReader(inputReader: InputReader)
  extends InputReaderDecorator(inputReader) {

  override def readLines(): LazyList[String] =
    super.readLines().map { line =>
      Base64.getEncoder.encodeToString(line.getBytes(StandardCharsets.UTF_8))
    }
}

object DecoratorExample {

  def main(args: Array[String]): Unit = {

    val stream =
      new BufferedReader(
        new InputStreamReader(
          new BufferedInputStream(
            getClass.getResourceAsStream("/data.txt")
          )
        )
      )

    try {

      val reader =
        new CapitalizedInputReader(
          new AdvancedInputReader(stream)
        )

      reader.readLines().foreach(println)

    } finally {
      stream.close()
    }
  }
}

object DecoratorExampleBig {

  def main(args: Array[String]): Unit = {

    val stream =
      new BufferedReader(
        new InputStreamReader(
          new BufferedInputStream(
            getClass.getResourceAsStream("/data.txt")
          )
        )
      )

    try {

      val reader =
        new CompressingInputReader(
          new Base64EncoderInputReader(
            new CapitalizedInputReader(
              new AdvancedInputReader(stream)
            )
          )
        )

      reader.readLines().foreach(println)

    } finally {
      stream.close()
    }
  }
}