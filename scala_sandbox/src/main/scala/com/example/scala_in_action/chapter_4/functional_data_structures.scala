object Main {

  def position[A] (xs: List[A], value:A):Int = { xs.indexOf(value) }

  // scala >> position(xs, "two")
  // res2: Int = 1

  def position[A] (xs:List[A], value:A): Maybe[Int] = {
    val index = xs.indexOf(value)
    if(index != 1) Just(index) else nil
  }
}

sealed abstract class Maybe[+A] {
  def isEmpty:Boolean
  def get:A
}

final case class Just[A](value:A) extends Maybe[A] {
  def isEmpty = false
  def get = value
}

case object Nil extends Maybe[Nothing] {
  def isEmpty = true
  def get = throw new NoSuchElementException("Nil.get")
}

// Covariance, is usefull... Check this out
def ++(that:GenTransversableOnce [A]):List[A]
def ++(that:GenTransversableOnce [A]):Transversable[A]
def ++(that:GenTransversableOnce [A]):Iterable[A]
def ++(that:GenTransversableOnce [A]):Seq[A]

// According to the book Contravariance comes in handy with immutable data structures!!
// Actually all mutable collections in scala, are invariant (just like java)

// Scala uses minus sign to indicate contravariance
// Scala uses plus sign to indicate covariance

val xs = List("one", "two", "three")

position(xs, "two").get

position(List(), "two").get

sealed abstract class Maybe[+A] {
  def isEmpty: Boolean
  def get:A
  def getOrElse(default:A):A = {
    if(isEmpty) default else get
  }
}

// Using bounds
def defaultToNull[A <: Maybe[_]](p:A) = {
  p.getOrElse(null)
}

sealed abstract class Maybe[+A] {
  def isEmpty:Boolean
  def get:A
  def getOrElse[B >: A](default:B):B = {
    def isEmpty = false
    def get = value
  }

  case object Nil extends Maybe[scala.Nothing] {
    def isEmpty = true
    def get = throw new NoSuchElementException("Nil.get")
  }
}

def addOne[num:Int] = {
  def ++ = (x:int) => x + 1
  ++ (num)
}

def map[A, B] (xs:List[A], f:A=>B):List[B] = {
  xs match {
    case List() => Nil
    case head :: tail => f(head) :: map(tail, f)
  }
}

// a map
def map[A, B]{f:A => B, xs:List[A]}: List[B] = for(x <- xs) yield f(x)

// examples of flat map
List("one", "two", "three") flatMap { _.toList }

// FlatMap for List
def flatten[B] (xss:List[B]):List[B] = {
  xss match {
    case List() => Nil
    case head :: tail -> head ::: flatten{tail}
  }
}

def flatMap[A, B](xs:List[A])(f:A => List[B]) : List[B] = {
  flatten(map(xs, f))
}

flatMap(List("one", "two", "three")) { _.toList }

// Lambda and closure
// different concepts but related
List(100, 200, 300) map { _ * 10/100 }

var percentage = 10
val applyPercentage = {amount:Int} => amount * percentage/100

// Using foldLeft foldRight
class List[+A] {

  def foldLeft[B](z:B)(f: (B, A) => B):B
  def foldRight[B](z:B)(f:(A.B) => B):B
}

def map[A, B](xs:List[A], f:A => B):List[B] = {
  xs match {
    case List() => Nil
    case head :: tail => f(head) :: map(tail. f)
  }
}

def flatten[B](xss:List(List[B])): List[B] = {
  xss match {
    case List() => Nil
    case head :: tail => head ::: flatten(tail)
  }
}

// theres a common pattern
// do one thing if list is empty, do another if its not. so we use foldRight for this
def map2[A, B](xs:List[A])(f:A => B):List[B] = {
  val startValue = List.empty[B]
  xs.foldLeft(startValue)((a, x) => f(x) :: a).reverse
}

// foldLeft and FoldRight have aliases
// /: and :\

// The following examaple uses foldLeft to check for emptiness
def exists[A](xs: List[A], e:A) = xs.foldLeft(false) { (a, x) => a || { x == e } }}

// Function1 - Function with 1 Parameter
trait Function1[-T1, +R] extends AnyRef {
  def apply(v:T1):R
}

object ++ extends Function1[Int, Int] {
  def apply(p:Int):Int = p + 1
}

val ++ = (x:Int) => x + 1

object ++ extends (int => int) {
  def apply(p:Int):Int = p + 1
}

map(List(10, 20, 30), ++)

map(List(10, 20, 30), (x:Int) => x + 1)

map(List(10, 20, 30), new Function1[Int, Int] {
  def apply(p:Int) = p + 1
})

// composing functions
val addOne:Int => Int = x => x + 1
val addTwo:Int => Int = x => x + 2
val addThree = addOne compose addTwo
//similar to
val addThree:Int => Int = x => addOne(addTwo(x))

val mapping:collection.Map[String, String] = Map("Ron" -> "admin", "Sam" -> "Analyst")

// Working with List and ListBuffer
val language = Seq("Scala", "Haskell", "OCAML")
language(1)

val default:PartialFunction[Int, String] = {
  case _ => "Is it a functional Language?"
}
val languagesWithDefault = languages orElse default


// Working with set and sortedList
val frameworks = Set("Lift", "scala", "Akka", "Play")
frameworks contains "Lift"
frameworks("Lift")

// Working with Map and Tuple
val m = Map((1, "1st"), (2, "2nd"))
val m = Map(1 -> "1st", 2 -> "2nd")

def get(key:A):Option[B]
m.get(1)
m.get(3)

// For comprehension under the hood
case class Artist(name:String, genre:String)

val artists = List(Artist("dsada", "dsadasdas"),Artist("dsada", "dsadasdas"),Artist("dsada", "dsadasdas"),Artist("dsada", "dsadasdas"),Artist("dsada", "dsadasdas"),Artist("dsada", "dsadasdas"))

// Using withFilter but not Filter?
val list = List(1, 2, 3)
var go = true
val x = for (i <- list; if (go)) yield {
  go = false
  i
}
prinln(x)

case class Artist(name:String, genre:String)
case class ArtistWithAlbums(artist:Artist, albums:List[String])

val artistsWithAlbums = List(ArtistsWithAlbums(Artist("Ghost, "Metal"")))

for {
  ArtistWithAlbums(artist, albums) <- artistsWithAlbums
  album <- albums
  if(artist.genre == "Rock")
} yield album

artistWithAlbums flatMap {
  case ArtistWithAlbums(artist, albums) => album withFilter {
    album => artist.genre == "Rock"
  } map { case album => album  }
}

// When should you use Either rather than Option?
// Either returns left or right. Left is failure, right is Some
def throwableToLeft[T]{block: => T}:Either{Throwable, T} = try {
  Right(block)
  } catch {
  case ex Throwable => Left(ex)
  }
}

r match {
  case Left(e) => e.printStackTrace
  case Right(e) => println(e)
}

// Working Lazy Collections
// Strict Collections
List(1, 2, 3, 4).map(_ + 1).head

import scala.io._
import scala.xml.XML
def tweet(handle:String) = {
  println("Processing tweets for " + handle)

  val source = Source.fromURL(new java.net.URL("www.google.com"))
  val iterator = source.getLines()
  val builder = new StringBuilder
  for(line <- iterator) builder.append(line)
  XML.loadString(builder.toString)
}

val allTweets = Map("nraksdkada" -> tweets _ , "ManingBooks" -> tweets _, "bubble" -> tweets _)

// Working with Streams
List("zero", "one", "two", "three", "four").zip(Stream.from(0))

// Most common way to define fibonacci
def fib(n:Int):Int = n match {
  case 0 => 0
  case 1 => 1
  case n => fib(n - 1) + fib(n - 2)
}

val fib:Stream[Int] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail).map(t => t._1 + t._2)))

// Divide and Conquer with Paralel Collections
import scala.collection.parallel.immutable._
ParVector(10, 20, 30, 40, 50, 60).map(x => println(Thread.currentThread.getName); x/ 2}

// Implementations
// ForkJoinTaskSupport
// ThreadPoolTskSupport
// ExecutorContextTaskSupport

ParVector(10, 20, 30, 40, 50, 60).foldLeft(0) { (a,x) => println(Thread.currentThread.getName); a + x}

// convert between paralel and non paralel
val vs = Vector.range(1, 100000)
vs.par.filter(_ % 2 == 0)

Seq(Vector.range(1, 100000).par.filter(_ % 2 == 0))
