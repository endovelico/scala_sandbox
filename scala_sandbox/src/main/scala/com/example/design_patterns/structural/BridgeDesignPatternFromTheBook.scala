package com.example.design_patterns.structural

/*import java.security.MessageDigest
import org.apache.commons.codec.binary.Hex

trait Hasher {

  def hash(data: String): String

  protected def getDigest(algorithm: String, data: String): MessageDigest = {
    val digest = MessageDigest.getInstance(algorithm)
    digest.update(data.getBytes("UTF-8"))
    digest
  }
}

trait Sha1Hasher extends Hasher {
  override def hash(data: String): String =
    new String(Hex.encodeHex(getDigest("SHA-1", data).digest()))
}

trait Sha256Hasher extends Hasher {
  override def hash(data: String): String =
    new String(Hex.encodeHex(getDigest("SHA-256", data).digest()))
}

trait Md5Hasher extends Hasher {
  override def hash(data: String): String =
    new String(Hex.encodeHex(getDigest("MD5", data).digest()))
}

abstract class PasswordConverterBase { self: Hasher =>
  def convert(password: String): String
}

class SimplePasswordConverterScala extends PasswordConverterBase { self: Hasher =>
  override def convert(password: String): String =
    hash(password)
}

class SaltedPasswordConverterScala(salt: String) extends PasswordConverterBase { self: Hasher =>
  override def convert(password: String): String =
    hash(s"$salt:$password")
}

object ScalaBridgeExample {

  def main(args: Array[String]): Unit = {

    val p1 = new SimplePasswordConverterScala with Sha256Hasher
    val p2 = new SimplePasswordConverterScala with Md5Hasher
    val p3 = new SaltedPasswordConverterScala("8jsdf32T^$%") with Sha1Hasher
    val p4 = new SaltedPasswordConverterScala("8jsdf32T^$%") with Sha256Hasher

    println(s"'password' in SHA-256 is: ${p1.convert("password")}")
    println(s"'1234567890' in MD5 is: ${p2.convert("1234567890")}")
    println(s"'password' in salted SHA-1 is: ${p3.convert("password")}")
    println(s"'password' in salted SHA-256 is: ${p4.convert("password")}")
  }
}*/