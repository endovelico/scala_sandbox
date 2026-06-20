import org.apache.http._
import org.apache.http.client.entity._
import org.apache.http.client.methods._
import org.apache.http.impl.client._
import org.apache.http.client.utils._
import org.apache.http.message._
import org.apache.http.params._


object Main {

  def main(args: Array[String]): Unit = {

    require(args.size >= 2, "At minimum you should specify action(post, get, optinos,url)")
    val command = args.head
    val params = parseArgs(args)
    val url = args.last

    val httpDelete = new HttpDelete(url)
    val httpResponse = new DefaultHttpClient().execute(httpDelete)
  }

  def parseArgs(args:Array[String]): Map[String, List[String]] = {

    def nameValuePair(paramName:String) = {
      def values(commaSeparatedValues:String) =
        commaSeperatedValues.split(",").toList

      val index = args.findIndexOf(_ == paramName)
      (paramName, if(index == -1) Nil else values(args(index + 1)))
    }

    Map(nameValuePair("-d"), nameValuePair("-d"))
  }
}