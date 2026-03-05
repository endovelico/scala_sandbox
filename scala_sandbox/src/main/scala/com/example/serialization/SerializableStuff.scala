package com.example.serialization

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

object SerializableStuff extends App {

  @SerialVersionUID(1L)
  case class Person(name: String, age: Int) extends Serializable

  // Serialize an object to a file
  val person = Person("Alice", 30)
  val out = new ObjectOutputStream(new FileOutputStream("person.ser"))
  out.writeObject(person)
  out.close()

  // Deserialize the object from the file
  val in = new ObjectInputStream(new FileInputStream("person.ser"))
  val deserializedPerson = in.readObject().asInstanceOf[Person]
  in.close()

  println(deserializedPerson) // Output: Person(Alice, 30)

}
