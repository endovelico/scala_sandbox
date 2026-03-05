package com.example.serialization

import akka.io.TcpMessage.close

object CustomSerialization {

  import java.io._
  @SerialVersionUID(1L)
  class Person(var name: String, var age: Int) extends Serializable {
    @transient var secret: String = _
    // Custom serialization method
    private def writeObject(out: ObjectOutputStream): Unit = {
      out.defaultWriteObject() // default serialization for non-transient fields
      out.writeObject(secret)// manually serialize the transient field
    }
    // Custom deserialization method
    private def readObject(in: ObjectInputStream): Unit = {
      in.defaultReadObject()// default deserialization
      secret = in.readObject().asInstanceOf[String]// manually deserialize the transient field
    }
  }
  val person = new Person("Alice", 30)
  person.secret = "TopSecret"
  // Serialize the object
  val out = new ObjectOutputStream(new FileOutputStream("custom_person.ser"))
  out.writeObject(person)
  out.close()
  // Deserialize the object
  val in = new ObjectInputStream(new FileInputStream("custom_person.ser"))
  val deserializedPerson = in.readObject().asInstanceOf[Person]
  in.close()
  println(deserializedPerson) // Output: Person(Alice, 30)

}
