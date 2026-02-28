package com.example.design_patterns.behavioral

class MementoPattern {

  case class Memento(state: String)

  class TextEditor {
    private var content: String = ""

    def typeText(text: String): Unit = content += text
    def getContent: String = content

    def save(): Memento = Memento(content)
    def restore(memento: Memento): Unit = content = memento.state
  }

  class Caretaker {
    private var history: List[Memento] = List()

    def saveState(m: Memento): Unit = history = m :: history
    def undo(): Option[Memento] = history match {
      case head :: tail =>
        history = tail
        Some(head)
      case Nil => None
    }
  }

  val editor = new TextEditor
  val caretaker = new Caretaker

  editor.typeText("Hello, ")
  caretaker.saveState(editor.save())

  editor.typeText("world!")
  caretaker.saveState(editor.save())

  println(editor.getContent) // Hello, world!

  // Undo last change
  caretaker.undo().foreach(editor.restore)
  println(editor.getContent) // Hello,

  // Undo another change
  caretaker.undo().foreach(editor.restore)
  println(editor.getContent) // (empty string)

}
