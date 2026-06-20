// Pure FP
object PureFunctionalProgram {

  def main(args:Array[String]):Unit = singleExpression(args.toList)

  def singleExpression:List[String => (List[Int], List[Int])] = { a => a map(_.toInt) partition (_ < 30)
  }
}

package http.server {

  object Pure {
    trait Resource {

      def exists:Boolean
      def contents: List[String]
      def contentLength:Int
    }

    type ResourceLocator = String => Resource
    type Request = Iterator[char]
    type Response = List[String]

    // Parse HTTP request for filename
    def get(req:Request) (implicit locator:ResourceLocator): Response = {
      val requestedResource = req.takeWhile(x => x != '\n')
        .mkString.split(".")(1).drop(1)
      (_200 orElse _404)(locator(requestedResource))
    }

    private def _200:PartialFunction[Resource, Resource] = {
      case resoure if(resource.exists) =>
        "HTTP/1.1 200 OK" :: ("Date" + new java.util.Date) ::
        "Content-type; text/html" ::
          ("Content-length " + resource.contentLength) ::
        System.getProperty("line.separator") ::
        resource.contents
    }

    private def _404: PartialFunction(Resource, Response) = {
      case _ => List("HTTP/1.1 404 Request Not Found")
    }
  }

  import Pure._
  case class IOResource(name:String) extends Resource {
    def exists = new File(name).exists
    def contents = Source.fromFile(name).getLines.toList
    def contentLength = Source.fromFile(name).count(x => true)
  }
  implicit val ioResourceLocator:ResourceLocator = name => IOResource(name)
}

package methods.inall.shapesandsizes {

  class UseResource {

    //methods
    def use(r:Resource):Boolean = {}

    //high order functions
    val l = List(1, 2, 3, 4, 5, 7)
  }

  val x = Person(firstName, lastName)
  x.setInfo(someInfo)
  println("log: new person is created")
  mailer.mail("new person joined" + x)
  x.firstName

  def tap[A](a:A)(sideEffect:A => Unit):A = {
    sideEffect(a)
    a
  }

  val y = Person(firstName, lastName)
  tap(y) {
    p =>
      import p._
      setInfo(someInfo)
      println("log is new created")
      mailer.mail("new person joined" + y)
  }.firstName

  object Combinators
  {
    implicit def kestrel[A](a:A) = new {
      def tap(sideEffect:A => Unit):A = {
        sideEffect(a)
        a
      }
    }
  }

  case class Person(firstName:String, lastName:String)
  case class Mailer(mailAddress:String) {
    def mail(body:String) = (println("send mail here"))
  }

  object Main {
    import Combinators._
    def main(args:Array[String]):Unit = {
      Person("Ninja", "Ray").tap(p => {
        println("firstname" + firstName)
        Mailer("some address")
      }).lastName
    }
  }
}

package currying {

  trait TaxStrategy { def taxIt(product:String):Double }

  val taxIt:(TaxStrategy, String) => Double = (s, p) => s.taxIt(p)

  taxIt.curried

  class TaxFree extends TaxStrategy { override def taxIt(product:String) = 0.0 }

  val taxFree = taxIt.curried(new TaxFree)

  taxFree("someProduct")

  def taxIt(s:TaxStrategy, product:String) = {s.taxIt(product)}

  val taxIt = taxIt

  taxIf = curried

  def taxIt(s:TaxStrategy) (product:String) = { s.taxIt(product)}

  val taxFree =taxIt(new TaxFree)
}

package another.curried {
  // Regular function
  def add(x: Int, y: Int): Int = x + y

  // Curried version
  def addCurried(x: Int)(y: Int): Int = x + y

  // Usage
  val sum1 = addCurried(5)(10)  // returns 15

  // Partial application
  val addFive = addCurried(5) _ // returns a function Int => Int
  val sum2 = addFive(10)         // returns 15
}

package partial.functions {

  def intToChar: PartialFunction[Int, Char] = {
    case 1 => 'a'
    case 3 => 'b'
  }

  new PartialFunction[Int, Char] {
    def apply(i:Int) = i match {
      case 1 => 'a'
      case 3 => 'b'
    }

    def isDefinedAt(i:Int):Boolean = i match {
      case 1 => true
      case 3 => true
      case _ => false
    }
  }

}

/* Absolutely! In Scala, a partial function is a function that is not necessarily defined
 for all  input values. You can check if it is defined for a particular input using isDefinedAt, and it
 ’s often used with pattern matching.

 */
package another.partial {

  val squareRoot: PartialFunction[Double, Double] = {
    case x if x >= 0 => Math.sqrt(x)
  }

  // Usage
  println(squareRoot(9))   // 3.0
  // println(squareRoot(-1)) // throws scala.MatchError

  // Check if function is defined
  println(squareRoot.isDefinedAt(9))   // true
  println(squareRoot.isDefinedAt(-1))  // false
}

package continuuing.partials.book {

  sealed trait Claim { val claimId:Int }
  case class Full(val claimId:Int) extends Claim
  case class Partial(val claimId:Int, percentage:Double) extends Claim
  case class Generic(val claimId:Int) extends Claim
  case class Location(stateCode:Option[String], zipCode:Option[String])
  case class Req(productId:String, location:Location, claim:Claim)

  def claimHandler = handleFullClaim orElse handlePartialClaim
  def locationHandlers = handleZipCode orElse handleStateCode
  def priceCalculator:PartialFunction[PC. PC] = claimHabndlers andThen locationHandlers
}

package recursion.tail {

  // non tail optimized
  def length[A](xs:List[A]):Int = xs match {
    case Nil => 0
    case x :: ys => 1 + length(ys)
  }

  // tail optimized
  case length2[A](xs:List[A]):Int = {
    def _length(xs:List[A], currentLength:Int):Int = xs match {
      case Nil => currentLength
      case x ::ys => _length(ys, currentLength + 1)
    }
    _length(xs, 0)
  }
}

package algebraic.data.types {

  sealed trait Account
  case class CheckingAccount(accountId:String) extends Account
  case class SavingAccount(accountId:String, limit:Double) extends Account
  case class PremiumAccoumt(corporated:String, accountHolder:String) extends Account

  def printAccountDetails(account:Account):Unit = account match {
    case CheckingAccount(accountId) => println("Account id" + accountId)
  }

  case SavingAccount(accountId, limit) => println("Account id" + accountId +"," + limit)
}

// Monads
//Definition: A monad is a functor with sequencing, supporting:
//
//pure/unit: wrap a value
//flatMap/bind: chain computations that themselves return a container
package monads {

  val opt: Option[Int] = Some(5)

  val result = opt
    .flatMap(x => Some(x * 2))
    .flatMap(x => Some(x + 3))

  println(result)  // Some(13)

  val numbers = List(1, 2)
  val expanded = numbers.flatMap(n => List(n, n*10))
  println(expanded) // List(1, 10, 2, 20)
}

//import cats.Monoid
//import cats.implicits._
//
//// Integers under addition
//val sum: Int = Monoid[Int].combine(1, 2) // 3
//val identity: Int = Monoid[Int].empty     // 0
//
//// Strings under concatenation
//val s = Monoid[String].combine("Hello, ", "World!") // "Hello, World!"
package monoids {
  import cats.Monoid
  import cats.implicits._

  // Integers under addition
  val sum: Int = Monoid[Int].combine(1, 2) // 3
  val identity: Int = Monoid[Int].empty     // 0

  // Strings under concatenation
  val s = Monoid[String].combine("Hello, ", "World!") // "Hello, World!"
}

//val numbers = List(1, 2, 3)
//val doubled = numbers.map(_ * 2)  // List(2, 4, 6)
//
//val option: Option[Int] = Some(5)
//val incremented = option.map(_ + 1) // Some(6)
package functors {
  val numbers = List(1, 2, 3)
  val doubled = numbers.map(_ * 2)  // List(2, 4, 6)

  val option: Option[Int] = Some(5)
  val incremented = option.map(_ + 1) // Some(6)
}