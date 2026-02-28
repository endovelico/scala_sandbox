package com.example.design_patterns.structural

class ProxyPattern {

  trait Image {
    def display(): Unit
  }

  class RealImage(fileName: String) extends Image {
    private def loadFromDisk(): Unit = println(s"Loading $fileName from disk")

    loadFromDisk() // expensive operation during instantiation

    override def display(): Unit = println(s"Displaying $fileName")
  }

  class ProxyImage(fileName: String) extends Image {
    private var realImage: Option[RealImage] = None

    override def display(): Unit = {
      if (realImage.isEmpty) {
        realImage = Some(new RealImage(fileName))
      }
      realImage.get.display()
    }
  }

  val image1: Image = new ProxyImage("photo1.jpg")
  val image2: Image = new ProxyImage("photo2.jpg")

  // Real image is loaded only when display is called
  image1.display()
  // Output:
  // Loading photo1.jpg from disk
  // Displaying photo1.jpg

  image1.display()
  // Output:
  // Displaying photo1.jpg (no reload)

  image2.display()
  // Output:
  // Loading photo2.jpg from disk
  // Displaying photo2.jpg

}
