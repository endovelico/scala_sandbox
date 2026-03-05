package com.example.adt

//Sum algebraic data types are the ones in which we can simply enumerate all the possible
//values of a type and provide a separate constructor for each value. As an example, let's
//consider the months of the year. There are only 12 and they cannot change (hopefully):

sealed abstract trait Month

case object January extends Month
case object February extends Month
case object March extends Month
case object April extends Month
case object May extends Month
case object June extends Month
case object July extends Month
case object August extends Month
case object September extends Month
case object October extends Month
case object November extends Month
case object December extends Month

object MonthDemo {

  def main(args: Array[String]): Unit = {
    val month: Month = February
    System.out.println(s"The current month is: $month")
  }
}