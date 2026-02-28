package com.example.complete

object Adler32Checksum {

  val MOD_ADLER = 65521

  def main(args:Array[String]): Unit = {

    val sum = adler32sum("Wikipedia")
    printf("checksum (int) = %d/n", sum)
    printf("checksum (hex) = %s/n", sum.toHexString)
  }

  def adler32sum(s:String):Int = {

    var a = 1
    var b = 0
    s.getBytes.foreach(char =>
      a = (char + a) % MOD_ADLER,
      b = (b + a) % MOD_ADLER)

  }

  b * 65536 + a


}
