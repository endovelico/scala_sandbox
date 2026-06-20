package com.example.design_patterns.behavioral

import scala.collection.mutable.ListBuffer


trait Observer[T] {

  def handleUpdate(subject:T)
}

trait Observable[T] {

  this:T =>
  private val observers = ListBuffer[Observer[T]] ()

  def addObservers(observer:Observer[T]): Unit = {
    observers.+=:(observer)
  }

  def notifyObservers():Unit = {
    observers.foreach(_.handleUpdate(this))
  }

}

case class User(name: String) extends Observer[Post] {

  override def handleUpdate(subject: Post): Unit = {
    System.out.println(s"Hey, I'm ${name}. The post got some new comments: ${subject.comments}")
  }
}

case class Comment(user: User, text: String)

case class Post(user: User, text: String) extends Observable[Post] {
  val comments = ListBuffer[Comment]()
  def addComment(comment: Comment): Unit = {
    comments.+=:(comment)
    notifyObservers()
  }
}

object PostExample extends LazyLogging {

  def main(args: Array[String]): Unit = {

    val userIvan = User("Ivan")
    val userMaria = User("Maria")
    val userJohn = User("John")

    logger.info("Create a post")

    val post = Post(userIvan, "This is a post about the observer design pattern")
      logger.info("Add a comment")

    post.addComment(Comment(userIvan, "I hope you like the post!"))
    logger.info("John and Maria subscribe to the comments.")

    post.addObserver(userJohn)
    post.addObserver(userMaria)
    logger.info("Add a comment")

    post.addComment(Comment(userIvan, "Why are you so quiet? Do you like it?"))
      logger.info("Add a comment")
      post.addComment(Comment(userMaria, "It is amazing! Thanks!"))
  }
}