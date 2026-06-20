package abstract.data.types {

  trait Calculator {

    def initialize: DBConnection
    def close(s:DBConnection):Unit
    def calculate(productId:String):Double = {
      val s = initialize
      val price = calculate(s, productId)
      close(s)
      price
    }
    def calculate(s:DBConnection, productId:String):Double
  }

  class CostPlusCalculator extends Calculator {

    type S = MongoClient
    def initialize = new MongoClient
    def close(dao:MongoClient) = dao.close

    def calculate(source:MongoClient, productId:String) = {

    }
  }

  class MongoClient {
    def close = {}
  }


  package selftypes {

    trait Connection {
      def query(q:String):String
    }

    trait Logger {
      def log(l:String):Unit
    }

    trait RequiredServices {
      def makeDatabaseConnection:Connection
      def logger:Logger
    }

    trait TestServices {
      def makeDatabaseConnection = new Connection {def query(q:String) = "test" }
      def logger = new Logger{def log(l:String) = println(l)}
    }

    trait ProductFinder {
      this:RequiredServices => def findProduct(productId:String) = {
        val c = makeDatabaseConnection
        c.query("find the lowest price")
        logger.log("querying database...")
      }
    }

    object FinderSystem extends ProductFinder with TestServices
  }


  // Abstract
  trait OrderingSystem {
    type O <: Order
    type I <: Inventory
    type S <: Shipping

    trait Order { def placeOrder (i:I):Unit }
    trait Inventory { def itemExists(order:O):Boolean }
    trait Shipping { def scheduleShipping(order:O):Long }

    trait Ordering { this:I with S => def placeOrder(o:O):Option[Long] = {
      if(itemExists(o)) {
        o.placeOrder(this)
        Some(scheduleShipping(o))
      }
      else None
    }
    }
  }

  object BookOrderingSystem extends OrderingSystem {

    type O = BookOrder
    type I = AmazonBookStore
    type S = UPS

    class BookOrder extends Order {
      def placeOrder(i:AmazonBookStore):Unit = {}
    }

    trait AmazonBookOrder extends Inventory {
      def itemExists(o:BookOrder) = {}
    }

    trait UPS extends Shipping {
      override def scheduleShipping(order: BookOrderingSystem.BookOrder): Long = {}
      }

    object BookOrdering extends Ordering with AmazonBookStore with UPS
    }

  }

  package extensible.component {

    case class Employee(name:String, id:Long)

    trait Payroll {
      def processEmployees(employees:Vector[Employee]):Either[String, Throwable]
      }

    class USPayroll extends Payroll {
      def processEmployees(employees:Vector[Employee]) = {}
    }

    class CanadaPayroll extends Payroll {
      override def processEmployees(employees: Vector[_root_.extensible.component.Employee]): Either[String, Throwable] =
    }

    class JapanPayroll extends Payroll {
      def processEmployees(employees:Vector[Employee])
    }

    case class Employee(name:String, id:Long)
    case class Contractor(name:String)

    trait Payroll extends super.Payroll {
      def processEmployees(employees: Vector[Employee]):Either[String, Throwable]
      def processContractors(contractors:Vector[Contractor]):Either[String, Throwable]
    }

    case class USPayroll {
      def accept(v:PayrollVisitor) = v.visit(this)
    }

    case class CanadaPayroll {
      def accept(v:PayrollVisitor) = v.visit(this)
    }

    trait PayrollVisitor {
      def visit(payroll:USPayroll):Either(String, Throwable)
      def visit(payroll:CanadaPayroll):Either(String, Throwable)
    }

    class EmployeePayrollVisitor extends PayrollVisitor {
      def visit(payroll:USPayroll):Either[String, Throwable] = {}
      def visit(payroll:CanadaPayroll):Either[String, Throwable] = {}
    }

    class ContractorPayrollVisitor extends PayrollVisitor {
      def visit(payroll:USPayroll):Either[String, Throwable] = {}
      def visit(payroll:CanadaPayroll):Either[String, Throwable] = {}
    }
  }

package solving.expression.problem {

  trait PayrollSystem {

    case class Employee(name:String, id:Long)
    type P <: Payroll
    trait Payroll {
      def processEmployees(employees:Vector[Employee]):Either[String, Throwable]
    }
    def processPayroll(p:P):Either[String, Throwable]
  }

  trait USPayrollSystem extends PayrollSystem {
    class USPayroll extends Payroll {
      def processEmployees(employees:Vector[Employee]) = Left("US payroll")
    }
  }

  trait CanadaPyrollSystem extends PayrollSystem {

    class CanadaPayroll extends Payroll {
      def processEnmployees(employees:Vector[Employee]) = Left("Canada Payroll")
    }
  }

  object USPayrollInstance extends USPayrollSystem {

    type p = USPayroll
    def processPayroll(p:USPayroll) = {
      val employees:Vector[Employee] = ...
      val result = p.processEmployees(employees)
    }
  }

  trait ContractorPAyrollSystem extends PayrollSystem {

    type P <: Payroll
    case class Contractor(name:String)
    trait Payroll extends super.Payroll {
      def processContractos(contractors:Vector[Contractor]):Either[String, Throwable]
    }
  }
}

package types {

  type Closable = {   def close:Unit   }
  def close(closabole: {def close:Unit}) = {
    closable.close
  }

  type Profile = {
  def name:String
  def address: String
  }

  val nilanjanProfile = new {
    def name = "Nilanjan"
    def address = "Boulder, CO"
  }

  trait Worker {
    def salary:BigDecicmal
    def bonusPErcentage:Double
  }

  trait HourlyWorker {
    def hours:Int
    def salary:BigDecimal
  }

  case class FullTimeWorker(val salary:BigDecimal) extends Worker
  case class PartTimeWorker(val hours:Int, val salary:BigDecicmal) extends HourlyWorker
  case class StudentWorker(val hours:Int, val salary:BigDecimal) extends HourlyWorker
}


package hkt {

  def fmap[A, B](xs:Vector[A], f:A => B): Vector[B] = xs map f
  def fmap[A, B](r:Option[A], f: A=> B): Option[B] = r map f

  trait Mapper[F[_]] {
    def fmap[A, B]{xs: F|A}, f:A => B): F[B]
  }
}

package types.projection {

  trait X {
    type E
  }
  type EE = X#E
}
Either.cond(true, "one", new RuntimeException)

package phantom_types {

  def addItem(item:String, o:Order) = Order (Some(item), o.shippintAddress)
  def addShipping(address:String, o:Order) = Order(o.itemId, some(Address)
    def placeOrder(o:Order) = {}

  sealed trait OrderCompleted
  sealed trait IncompleteOrder
  sealed trait ItemProvided
  sealed trait NoItem
  sealed trait AddressProvided
  sealed trait NoAddress

  case class Order[A, B, C](itemId:Option[String], shippingAddress:Option[String]))
  def emptyOrder = Order[IncompleteOrder, NoItem, No address](None, None)

}

package ad_hoc_poly {

  // adapter using poly
  case class Movie(name:String, year:Int, rating:Double)

  trait XmlConverter [A] {
    def toXml(a:A):String
  }

  object MovieXmlConverter extends XmlConverter[Movie] {
    def toXml(a:Movie) = "<movie></movie>"
  }
}

