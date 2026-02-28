package com.example.design_patterns.behavioral

class StrategyPattern {

  trait PaymentStrategy {
    def pay(amount: Double): Unit
  }

  class CreditCardPayment(cardNumber: String) extends PaymentStrategy {
    override def pay(amount: Double): Unit =
      println(s"Paid $$${amount} using credit card $cardNumber")
  }

  class PayPalPayment(email: String) extends PaymentStrategy {
    override def pay(amount: Double): Unit =
      println(s"Paid $$${amount} using PayPal account $email")
  }

  class ShoppingCart(var strategy: PaymentStrategy) {
    def checkout(amount: Double): Unit = strategy.pay(amount)
  }

  val cart1 = new ShoppingCart(new CreditCardPayment("1234-5678-9876-5432"))
  cart1.checkout(100.0)
  // Output: Paid $100.0 using credit card 1234-5678-9876-5432

  val cart2 = new ShoppingCart(new PayPalPayment("user@example.com"))
  cart2.checkout(250.0)
  // Output: Paid $250.0 using PayPal account user@example.com

}
