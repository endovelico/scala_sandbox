package com.example.design_patterns.behavioral

class StatePattern {

  trait State {
    def handle(context: Context): Unit
  }

  class LockedState extends State {
    override def handle(context: Context): Unit = {
      println("Door is locked. Unlocking now...")
      context.setState(new UnlockedState)
    }
  }

  class UnlockedState extends State {
    override def handle(context: Context): Unit = {
      println("Door is unlocked. Locking now...")
      context.setState(new LockedState)
    }
  }

  class Context {
    private var state: State = new LockedState

    def setState(newState: State): Unit = state = newState

    def request(): Unit = state.handle(this)
  }

  val door = new Context

  door.request()
  // Output: Door is locked. Unlocking now...

  door.request()
  // Output: Door is unlocked. Locking now...

  door.request()
  // Output: Door is locked. Unlocking now...

}
