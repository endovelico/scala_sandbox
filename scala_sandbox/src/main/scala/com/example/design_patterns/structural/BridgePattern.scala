package com.example.design_patterns.structural

class BridgePattern {

  trait DrawingAPI {
    def drawCircle(x: Double, y: Double, radius: Double): Unit
  }

  class OpenGLAPI extends DrawingAPI {
    override def drawCircle(x: Double, y: Double, radius: Double): Unit =
      println(f"OpenGLAPI drawing circle at ($x%.1f, $y%.1f) with radius $radius%.1f")
  }

  class DirectXAPI extends DrawingAPI {
    override def drawCircle(x: Double, y: Double, radius: Double): Unit =
      println(f"DirectXAPI drawing circle at ($x%.1f, $y%.1f) with radius $radius%.1f")
  }

  abstract class Shape(protected val drawingAPI: DrawingAPI) {
    def draw(): Unit
    def resizeBy(factor: Double): Unit
  }

  class Circle(x: Double, y: Double, radius: Double, drawingAPI: DrawingAPI)
    extends Shape(drawingAPI) {

    private var cx = x
    private var cy = y
    private var r = radius

    override def draw(): Unit = drawingAPI.drawCircle(cx, cy, r)
    override def resizeBy(factor: Double): Unit = r *= factor
  }

  // Usage
  val openGLCircle = new Circle(1, 2, 3, new OpenGLAPI)
  val directXCircle = new Circle(5, 7, 11, new DirectXAPI)

  openGLCircle.draw()    // OpenGLAPI drawing circle at (1.0, 2.0) with radius 3.0
  directXCircle.draw()   // DirectXAPI drawing circle at (5.0, 7.0) with radius 11.0

  openGLCircle.resizeBy(2)
  openGLCircle.draw()    // OpenGLAPI drawing circle at (1.0, 2.0) with radius 6.0

}
