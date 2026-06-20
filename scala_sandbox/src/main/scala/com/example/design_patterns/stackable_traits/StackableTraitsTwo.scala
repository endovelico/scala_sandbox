package com.example.design_patterns.stackable_traits

trait Logging extends Account {
  abstract override def deposit(amount: Double): Unit = {
    println(s"Logging: depositing $amount")
    super.deposit(amount)  // call the next layer
  }
}

trait Security extends Account {
  abstract override def deposit(amount: Double): Unit = {
    println("Checking security...")
    super.deposit(amount)
  }
}

object TryOut extends App {
  // Compose behaviors
  val acc = new Account with Logging with Security
  acc.deposit(100)
}

class Account {
  def deposit(amount: Double): Unit = println(s"Depositing $amount")
}