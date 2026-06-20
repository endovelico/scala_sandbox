import dispatch._
import Defaults._

object http_stuff {

  val request = url("222.google.com")
  val result = Http(request OK as.String)
}