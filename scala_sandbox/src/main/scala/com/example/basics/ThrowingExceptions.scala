package com.example.basics

class ThrowingExceptions {

  var someCondition:Boolean = false

  if(someCondition) {
    throw new IllegalArgumentException("Invalid Exception")
  }

  // Throwing a custom exception
  private class MyCustomException(message: String) extends Exception(message)
  throw new MyCustomException("This is a custom exception")
}
