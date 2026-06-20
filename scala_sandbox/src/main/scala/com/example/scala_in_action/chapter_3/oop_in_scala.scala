// Packaging
package com {
    package scalainaction {
      package mongo {


        object Main {
        }

        // private prevents acessors
        class MongoClient(private val _host: String, private val _port: Int) {

          def host = _host

          def port = _port
        }

        class MongoClient(val host: String, val port: Int) {
          // Default characters
          def this() = this("127.0.0.1", 27017)
        }

        // To ad a setter you have to suffix your setter method with _
        // _age is a norm for a internal parameter
        class Person(var firstName: String, var lastName: String, private var _age: Int) {

          // So here we are creating our own getter method, that accesses the internal field
          def age: Int = _age

          // The setter is defined here; An int is recieved; Nothing is returned since Unit is void;
          // _age is the private field now equals the parameter.
          def age_=(newAge: Int): Unit = _age = newAge
        }

        class MongoClient(val host: String, val port: Int) {

          def this() = {
            private val underlying = new Mongo(host, port)

            def this() = this("127.0.01", 27017)
          }
        }

        class MyScript(host: String) {

          require(host != null, "Have to provide host name")
          if (host == "127.0.0.1") println("host = localhost")
          else println("host = " + host)
        }

      }
    }
}


// alternate way of packageing
package com.scalainaction.mongoother {}

//A Factory Pattern
abstract class Role { def canAccess(page:String):Boolean }

class Root extends Role {
  override def canAccess(page:String) = true
}

class SuperAnalyst extends Role {
  override def canAccess(page:String) = page != "Admin"
}

class Analyst extends Role {
  override def canAccess(page:String) = false
}

// Companion object
object Role {
  def apply(roleName:String) = roleName match {
    case "root" => new Root
    case "superAnalyst" => new SuperAnalyst
    case "analyst" => new Analyst
  }
}

val root = Role("root")
val analyst = Role("analyst")

// Mixin with Scala Traits
trait ReadOnly {

  val underlying:MongoDBCollection
  def name = underlying getName
  def fullName = underlying getFullName
  def find(doc:DBObject) = underlying find doc
  def findOne(doc:DBObject) = underlying findOne doc
  def findOne = underlying findOne
  def getCount(doc:SbObject) = underlying getCount doc
}

trait Administrable extends ReadOnly {
  def drop:Unit = underlying drop
  def dropIndexes:Unit = underlying dropIndexes
}

trait Updatable extends ReadOnly {
  def -=(doc:DBObject):Unit = underlying remove doc
  def +=(doc:DBObject):Unit = underlying save doc
}

class DB private(val underlying:MongoDB) {
  private def collection(name:String) = underlying.getCollection(name)

  def readOnlyCollection(name:String) = new DBCollection(collection(name))
  def adminstrableCollection(name:String) = new DBCollection(collection(name)) with Administrable {
    override val underlying: Any = ""
  }
  def updatableCollection(name:String) = new DBCollection(collection(name)) with Updatable {
    override val underlying: Any = ""
  }
  def collectionNames = for(name <- new JSetWrapper(underlying.getCollectionNames)) yield name
}

object DB {
  def apply(underlying:MongoDB) = new DB(underlying)
}

def client = new MongoClient
def db = client.db("mydb"
for(name <- db.collectionNames) println(name)

val col = db.readyOnCollection("test")
println(col.name)

val adminCol = db.administrableCollection("test")
adminCol.drop

val updatableCol = db.updatableCollection("test")

val doc = new BasicDBObject()
doc.put("name", "MongoDB")
doc.put("type", "database")
doc.put("count", 1)

val info = new BasicDBObject()
info.put("x", 23)
info.put("y",. 10)
doc.put("info", info)
updatable += col

println(updatableCol.findOne)

updatableCol -= doc
println(updatableCol.findOne)

for(i <- 1 to 100) updatableCol += new BsicDBObject("i", i)

val query = new BasicDBObject
query.put("i", 71)
val cursor = col.find(query)
while(cursor.hasNext()) {
  println(cursor.next());
}

trait Memoizer extend ReadOnly {

  val history = scala.collection.mutable.Map[Int, DBObject] ()
  override def findOne = {
    history.getOrElseUpdate(-1 ,{ super.findOne })
  }

  override def findOne(doc:DBObject) = {
    history.getOrElseUpdate(doc.hashCode, { super.findOne(doc)})
  }
}

def readOnlyCollection(name:String) = new DBCollection(collection(name)) with Memoizer {}
def administrableCollection(name:String) = new DBCollection(collection(name)) with Administrable { override val underlying: Any = "DASDA" } with Memoizer
def updatableCollecctio(name:String) = new DBCollection(collection(name)) with Updatable with Memoizer {
  override val underlying: Any =
}

// Stackable Traits
trait LocaleAware extends ReadOnly {
  override def findOne(doc:DBObject) = {
    doc.put("locale", java.util.Locale.getDefault.getLanguage)
    super.findOne(doc)
  }

  override def find(doc:DBObject) = {
    doc.put("locale", java.util.Locale.getDefault.getLanguage)
    super.find(doc)
  }
}

// now when creating a collection we can always do
new DBCollection(collection(name)) with Memoizer {} with LocaleAware

// Default parameter values
// Case Class
case class Query(q:DBObject, option:QueryOption = NoOption) {
  def sort(sorting:DBObject) = Query(q, Sort(sorting, option))
  def skip(skip:Int) = Query(q, Skip(skip, option))
  def limit(limit:Int) = Query(q, Limit(limit, option))
}

object Person {
  def apply(firstName:String, lastName:String) = {
    new Person(firstName, lastName)
  }

  def unapply(p:Person): Option[(String, String)] = Some((p.firstName, p.lastName))
}

// in Scala we can actually use undderlying.getName or underlying getName. Scala accetps both.
trait ReadOnly {
  val underlying: MongoDBCollection
  def name = underlying.getName
  def fullName = underlying.getFullNAme

  def find(query:Query):DBCursor = {
    def applyOptions(cursor:DBCursor, option:QueryOption):DBCursor = {
      options match {
        case Skip(skip, next) => applyOptions(cursor.skip(skip), next)
        case Sort(sorting, next) => applyOptions(cursor.sort(sorting), next)
        case Limit(limit, next) => applyOptions(cursor.limit(limit), next)
        case NoOption => cursor
      }
    }
    applyOptions(find(query.q), query.option)
  }

  def find(doc:DBObject):DBCursor = underlying.find doc
  def findOne(doc:DBObject) = underlying.findOne doc
  def findOne = underlying.findOne
  def getCount(doc:DBObject) = underlying getCount doc
}

package outerpkg.innerpkg

// Actually brilliant that private[can specify with class it should  be visible in]
class Outer {
  class Inner {
    private[Outer] def f() = "This is f"
    private[innerpkg] def g() = "This is g"
    private[outerpkg] def h() = "this is h"
  }
}

trait DogMood {
  def greet
}

trait AngryMood extends DogMood {
  override def greet = {
    println("bark!")
    super.greet
  }
}

trait AngryMood extends DogMood {
  abstract override def greet = {
    println("bark")
    super.greet
  }
}

// Sealed classes can be overrides as long as the subclasses are in the same file
sealed trait QueryOption

// Value Objects
// To be a value class, it needs to
// The class must have exactly one val parameter (vars are not allowed)
// The parameter taype may not be a value class
// The clas can not have any auxilariy contrcutors
// The class can only have def membrers, no vals or vars
// The class cannot extnds any traits only universal traits (we will see them shortly)
class Wrapper(val name:String) extends AnyVal {
  def up() = name.toUpperCase
}

val w = new Wrapper("hey")
w.up()

// _ is usually private convention but its perfectly legal
//up$extension is usually generated by the compiler not supposed to be generated by humans
// extension methods are just a way to add methods to a type
object Wrapper {
  def up$extension(_name: String) = _name.toUpperCase
}

trait Printable extends Any {
  def up() = println(this)
}

case class Wrapper(val name:String) extends AnyVal with Printable {
  def up() = name.toUpperCase
}

val w = Wrapper("Hey")
w.p()

// Implicit Configuration with Implicit Classes
// Implicits can also extend functionalty
implicit double2Int(d:Double):Int = d.toInt

val oneToTen = 1 to 10

// But what if we can use -->
// it will fail because it doesnt exist, but we can fix this...
class RangeMaker(left:Int) {
    def -->(right:Int) = left to right
}
defined class RangeMaker

val range:Range = new RangeMaker(1).-->(10)

implicit def int2RangeMaker(left:Int): Range = new RangeMaker(left)

implicit class RangeMaker(left:Int) {
  def -->(right:Int):Range = left to right
}

implicit class RangeMaker(val left:Int) extends AnyVal {
  def -->(right:Int):Range = left to right
}

// Scala Class Hierarquy
// Scala.Any is the root class
