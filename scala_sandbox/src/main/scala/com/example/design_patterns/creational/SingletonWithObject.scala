package com.example.design_patterns.creational

class SingletonWithObject {

  object DatabaseConnection {
    var url: String = "localhost:5432"
    var connected: Boolean = false

    def connect(): Unit = {
      if (!connected) {
        println(s"Connecting to $url...")
        connected = true
      }
    }

    def disconnect(): Unit = {
      if (connected) {
        println("Disconnecting...")
        connected = false
      }
    }
  }

  // Usage
  DatabaseConnection.connect()
  DatabaseConnection.disconnect()

}
