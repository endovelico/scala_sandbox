package com.example.design_patterns.behavioral


// Strategy trait
trait PaymentStrategy {
  def pay(amount: Double): Unit
}

class CreditCardPayment extends PaymentStrategy {
  override def pay(amount: Double): Unit = {
    println(s"Paying $$${amount} using Credit Card.")
  }
}

class PayPalPayment extends PaymentStrategy {
  override def pay(amount: Double): Unit = {
    println(s"Paying $$${amount} using PayPal.")
  }
}

class BitcoinPayment extends PaymentStrategy {
  override def pay(amount: Double): Unit = {
    println(s"Paying $$${amount} using Bitcoin.")
  }
}

class ShoppingCart(var paymentStrategy: PaymentStrategy) {
  def checkout(amount: Double): Unit = {
    paymentStrategy.pay(amount)
  }

  object StrategyPatternDemo extends App {
    // Pay with Credit Card
    val cart1 = new ShoppingCart(new CreditCardPayment)
    cart1.checkout(100.0)

    // Pay with PayPal
    val cart2 = new ShoppingCart(new PayPalPayment)
    cart2.checkout(200.0)

    // Pay with Bitcoin
    val cart3 = new ShoppingCart(new BitcoinPayment)
    cart3.checkout(300.0)

    // Swap strategy at runtime
    cart1.paymentStrategy = new BitcoinPayment
    cart1.checkout(150.0)
  }