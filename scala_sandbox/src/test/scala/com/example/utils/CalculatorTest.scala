package com.example.utils

import org.junit.jupiter
import org.junit.jupiter.api.Assertions.{assertEquals, assertNotNull}
import org.junit.jupiter.api.Test

class CalculatorTest {


  @Test
  def testsumOK():Unit = {

    val c:Calculator = new Calculator();
    val result:Int = c.sum(1, 5);

    assertNotNull(c);
    assertEquals(6, result);
  }

  @Test
  def testSum0():Unit = {

    val c:Calculator  = new Calculator();
    val result:Int = c.sum(0, 0);

    assertNotNull(c);
    assertEquals(0, result);

  }

  @Test
  def testMultiplyOk():Unit = {

    val c:Calculator = new Calculator();
    val result:Int = c.multiply(2, 3);

    assertNotNull(c);
    assertEquals(6, result);
  }

  @Test
  def testMupltiply0():Unit = {

    val c:Calculator = new Calculator();
    val result:Int = c.multiply(5, 0);

    assertNotNull(c);
    assertEquals(4, result);
  }

}
