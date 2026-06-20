package com.example.design_patterns.behavioral

import java.util.StringTokenizer
import scala.collection.mutable
import scala.jdk.CollectionConverters.EnumerationHasAsScala

trait Expression {
  def interpret(): Int
}

class Number(n: Int) extends Expression {
  override def interpret(): Int = n
}

class Add(right: Expression, left: Expression) extends Expression {
  override def interpret(): Int = left.interpret() + right.interpret()
}
class Subtract(right: Expression, left: Expression) extends Expression {
  override def interpret(): Int = left.interpret() - right.interpret()
}
class Multiply(right: Expression, left: Expression) extends Expression {
  override def interpret(): Int = left.interpret() * right.interpret()
}

object Expression {
  def apply(operator: String, left: => Expression, right: => Expression):
  Option[Expression] =
    operator match {
      case "+" => Some(new Add(right, left))
      case "-" => Some(new Subtract(right, left))
      case "*" => Some(new Multiply(right, left))
      case i if i.matches("\\d+") => Some(new Number(i.toInt))
      case _ => None
    }
}

class RPNParser {
  def parse(expression: String): Expression = {
    val tokenizer = new StringTokenizer(expression)
    tokenizer.asScala.foldLeft(mutable.Stack[Expression]()) {
      case (result, token) =>
        val item = Expression(token.toString, result.pop(), result.pop())
        item.foreach(result.push)
        result
    }.pop()
  }
}
class RPNInterpreter {
  def interpret(expression: Expression): Int = expression.interpret()
}

object RPNExample {
  def main(args: Array[String]): Unit = {
    val expr1 = "1 2 + 3 * 9 10 + -" // (1 + 2) * 3 - (9 + 10) = -10
    val expr2 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
    val expr3 = "12 -" // invalid
    val parser = new RPNParser
    val interpreter = new RPNInterpreter
    System.out.println(s"The result of '${expr1}' is: ${interpreter.interpret(parser.parse(expr1))}")
    System.out.println(s"The result of '${expr2}' is: ${interpreter.interpret(parser.parse(expr2))}")
    try {
      System.out.println(s"The result is: ${interpreter.interpret(parser.parse(expr3))}")
    } catch {
      case _: Throwable => System.out.println(s"'$expr3' is invalid.")
    }
  }
}