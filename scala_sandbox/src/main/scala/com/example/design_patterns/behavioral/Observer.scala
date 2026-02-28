package com.example.design_patterns.behavioral

class Observer {

  trait Subject {
    private var observers: List[Observer] = List()

    def addObserver(observer: Observer): Unit = observers = observer :: observers
    def removeObserver(observer: Observer): Unit = observers = observers.filterNot(_ == observer)
    def notifyObservers(): Unit = observers.foreach(_.update(this))
  }

  trait Observer {
    def update(subject: Subject): Unit
  }

  class NewsAgency extends Subject {
    private var news: String = ""

    def setNews(news: String): Unit = {
      this.news = news
      notifyObservers()
    }

    def getNews: String = news
  }

  class NewsChannel(name: String) extends Observer {
    override def update(subject: Subject): Unit = subject match {
      case agency: NewsAgency =>
        println(s"$name received news: ${agency.getNews}")
      case _ => println(s"$name received unknown update")
    }
  }

  val agency = new NewsAgency
  val cnn = new NewsChannel("CNN")
  val bbc = new NewsChannel("BBC")

  agency.addObserver(cnn)
  agency.addObserver(bbc)

  agency.setNews("Scala 3 Released!")
  // Output:
  // CNN received news: Scala 3 Released!
  // BBC received news: Scala 3 Released!

  agency.removeObserver(cnn)
  agency.setNews("New Scala features!")
  // Output:
  // BBC received news: New Scala features!

}
