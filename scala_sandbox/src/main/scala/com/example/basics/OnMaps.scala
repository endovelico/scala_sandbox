package com.example.basics

class OnMaps {

  val wallet = Map("USD" -> 10, "EURO"-> 2)

  val updatedWallet = wallet + ("GBP" -> 20)
  val someEuros = wallet("EUR")
  val somePounds = wallet("GBP")

  def printWallet = {
    println(wallet)
    println(updatedWallet)
    println(someEuros)
    println(somePounds)
  }

  object Main extends App {
    printWallet
  }
}