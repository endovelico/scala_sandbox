package com.example.from_books


class Rational(n:Int, d:Int) {

  private val g = gcd(n.abs, d.abs)

  val numer:Int = n / g
  val denom:Int = d / g

  def this(n:Int) = this(n, 1)

  def + (that:Rational):Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that:Rational):Rational =
    new Rational(numer * that.numer, denom * that.denom)

  override def toString:String = s"$numer/$denom"

  private def gcd(a:Int, b:Int):Int =
    if (b == 0) a else gcd(b, a % b)

}
