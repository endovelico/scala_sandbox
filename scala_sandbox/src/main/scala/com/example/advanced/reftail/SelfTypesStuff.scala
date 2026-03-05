trait A {
  def foo(): Unit = println("foo from A")
}

trait B { self: A =>
  def bar(): Unit = {
    foo()
    println("bar from B")
  }
}

// ✅ Correct: mixing both
class C extends A with B

object TryingItOut extends App {
  val c = new C
  c.bar()
// Output:
// foo from A
// bar from B
}