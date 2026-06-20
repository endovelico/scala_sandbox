import java.util.Date

object Main {

  def main(args: Array[String]): Unit = {

    ordinal(Integer.parseInt("5"))

    2 match { case 1 => "One" }

    List(1, 2, 3, 4) match {
      case f :: s :: rest => List(f, s)
      case > => Nil
    }

    val suffixes = List("th", "nd", "rd", "th", "th")

  }

  def ordinal(number:Int) = number match {

    case 1 => println("1st")
    case 2 => println("2st")
    case 3 => println("3st")
    case 4 => println("4th")
    case 5 => println("5th")
    case 6 => println("6th")
    case 7 => println("7th")
    case 8 => println("8th")
    case 9 => println("9th")
    case _ => println("Cannot do beyond 10")
  }


  def printType(obj: AnyRef) = obj match {
    case s:String => println("This is string")
    case l:List[_] => println("This is a list")
    case a:Array[_] => println("This is an Array")
    case d:java.util.Date => println("This is a date")
  }

  def rangeMatcher(num:Int) = num match {
    case within10 if within10 <= 10 => println("with in 0 to 10")
    case within100 if within100 <= 100 => println("with 11 to 100")
    //case beyond100 if beyond100 < Integer.MAX_VALUE => println("beyond 100")
    case _ => throw new IllegalArgumentException("Only values between 0 and 100 are allowed.")
  }

  def anotherOrdinal(number:Int) = number match {
    case tenTo20 if 10 to 20 contains tenTo20 => number + "th"
    case rest => rest + suffixes(number % 10)
  }

}